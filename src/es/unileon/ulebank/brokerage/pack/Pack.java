/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.brokerage.buyable.Buyable;

/**
 *
 * @author roobre
 */
public abstract class Pack {

    protected final Buyable product;

    protected final int amount;
    protected final Account account;

    public Pack(Buyable product, int amount, Account account) {
        this.product = product;
        this.amount = amount;
        this.account = account;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @return the product
     */
    public Buyable getProduct() {
        return product;
    }

}
