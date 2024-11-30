package epn.fis.stockmanager.model;

import javax.persistence.*;
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
    private double purchasePrice;
    @Column(name = "current_price")
    private double currentPrice;
    @Column(name = "comments")
    private String comments;

    // Constructors
    public Stock() {
    }

    public Stock(String companyName, String tickerSymbol, LocalDate purchaseDate, int quantity, double purchasePrice) {
        this.companyName = companyName;
        this.tickerSymbol = tickerSymbol;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
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

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
