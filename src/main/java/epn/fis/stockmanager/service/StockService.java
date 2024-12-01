package epn.fis.stockmanager.service;

import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.dao.StockDAO;

public class StockService {

    private final StockDAO stockDAO;

    public StockService() {
        this.stockDAO = new StockDAO();
    }

    public void saveStock(Stock stock) {
        if (stockDAO.findById(stock.getId()) == null) {
            stockDAO.save(stock);
        } else {
            stockDAO.update(stock);
        }
    }
}
