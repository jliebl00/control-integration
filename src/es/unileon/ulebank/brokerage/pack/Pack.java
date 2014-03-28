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
    protected final Employee operator;
    protected final PackTransaction transaction;

    public Pack(Buyable product, int amount, Account account, Employee operator, PackTransaction transaction) {
        this.product = product;
        this.amount = amount;
        this.account = account;
        this.operator = operator;
        this.transaction = transaction;
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
     * @return the operator
     */
    public Employee getOperator() {
        return operator;
    }

    /**
     * @return the transaction
     */
    public PackTransaction getTransaction() {
        return transaction;
    }

    /**
     * @return the product
     */
    public Buyable getProduct() {
        return product;
    }

}
