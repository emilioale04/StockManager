package epn.fis.stockmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Represents a stock purchase entity with details about the purchase and the current status.
 */
@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Column(name = "ticker_symbol", nullable = false, length = 10)
    private String tickerSymbol;

    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;

    @Column(name = "current_price")
    private Double currentPrice;

    @Transient
    private Double profitOrLoss;

    @Transient
    private Double profitOrLossPercentage;

    @Column(name = "archived")
    private boolean archived;

    // Constructors
    public Stock() {
    }

    public Stock(String companyName, String tickerSymbol, LocalDate purchaseDate, int quantity, double purchasePrice) {
        this.companyName = companyName;
        this.tickerSymbol = tickerSymbol;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.archived = false;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(double profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public Double getProfitOrLossPercentage() {
        return profitOrLossPercentage;
    }


    public void setProfitOrLossPercentage(double profitOrLossPercentage) {
        this.profitOrLossPercentage = profitOrLossPercentage;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isArchived() {
        return archived;
    }
}