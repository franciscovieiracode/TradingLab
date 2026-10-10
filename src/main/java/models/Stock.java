package models;

import java.math.BigDecimal;

public class Stock {

    private String name;
    private BigDecimal bid;
    private BigDecimal ask;
    private float marketCap;

    public Stock(String name, BigDecimal bid, BigDecimal ask, float marketCap) {
        this.name = name;
        this.bid = bid;
        this.ask = ask;
        this.marketCap = marketCap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public float getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(float marketCap) {
        this.marketCap = marketCap;
    }
}
