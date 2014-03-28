/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.history;

import es.unileon.ulebank.brokerage.buyable.Enterprise;
import java.util.Date;
import java.util.logging.Handler;

/**
 *
 * @author roobre
 */
public class StockTransaction extends Transaction {

    private final Enterprise enterprise;

    public StockTransaction(Handler id, double amount, Date date, String subject, Enum<TransactionType> type, Enterprise ent) {
        super(id, amount, date, subject, type);
        this.enterprise = ent;
    }

    @Override
    public String toString() {
        return super.toString() + ", stock=" + enterprise;
    }

}
