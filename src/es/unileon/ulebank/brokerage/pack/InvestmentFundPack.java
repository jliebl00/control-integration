package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.brokerage.buyable.Buyable;

public class InvestmentFundPack extends Pack {

    public InvestmentFundPack(Buyable product, int amount, Account account) {
        super(product, amount, account);
    }
}
