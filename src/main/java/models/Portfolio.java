package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private String name;
    private LocalDate lastUpdated;
    private List<StockPosition> stockPositionList;
    private BigDecimal totalBalance;
    private BigDecimal freeBalance;
    private BigDecimal investedBalance;

    public Portfolio(String name) {
        this.name = name;
        this.totalBalance = BigDecimal.valueOf(0);
        this.freeBalance = BigDecimal.valueOf(0);
        this.investedBalance = BigDecimal.valueOf(0);
        this.stockPositionList = new ArrayList<>();
        this.lastUpdated = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInvestedBalance() {
        return investedBalance;
    }

    public BigDecimal getFreeBalance() {
        return freeBalance;
    }

    public BigDecimal getTotalBalance() {
        return freeBalance.add(investedBalance);
    }

    public List<StockPosition> getStockPositionList() {
        return stockPositionList;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated() {
        this.lastUpdated = LocalDate.now();
    }
}
