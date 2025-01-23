import epn.fis.stockmanager.model.Stock;
import epn.fis.stockmanager.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockServiceProfitTest {

    private StockService stockService;

    @BeforeEach
    void setUp() {
        stockService = new StockService();
    }

    @Test
    void shouldReturnZeroProfit_WhenCurrentPriceIsZero() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(0.0);

        double profit = stockService.calculateProfit(stock);

        assertEquals(0.0, profit, "Profit should be zero when current price is zero.");
    }

    @Test
    void shouldReturnCorrectProfit_WhenCurrentPriceIsHigherThanPurchasePrice() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(200.0);

        double profit = stockService.calculateProfit(stock);

        assertEquals(500.0, profit, "Profit should be correctly calculated for a higher current price.");
    }

    @Test
    void shouldReturnCorrectLoss_WhenCurrentPriceIsLowerThanPurchasePrice() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(100.0);

        double profit = stockService.calculateProfit(stock);

        assertEquals(-500.0, profit, "Profit should reflect loss for a lower current price.");
    }

    @Test
    void shouldReturnZeroProfitPercentage_WhenCurrentPriceIsZero() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(0.0);

        double profitPercentage = stockService.calculateProfitPercentage(stock);

        assertEquals(0.0, profitPercentage, "Profit percentage should be zero when current price is zero.");
    }

    @Test
    void shouldReturnCorrectProfitPercentage_WhenCurrentPriceIsHigherThanPurchasePrice() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(200.0);

        double profitPercentage = stockService.calculateProfitPercentage(stock);

        assertEquals(33.33, Math.round(profitPercentage * 100.0) / 100.0,
                "Profit percentage should be correctly calculated for a higher current price.");
    }

    @Test
    void shouldReturnCorrectLossPercentage_WhenCurrentPriceIsLowerThanPurchasePrice() {
        Stock stock = new Stock("Apple Inc.", "AAPL", LocalDate.now(), 10, 150.0);
        stock.setCurrentPrice(100.0);

        double profitPercentage = stockService.calculateProfitPercentage(stock);

        assertEquals(-33.33, Math.round(profitPercentage * 100.0) / 100.0,
                "Profit percentage should reflect loss for a lower current price.");
    }
}