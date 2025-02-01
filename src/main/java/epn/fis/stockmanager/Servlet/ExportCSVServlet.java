package epn.fis.stockmanager.Servlet;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/exportCSV")
public class ExportCSVServlet extends HttpServlet {

    private final StockService stockService = new StockService(); // Servicio para obtener los datos

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"acciones_compradas.csv\"");

        try (PrintWriter writer = response.getWriter()) {
            // Encabezados del CSV
            writer.println("ID,Compañía,Símbolo,Fecha Compra,Cantidad,Precio de Compra,Último Precio Registrado,Profit/Loss (%),Profit/Loss ($),Comentarios");

            // Obtener la lista de acciones
            List<Stock> stocks = stockService.getAllStocks(); // Implementado en StockService

            for (Stock stock : stocks) {
                writer.printf("%d,%s,%s,%s,%d,%.2f,%.2f,%.2f,%.2f,%s%n",
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
        }
    }
}
