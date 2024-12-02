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

/**
 * Controller for updating stock prices.
 * Fetches updated prices and forwards the updated list of stocks.
 */
@WebServlet(name = "StockPriceController", value = "/updatePrices")
public class StockPriceController extends HttpServlet {

    private StockService stockService;

    /**
     * Initializes the StockService instance.
     *
     * @throws ServletException If an error occurs during initialization.
     */
    @Override
    public void init() throws ServletException {
        stockService = new StockService();
    }

    /**
     * Handles GET requests to update stock prices.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException      If an input or output error is detected.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StockController.refreshStocks(request, response, stockService);
    }
}