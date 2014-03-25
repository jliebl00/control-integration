package es.unileon.ulebank.brokerage;

import java.util.ArrayList;
import es.unileon.ulebank.Account;

public class InvestmentAccount extends Account {

    private final ArrayList<StockPack> stockPacks;
    private final ArrayList<InvestmentFundPack> fundpacks;

    public InvestmentAccount() {
        this.stockPacks = new ArrayList<>();
        this.fundpacks = new ArrayList<>();
    }

    public void addStockPack(StockPack stockPack) {
        this.stockPacks.add(stockPack);
    }

    public void addInvestmentFundPack(InvestmentFundPack pack) {
        this.fundpacks.add(pack);
    }

    /**
     * @return the stockPacks
     */
    public ArrayList<StockPack> getStockPacks() {
        return stockPacks;
    }

}
