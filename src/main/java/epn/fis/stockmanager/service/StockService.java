package epn.fis.stockmanager.service;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.dao.StockDAO;

import java.util.List;

public class StockService {

    private final StockDAO stockDAO;

    public StockService() {
        this.stockDAO = new StockDAO();
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
}