package es.unileon.ulebank.brokerage;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.account.exception.BalanceException;
import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.brokerage.buyable.InvalidBuyableException;
import es.unileon.ulebank.brokerage.buyable.InvestmentFund;
import es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException;
import es.unileon.ulebank.brokerage.pack.InvestmentFundPack;
import es.unileon.ulebank.brokerage.pack.Pack;
import es.unileon.ulebank.brokerage.pack.PackTransaction;
import es.unileon.ulebank.brokerage.pack.StockPack;
import es.unileon.ulebank.fees.DefaultFeeProvider;
import es.unileon.ulebank.fees.FeeStrategy;
import es.unileon.ulebank.history.History;
import es.unileon.ulebank.history.TransactionType;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvestmentAccount {

    private final ArrayList<Pack> stockPacks;
    private final ArrayList<Pack> fundPacks;
    private final History<PackTransaction> history;
    private final FeeStrategy buyStockageFee, sellStockageFee;

    public InvestmentAccount() {
        this.stockPacks = new ArrayList<>();
        this.fundPacks = new ArrayList<>();

        this.history = new History<>();

        this.buyStockageFee = DefaultFeeProvider.getInstance().getDefaultFee();
        this.sellStockageFee = DefaultFeeProvider.getInstance().getDefaultFee();
    }

    /**
     * Builds a new StockPack, generates the transaction and adds it to the
     * history and withraws the money from the buyer's account.
     *
     * @param e
     * @param acc Account where the amount will be charged.
     * @param amount Amount of stockage to buy
     * @param operator Bank operator which performs the transaction (the one who
     * is logged in probably).
     * @throws es.unileon.ulebank.brokerage.buyable.InvalidBuyableException
     * @throws es.unileon.ulebank.account.exception.BalanceException
     * @throws
     * es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException
     */
    public void buyStockage(Enterprise e, Account acc, int amount, Employee operator) throws InvalidBuyableException, BalanceException, NotEnoughParticipationsException {
        StockPack p = e.buy(amount, operator);
        p.setAccount(acc);
        stockPacks.add(p);

        double price = amount * e.getPPP();
        acc.addBalance((float) price); // Price
        acc.addBalance((float) this.buyStockageFee.getFee(price)); // Fee
        this.history.add(new PackTransaction(price, new Date(), "Compra de acciones.", TransactionType.OUT, p, operator));
    }

    public void sellStockage(StockPack p, int amount, Employee operator) throws NotEnoughParticipationsException {
        if (p.getAmount() < amount) {
            throw new NotEnoughParticipationsException();
        }

        p.setAmount(p.getAmount() - amount);

        try {
            double price = p.getProduct().getPPP() * amount;
            p.getAccount().addBalance((float) price);
            p.getAccount().addBalance((float) this.sellStockageFee.getFee(price));
            this.history.add(new PackTransaction(price, new Date(), "Venta de acciones.", TransactionType.IN, p, operator));
        } catch (BalanceException ex) {
            Logger.getLogger(InvestmentAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.prunePacks();
    }

    public void buyInvestmentFund(InvestmentFund i, Account acc, int amount, Employee operator) throws InvalidBuyableException, BalanceException, NotEnoughParticipationsException {
        InvestmentFundPack ifp = i.buy(amount, operator);
        fundPacks.add(ifp);
        double price = amount * i.getPPP();
        acc.addBalance((float) price); // Price
        acc.addBalance((float) this.buyStockageFee.getFee(price)); // Fee
        this.history.add(new PackTransaction(price, new Date(), "Compra de fondos.", TransactionType.OUT, ifp, operator));
    }

    /**
     * @return the fundHistory
     */
    public History<PackTransaction> getHistory() {
        return history;
    }

    private void prunePacks() {
        // TODO: Delete 0-participations packs.
    }
}
