/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.Employee;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionException;
import es.unileon.ulebank.history.TransactionType;
import java.util.Date;

/**
 *
 * @author roobre
 */
public class PackTransaction extends Transaction {

    private final Pack pack;
    private final Employee operator;

    public PackTransaction(double amount, Date date, String subject, Pack pack, Employee operator) throws TransactionException {
        super(amount, date, subject);

        this.pack = pack;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return super.toString() + ", pack=" + this.pack + ", operator=" + this.operator;
    }

}
