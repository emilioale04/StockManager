package epn.fis.stockmanager.controller;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StockController", value = "/stockController")
public class StockController extends HttpServlet {

    private StockService stockService;

    @Override
    public void init() throws ServletException {
        stockService = new StockService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        router(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        router(request, response);
    }

    private void router(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String route = (request.getParameter("route") == null) ? "listStocks" : request.getParameter("route");

        switch (route) {
            case "listStocks":
                listStocks(request, response);
                break;
            case "saveStock":
                saveStock(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
        }
    }

    private void listStocks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            stockService.updateAllStocksPrices();
        } catch (IOException e) {
            request.setAttribute("message", "Error al actualizar precios de las acciones.");
        }

        List<Stock> stocks = stockService.getAllStocks();
        stockService.updateProfitOrLoss(stocks);

        request.setAttribute("stocks", stocks);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    private void saveStock(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String companyName = request.getParameter("companyName");
            String tickerSymbol = request.getParameter("tickerSymbol");
            LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchaseDate"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice"));
            double currentPrice = request.getParameter("currentPrice") != null
                    ? Double.parseDouble(request.getParameter("currentPrice"))
                    : 0.0;

            Stock stock = new Stock(companyName, tickerSymbol, purchaseDate, quantity, purchasePrice);
            stock.setCurrentPrice(currentPrice);

            stockService.saveStock(stock);
        } catch (NumberFormatException | NullPointerException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetros inválidos para guardar el stock.");
            return;
        }

        response.sendRedirect("stockController?route=listStocks");
    }
}
