package epn.fis.stockmanager.service;

import epn.fis.stockmanager.api.StockPriceFetcher;
import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.dao.StockDAO;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class for managing stock-related operations.
 * Handles business logic for creating, updating, deleting, and fetching stocks.
 */
public class StockService {

    private final StockDAO stockDAO;
    private final StockPriceFetcher stockPriceFetcher;

    /**
     * Initializes the StockService with necessary dependencies.
     */
    public StockService() {
        this.stockDAO = new StockDAO();
        this.stockPriceFetcher = new StockPriceFetcher();
    }

    /**
     * Saves or updates a stock in the database.
     *
     * @param stock The stock to save or update.
     */
    public void saveStock(Stock stock) {
        // If the stock id is 0 it's a new stock
        if (stock.getId() == 0) {
            stockDAO.save(stock);
        } else {
            stockDAO.update(stock);
        }
    }

    /**
     * Retrieves all stocks from the database.
     *
     * @return A list of all stocks.
     */
    public List<Stock> getAllStocks() {
        return stockDAO.findAll();
    }

    /**
     * Retrieves all stocks with updated prices from the external API.
     *
     * @return A list of stocks with updated prices.
     * @throws IOException If an error occurs while fetching prices.
     */
    public List<Stock> getAllStocksWithUpdatedPrices() throws IOException {
        List<Stock> stocks = getAllStocks();
        List<String> tickers = stocks.stream()
                .map(Stock::getTickerSymbol)
                .collect(Collectors.toList());

        Map<String, Double> prices = stockPriceFetcher.getStockPrices(tickers);

        for (Stock stock : stocks) {
            Double latestPrice = prices.get(stock.getTickerSymbol());
            if (latestPrice != null) {
                stock.setCurrentPrice(latestPrice);
                saveStock(stock);
            }
        }

        return stocks;
    }
}