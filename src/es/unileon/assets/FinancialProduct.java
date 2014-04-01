package es.unileon.assets;

import es.unileon.assets.handler.Handler;
/**
 * Interface
 * @author CarlitosMayo
 *
 */
public  interface FinancialProduct {
	
	public double getDebt();
	
	public Handler getIdFinancialProduct();

	public void setIdFinancialProduct(Handler idFinancialProduct);
	
	public double delayedPayment();
	

}
