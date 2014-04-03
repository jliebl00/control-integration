package es.unileon.assets.strategy.loan;

import java.util.ArrayList;

/**
 * Interface for implement the strategy pattern over method of of calculate interest.
 * 
 * 
 * v1.0 Initial version
 */
public abstract class StrategyBaseLoan {
	protected double capital;
	protected double interests;
	protected int amortizationTime;
	
	protected ArrayList<ScheduledPayment> payments;
	
	public abstract void CalculateInterest();
	
	public ArrayList<ScheduledPayment> getPayments(){
		return this.payments;
	}
}
