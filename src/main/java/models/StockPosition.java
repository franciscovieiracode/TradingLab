package models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StockPosition {

    private Stock stock;
    private LocalDate date;
    private int quantity;
    private BigDecimal totalValue;

    public StockPosition(Stock stock, int quantity) {
        this.stock = stock;
        this.quantity = quantity;
        this.date = LocalDate.now();
        this.totalValue = stock.getAsk().multiply(BigDecimal.valueOf(quantity));
    }



}
