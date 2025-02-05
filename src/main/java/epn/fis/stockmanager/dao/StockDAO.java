package epn.fis.stockmanager.dao;

import epn.fis.stockmanager.config.HibernateConfig;
import epn.fis.stockmanager.model.Stock;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

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

    /**
     * Retrieves a list of archived stock records from the database.
     *
     * @return A list of archived Stock entities.
     */
    public List<Stock> findArchivedStocks() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Stock> query = session.createQuery("FROM Stock WHERE archived = :archived", Stock.class);
            query.setParameter("archived", true);
            return query.getResultList();
        }
    }

    /**
     * Retrieves a list of non-archived stock records from the database.
     *
     * @return A list of non-archived Stock entities.
     */
    public List<Stock> findNonArchivedStocks() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Stock> query = session.createQuery("FROM Stock WHERE archived = :archived", Stock.class);
            query.setParameter("archived", false);
            return query.getResultList();
        }
    }

    public List<Stock> findBySymbol(String tickerSymbol) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Stock> query = session.createQuery("FROM Stock WHERE tickerSymbol = :tickerSymbol", Stock.class);
            query.setParameter("tickerSymbol", tickerSymbol);
            return query.getResultList();
        }
    }
}