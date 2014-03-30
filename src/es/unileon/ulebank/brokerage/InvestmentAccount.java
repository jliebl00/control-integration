package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.Account;
import es.unileon.ulebank.Employee;
import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.brokerage.buyable.InvestmentFund;
import es.unileon.ulebank.brokerage.pack.InvestmentFundPack;
import es.unileon.ulebank.brokerage.pack.PackTransaction;
import es.unileon.ulebank.brokerage.pack.StockPack;
import es.unileon.ulebank.history.History;
import java.util.ArrayList;

public class InvestmentAccount extends Account {

    private final ArrayList<StockPack> stockPacks;
    private final ArrayList<InvestmentFundPack> fundPacks;

    private final History<PackTransaction> fundHistory;
    private final History<PackTransaction> stockHistory;

    public InvestmentAccount() {
        this.stockPacks = new ArrayList<>();
        this.fundPacks = new ArrayList<>();

        this.fundHistory = new History<>();
        this.stockHistory = new History<>();
    }

    /**
     * Builds a new StockPack, generates the transaction and adds it to the
     * history and withraws the money from the buyer's account.
     *
     * @param e Enterprise to buy stock from.
     * @param acc Account where the amount will be charged.
     * @param amount Amount of stockage to buy
     * @param operator Bank operator which performs the transaction (the one who
     * is logged in probably).
     */
    public void buyStockage(Enterprise e, Account acc, int amount, Employee operator) {
        /* TODO: Implement stockage buying:
         * - Add StockPack to list.
         * - Generate transaction.
         * - Withdraw lulz.
         */
    }
    
    public void sellStockage(StockPack p, int amount, Employee operator) {
        /* TODO: Implement stockage selling:
         * - Modify StockPack.
         * - Generate transaction.
         * - Compute the net profit and charge to corresponding account.
         */
    }

    /**
     * Builds a new InvestmentFundPack, generates the transaction and adds it to the
     * history and withraws the money from the buyer's account.
     *
     * @param i InvestmentFund to buy stock from.
     * @param acc Account where the amount will be charged.
     * @param amount Number of participations to buy
     * @param operator Bank operator which performs the transaction (the one who
     * is logged in probably).
     */
    public void buyInvestmentFund(InvestmentFund i, Account acc, int amount, Employee operator) {
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

    /**
     * @return the fundPacks
     */
    public ArrayList<InvestmentFundPack> getFundPacks() {
        return fundPacks;
    }

    /**
     * @return the fundHistory
     */
    public History<PackTransaction> getFundHistory() {
        return fundHistory;
    }

    /**
     * @return the stockHistory
     */
    public History<PackTransaction> getStockHistory() {
        return stockHistory;
    }

}
