/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.history;

import es.unileon.ulebank.brokerage.InvestmentFund;
import java.util.Date;
import java.util.logging.Handler;

/**
 *
 * @author roobre
 */
public class FundTransaction extends Transaction {

    private final InvestmentFund fund;

    public FundTransaction(Handler id, double amount, Date date, String subject, Enum<TransactionType> type, InvestmentFund fund) {
        super(id, amount, date, subject, type);
        this.fund = fund;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", fund=" + fund;
    }

}
