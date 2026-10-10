package models;

import java.math.BigDecimal;

public class Stock {

    private String name;
    private String ticker;
    private BigDecimal bid;
    private BigDecimal ask;
    private long marketCap;

    public Stock(String name, String ticker, BigDecimal bid, BigDecimal ask, long marketCap) {
        this.name = name;
        this.ticker = ticker;
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

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
