package models;

import enums.AccountPlanEnum;
import exceptions.InsufficientBalanceException;

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
    private AccountPlanEnum accountPlanEnum;

    public Portfolio(String name) {
        this.name = name;
        this.totalBalance = BigDecimal.valueOf(0);
        this.freeBalance = BigDecimal.valueOf(0);
        this.investedBalance = BigDecimal.valueOf(0);
        this.stockPositionList = new ArrayList<>();
        this.lastUpdated = LocalDate.now();
        this.accountPlanEnum = AccountPlanEnum.BASIC;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "name='" + name + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", totalBalance=" + getTotalBalance() +
                ", freeBalance=" + freeBalance +
                ", investedBalance=" + investedBalance +
                ", accountPlanEnum=" + accountPlanEnum +
                '}';
    }

    public void printPositions(){

        for (StockPosition stockPosition: stockPositionList){
            System.out.println("Stock: " + stockPosition.getStock().getName()+"\n" +
                    "Ticker " + stockPosition.getStock().getTicker() + "\n" +
                    "Bough Price "+stockPosition.getBoughPrice() + "\n" +
                    "Quantity " + stockPosition.getQuantity());

            ;
        }


    }

    public BigDecimal deposit(float amount){

        if (amount < 0){
            throw new IllegalArgumentException();
        }

        freeBalance = freeBalance.add(BigDecimal.valueOf(amount));

        return freeBalance;
    }

    public void buy(Stock stock, int quantity){

        if (quantity < 1){
            throw new IllegalArgumentException();
        }

        //total needed + commission
        BigDecimal totalNeededWithoutCommission = stock.getAsk().multiply(BigDecimal.valueOf(quantity));

        BigDecimal totalNeeded = totalNeededWithoutCommission.add(calculateCommission(stock, quantity));

        if (totalNeeded.compareTo(freeBalance) > 0) {
            throw new InsufficientBalanceException("Insufficient Cash");
        }

        StockPosition stockPosition = new StockPosition(stock, quantity);

        stockPositionList.add(stockPosition);

        investedBalance = investedBalance.add(totalNeededWithoutCommission);
        lastUpdated = LocalDate.now();
        freeBalance = freeBalance.subtract(totalNeeded);

    }

    private BigDecimal calculateCommission(Stock stock, int quantity){

        BigDecimal totalCommission = null;

        switch (accountPlanEnum){
            case BASIC -> {

                BigDecimal commission = stock.getAsk().multiply(BigDecimal.valueOf(quantity)).multiply(BigDecimal.valueOf(0.005));

                if (commission.compareTo(BigDecimal.valueOf(1)) > 0 ){
                    totalCommission = commission;
                    break;
                }

                totalCommission = BigDecimal.valueOf(1);
            }
            case PRO -> {
                BigDecimal commission = stock.getAsk().multiply(BigDecimal.valueOf(quantity)).multiply(BigDecimal.valueOf(0.001));

                if (commission.compareTo(BigDecimal.valueOf(0.5)) > 0 ){
                    totalCommission = commission;
                    break;
                }

                totalCommission = BigDecimal.valueOf(1);
            }
        }

        return totalCommission;
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
