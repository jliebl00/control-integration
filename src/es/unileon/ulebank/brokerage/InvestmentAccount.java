package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.brokerage.buyable.InvalidBuyableException;
import es.unileon.ulebank.brokerage.buyable.InvestmentFund;
import es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException;
import es.unileon.ulebank.brokerage.pack.InvestmentFundPack;
import es.unileon.ulebank.brokerage.pack.PackTransaction;
import es.unileon.ulebank.brokerage.pack.StockPack;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.TransactionType;
import java.util.ArrayList;
import java.util.Date;

public class InvestmentAccount {

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
     * @throws es.unileon.ulebank.brokerage.buyable.InvalidBuyableException
     * @throws es.unileon.ulebank.account.exception.BalanceException
     * @throws es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException
     */
    public void buyStockage(Enterprise e, Account acc, int amount, Employee operator) throws InvalidBuyableException, BalanceException, NotEnoughParticipationsException {
        e.buy(amount);
        StockPack sp = new StockPack(e, amount, acc, e.getPPP(), new Date());
        stockPacks.add(sp);
        PackTransaction pt = new PackTransaction(null, amount, new Date(), "Compra de acciones.", TransactionType.OUT, sp, operator);
        stockHistory.add(pt);
        acc.addBalance((float) -(amount * e.getPrice()));
    }
    
    public void sellStockage(StockPack p, int amount, Employee operator) throws BalanceException, NotEnoughParticipationsException {
        p.sell(amount);
        PackTransaction pt = new PackTransaction(null, amount, new Date(), "Venta de acciones.", TransactionType.IN, p, operator);
        stockHistory.add(pt);
        p.getAccount().addBalance((float) (amount  * p.getProduct().getPPP()));
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
     * @throws es.unileon.ulebank.brokerage.buyable.InvalidBuyableException
     * @throws es.unileon.ulebank.account.exception.BalanceException
     * @throws es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException
     */
    public void buyInvestmentFund(InvestmentFund i, Account acc, int amount, Employee operator) throws InvalidBuyableException, BalanceException, NotEnoughParticipationsException {
        i.buy(amount);
        InvestmentFundPack ifp = new InvestmentFundPack(i, amount, acc);
        fundPacks.add(ifp);
        PackTransaction pt = new PackTransaction(null, amount, new Date(), "Compra de fondos de inversion.", TransactionType.OUT, ifp, operator);
        fundHistory.add(pt);
        acc.addBalance((float) -(amount * i.getPPP()));
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
