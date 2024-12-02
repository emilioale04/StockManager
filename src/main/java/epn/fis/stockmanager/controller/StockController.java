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
     * Handles POST requests for saving stocks.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException      If an input or output error is detected.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleSaveAction(request);

        refreshStocks(request, response, stockService);
    }

    /**
     * Refreshes the stock data by updating prices, recalculating profit/loss,
     * and forwarding the updated list to the JSP.
     *
     * @param request  The HttpServletRequest object containing the client request.
     * @param response The HttpServletResponse object for sending the response to the client.
     * @param stockService The StockService instance used for stock-related operations.
     * @throws ServletException If an error occurs during the request dispatching.
     * @throws IOException      If an input or output error occurs.
     */
    static void refreshStocks(HttpServletRequest request, HttpServletResponse response,
                              StockService stockService) throws ServletException, IOException {
        try{
            // Update the stock prices after saving a stock
            stockService.updateAllStocksPrices();
        } catch (IOException e) {
            request.setAttribute("message", "error");
        }

        List<Stock> stocks = stockService.getAllStocks();
        stockService.updateProfitOrLoss(stocks);
        request.setAttribute("stocks", stocks);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * Handles GET requests to retrieve and display all stocks.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException If an error occurs during the request processing.
     * @throws IOException      If an input or output error is detected.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Stock> stocks = stockService.getAllStocks();
        stockService.updateProfitOrLoss(stocks);
        request.setAttribute("stocks", stocks);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * Handles the save action from the request.
     *
     * @param request The HttpServletRequest object.
     */
    private void handleSaveAction(HttpServletRequest request) {
        String companyName = request.getParameter("companyName");
        String tickerSymbol = request.getParameter("tickerSymbol");
        LocalDate purchaseDate = LocalDate.parse(request.getParameter("purchaseDate"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double purchasePrice = Double.parseDouble(request.getParameter("purchasePrice"));
        double currentPrice = request.getParameter("currentPrice") != null
                ? Double.parseDouble(request.getParameter("currentPrice"))
                : 0.0;
        String comments = request.getParameter("comments");

        Stock stock = new Stock(companyName, tickerSymbol, purchaseDate, quantity, purchasePrice);
        stock.setCurrentPrice(currentPrice);
        stock.setComments(comments);

        stockService.saveStock(stock);
    }
}