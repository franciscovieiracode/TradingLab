package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StockPosition {

    private Stock stock;
    private LocalDate date;
    private int quantity;
    private BigDecimal boughPrice;
    private BigDecimal totalValue;

    public StockPosition(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
        this.date = LocalDate.now();
        this.boughPrice = stock.getAsk();
        this.totalValue = stock.getAsk().multiply(BigDecimal.valueOf(quantity));
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getBoughPrice() {
        return boughPrice;
    }

    public void setBoughPrice(BigDecimal boughPrice) {
        this.boughPrice = boughPrice;
    }
}
