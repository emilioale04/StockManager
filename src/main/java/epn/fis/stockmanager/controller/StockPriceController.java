package epn.fis.stockmanager.controller;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StockPriceController", value = "/updatePrices")
public class StockPriceController extends HttpServlet {

    private StockService stockService;

    @Override
    public void init() throws ServletException {
        stockService = new StockService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Stock> stocks = stockService.getAllStocksWithUpdatedPrices();
        request.setAttribute("stocks", stocks);

        // Forwarding to the stock servlet to display the updated stock list
        request.getRequestDispatcher("stock").forward(request, response);
    }
}
