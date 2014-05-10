package src.es.unileon.ulebank.assets.strategy.loan;

import java.util.ArrayList;

import src.es.unileon.ulebank.assets.Loan;
import src.es.unileon.ulebank.assets.support.PaymentPeriod;


/**
 * Interface for implement the strategy pattern over method of of calculate interest.
 * 
 * 
 * v1.0 Initial version
 */
public interface StrategyLoan {
	
	public ArrayList<ScheduledPayment> doCalculationOfPayments();
}
