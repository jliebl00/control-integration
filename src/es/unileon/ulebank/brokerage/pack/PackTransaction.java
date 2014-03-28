/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import java.util.Date;
import java.util.logging.Handler;

/**
 *
 * @author roobre
 */
public class PackTransaction extends Transaction {

    private final Pack pack;

    public PackTransaction(Handler id, double amount, Date date, String subject, Enum<TransactionType> type, Pack pack) {
        super(id, amount, date, subject, type);

        this.pack = pack;
    }

    @Override
    public String toString() {
        return super.toString() + ", pack=" + this.pack;
    }

}
