package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.brokerage.buyable.Buyable;

public class InvestmentFundPack extends Pack {

    public InvestmentFundPack(Buyable product, int amount, Account account, Employee operator, PackTransaction transaction) {
        super(product, amount, account, operator, transaction);
    }
}
