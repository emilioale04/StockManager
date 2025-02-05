package epn.fis.stockmanager.controller;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/exportCSV")
public class ExportCSVController extends HttpServlet {

    private final StockService stockService = new StockService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"acciones_compradas.csv\"");

        List<Stock> stocks = stockService.getNonArchivedStocks();
        stockService.updateProfitOrLoss(stocks);

        if (stocks.isEmpty()) {
            response.getWriter().write("No hay datos disponibles.");
            return;
        }

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("ID", "Compania", "Simbolo", "Fecha Compra", "Cantidad",
                        "Precio de Compra", "Ultimo Precio Registrado",
                        "Profit/Loss (%)", "Profit/Loss ($)")
                .build();

        try (PrintWriter writer = response.getWriter();
             CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat)) {

            for (Stock stock : stocks) {
                csvPrinter.printRecord(
                        stock.getId(),
                        stock.getCompanyName(),
                        stock.getTickerSymbol(),
                        stock.getPurchaseDate(),
                        stock.getQuantity(),
                        stock.getPurchasePrice(),
                        stock.getCurrentPrice() != null ? stock.getCurrentPrice() : 0.0,
                        stock.getProfitOrLossPercentage() != null ? stock.getProfitOrLossPercentage() : 0.0,
                        stock.getProfitOrLoss() != null ? stock.getProfitOrLoss() : 0.0
                );
            }

            csvPrinter.flush();
        }
    }
}