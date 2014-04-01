package es.unileon.assets.FinancialProducts;

public class IRS  implements FinancialProductBase{
	
	/**
	 * List of IRS observers
	 */
	private java.util.List<FinancialProductObserverBase> observers;
	
	/**
	 * Value of the IRS at this moment
	 */
	private float interestRate;
	
	/**
	 * Contructor of IRS class
	 * @param list List of IRS observers
	 * @param iRate Value of the IRS right now
	 */
	public IRS(java.util.List<FinancialProductObserverBase> list,float iRate){
				
			this.observers = list;
			interestRate = iRate;
	}
	
	/**
	 * Method used to add an observer to the list
	 * @param ob Specific observer expected to add
	 */
	public void registerObserver(FinancialProductObserverBase ob){
		
		if (!observers.contains(ob)){
			
			observers.add(ob);
		}
	}
	
	/**
	 * Method used to remove an observer from the list
	 * @param ob Specific observer expected to remove
	 */
	public void removeObserver(FinancialProductObserverBase ob){
		
		if (!observers.isEmpty()){
			
			if (observers.contains(ob)){
				
				observers.remove(ob);
			}
		}
	}
	
	/**
	 * Method used to notify observers that the value of the Euribor has changed
	 */
	public void notifyObservers(){
		for (FinancialProductObserverBase observer : observers) {
				observer.update();
			}
		
	}
	
	/**
	 * Method used to change the present value of the IRS
	 */
	public void setInterestRate(float interestRate){
		
		this.interestRate = interestRate;
	}
	
	/**
	 * Method used to return observers list
	 * @return List with all observers that has the IRS right now
	 */
	public java.util.List<FinancialProductObserverBase> getObservers(){
		return this.observers;
	}
	
	/**
	 * Method used to return the present value of the IRS
	 * @return Double with the value of the IRS
	 */
	public float getInterestRate(){
		return this.interestRate;
	}


	
}
