package org.example;

import models.Portfolio;
import models.Stock;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Portfolio portfolio = new Portfolio("Portfolio Bravo");
        portfolio.deposit(1000);
        System.out.println(portfolio.getFreeBalance());
        Stock nvidia = new Stock("Nvidia Corp.", "NVDA", new BigDecimal("202.2"), new BigDecimal("202.4"), 5000000000L);
        Stock microsoft = new Stock("Microsoft", "MSFT", new BigDecimal("530.2"), new BigDecimal("530.4"), 2000000000L);

        portfolio.buy(nvidia, 2);

        portfolio.printPositions();

        nvidia.setAsk(BigDecimal.valueOf(200.5));

        portfolio.printPositions();
    }
}
