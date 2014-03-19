package es.unileon.ulebank.brokerage;

import java.util.ArrayList;
import es.unileon.ulebank.Account;

public class InvestmentAccount extends Account {
    
    private final ArrayList<StockPack> stockPacks;
    
    public InvestmentAccount() {
        this.stockPacks = new ArrayList<>();
    }

    public void addStockPack(StockPack stockPack) {
        this.stockPacks.add(stockPack);
    }
    
    /**
     * @return the stockPacks
     */
    public ArrayList<StockPack> getStockPacks() {
        return stockPacks;
    }
    
}
