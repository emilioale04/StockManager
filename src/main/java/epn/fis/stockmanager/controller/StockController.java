package epn.fis.stockmanager.controller;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "StockController", value = "/stock")
public class StockController extends HttpServlet {

    private StockService stockService;

    @Override
    public void init() throws ServletException {
        stockService = new StockService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String companyName = request.getParameter("companyName");
        String tickerSymbol = request.getParameter("tickerSymbol");
        LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchaseDate"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice"));
        String comments = request.getParameter("comments");

        // Default current price, update after
        double currentPrice = 0.0;

        Stock stock = new Stock(companyName, tickerSymbol, purchaseDate, quantity, purchasePrice);
        stock.setCurrentPrice(currentPrice);
        stock.setComments(comments);

        stockService.saveStock(stock);

        response.sendRedirect("stock");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Stock> stocks = stockService.getAllStocks();
        request.setAttribute("stocks", stocks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
