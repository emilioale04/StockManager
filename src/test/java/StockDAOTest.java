import epn.fis.stockmanagement.config.HibernateConfig;
import epn.fis.stockmanagement.dao.StockDAO;
import epn.fis.stockmanagement.model.Stock;

import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for StockDAO.
 * Ensures proper functionality of the DAO layer for Stock entity.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockDAOTest {

    private StockDAO stockDAO;

    /**
     * Sets up the test environment by initializing the DAO instance.
     */
    @BeforeAll
    public void setup() {
        stockDAO = new StockDAO();
    }

    /**
     * Cleans up resources and shuts down Hibernate after all tests.
     */
    @AfterAll
    public void teardown() {
        HibernateConfig.shutdown();
    }

    /**
     * Test case to verify saving a valid stock.
     */
    @Test
    @Order(1)
    public void shouldSaveStock_WhenValidStockProvided() {
        Stock stock = new Stock("Example", "AAPL", LocalDate.now(), 10, 150.0);
        stockDAO.save(stock);
        assertNotNull(stock.getId(), "Stock ID should not be null after saving");

        // Cleanup
        stockDAO.delete(stock);
    }

    /**
     * Test case to verify finding a stock by its ID.
     */
    @Test
    @Order(2)
    public void shouldFindStock_WhenStockIdExists() {
        Stock stock = new Stock("Example", "TSLA", LocalDate.now(), 5, 600.0);
        stockDAO.save(stock);
        Stock retrievedStock = stockDAO.findById(stock.getId());
        assertNotNull(retrievedStock, "Retrieved stock should not be null");
        assertEquals("TSLA", retrievedStock.getTickerSymbol(),
                "Ticker symbol should match");

        // Cleanup
        stockDAO.delete(stock);
    }

    /**
     * Test case to verify retrieving all stocks when multiple stocks exist.
     */
    @Test
    @Order(3)
    public void shouldFindAllStocks_WhenMultipleStocksExist() {
        Stock stock1 = new Stock("Example", "MSFT", LocalDate.now(), 20, 300.0);
        Stock stock2 = new Stock("Example", "GOOGL", LocalDate.now(), 15, 2800.0);
        stockDAO.save(stock1);
        stockDAO.save(stock2);
        List<Stock> stocks = stockDAO.findAll();
        assertTrue(stocks.size() >= 2, "FindAll should return at least 2 stocks");

        // Cleanup
        stockDAO.delete(stock1);
        stockDAO.delete(stock2);
    }

    /**
     * Test case to verify updating stock details.
     */
    @Test
    @Order(4)
    public void shouldUpdateStock_WhenStockDetailsModified() {
        Stock stock = new Stock("Example", "AMZN", LocalDate.now(), 8, 3300.0);
        stockDAO.save(stock);
        stock.setQuantity(10);
        stock.setCurrentPrice(3500.0);
        stockDAO.update(stock);
        Stock updatedStock = stockDAO.findById(stock.getId());
        assertEquals(10, updatedStock.getQuantity(), "Quantity should be updated");
        assertEquals(3500.0, updatedStock.getCurrentPrice(), "Current price should be updated");

        // Cleanup
        stockDAO.delete(stock);
    }

    /**
     * Test case to verify deleting a stock.
     */
    @Test
    @Order(5)
    public void shouldDeleteStock_WhenStockExists() {
        Stock stock = new Stock("Example", "NFLX", LocalDate.now(), 12, 500.0);
        stockDAO.save(stock);
        stockDAO.delete(stock);
        Stock deletedStock = stockDAO.findById(stock.getId());
        assertNull(deletedStock, "Deleted stock should not be found");
    }
}
