package es.unileon.ulebank.strategy;

import es.unileon.ulebank.exceptions.CommissionException;


/**
 * @class StrategyCommissionRevolvingEmission
 * @author Rober dCR
 * @date 20/03/2014
 * @brief Class that obtain Commision of Emission in Revolving Cards
 */
public class StrategyCommissionRevolvingEmission implements StrategyCommissionRevolving {

	private float quantity; //Commission establish by the employee
	
	/**
	 * Class constructor
	 * @param quantity
	 * @throws CommissionException 
	 */
	public StrategyCommissionRevolvingEmission(float quantity) throws CommissionException{
		if (quantity >= 0)
			this.quantity = quantity;
		else
			throw new CommissionException("Commission can't been negative.");
	}

	@Override
	public float calculateCommission() {
		return this.quantity;
	}
	
}
