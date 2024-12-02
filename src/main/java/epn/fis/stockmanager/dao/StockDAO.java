package epn.fis.stockmanager.dao;

import epn.fis.stockmanager.model.Stock;

/**
 * DAO for managing Stock entities.
 * Extends the generic BaseDAO to provide specific operations for the Stock entity.
 */
public class StockDAO extends BaseDAO<Stock> {

    /**
     * Initializes the StockDAO with the Stock entity class.
     */
    public StockDAO() {
        super(Stock.class);
    }
}