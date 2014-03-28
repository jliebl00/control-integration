package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.brokerage.buyable.InvestmentFund;
import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.brokerage.pack.StockPack;
import es.unileon.ulebank.brokerage.pack.InvestmentFundPack;
import es.unileon.ulebank.Account;
import es.unileon.ulebank.history.FundTransaction;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.StockTransaction;
import java.util.ArrayList;

public class InvestmentAccount extends Account {

    private final ArrayList<StockPack> stockPacks;
    private final ArrayList<InvestmentFundPack> fundPacks;

    private final History<FundTransaction> transactionHistory;
    private final History<StockTransaction> stockHistory;

    public InvestmentAccount() {
        this.stockPacks = new ArrayList<>();
        this.fundPacks = new ArrayList<>();

        this.transactionHistory = new History<>();
        this.stockHistory = new History<>();
    }

    public void buyStockage(Enterprise e, Account acc) {
        /* TODO: Implement stockage buying:
         * - Add StockPack to list.
         * - Generate transaction.
         * - Withdraw lulz.
         */
    }

    public void buyInvestmentFund(InvestmentFund i, Account acc) {
        /* TODO: Implement investment funds buying:
         * - Add InvestmentFundPack to list.
         * - Generate transaction.
         * - Withdraw lulz.
         */
    }

    /**
     * @return the stockPacks
     */
    public ArrayList<StockPack> getStockPacks() {
        return stockPacks;
    }

}
