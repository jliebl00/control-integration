package es.unileon.assets.FinancialProducts;

/**
 * Interface with the method that the specific classes need for implementing
 * 
 * 
 * v1.0 Initial version
 */
public interface FinancialProductBase {
	
	/**
	 * Method used to add an observer to the list
	 * @param ob Specific observer that you wait add
	 */
	public void registerObserver(FinancialProductObserverBase ob);
	
	/**
	 * Method used to remove an observer from the list
	 * @param ob Specific observer that you wait remove
	 */
	public void removeObserver(FinancialProductObserverBase ob);
	
	/**
	 * Method used to notify observers that the value of the Euribor has changed
	 */
	public void notifyObservers();
	
	/**
	 * Method used to change the present value of the specific financial product
	 */
	public void setInterestRate(float interestRate);

}
