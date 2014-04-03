package es.unileon.assets;

//cambio para corregir enlace
import java.util.ArrayList;

import es.unileon.assets.handler.Handler;

public class ClientProducts {
	private ArrayList<FinancialProduct> financialProducts;

	public ClientProducts() {
		this.financialProducts = new ArrayList<FinancialProduct>();
	}

	/**
	 * Return a boolean result if the FinancialProduct is created or not
	 * 
	 * @param product
	 * @return
	 */
	public boolean add(FinancialProduct product) {
		return this.financialProducts.add(product);
	}

	/**
	 * REturn a boolean result if the financial product has been removed
	 * 
	 * @param product
	 * @return
	 */
	public boolean remove(FinancialProduct product) {
		return this.financialProducts.remove(product);
	}

	/**
	 * Return the financial product that match with the index param
	 * 
	 * @param index
	 * @return
	 */
	public FinancialProduct getFinancialProduct(int index) {
		return this.financialProducts.get(index);
	}

	/**
	 * Method that allows to search any financial product created. If the
	 * financial product is found the method return the product, but if the
	 * product is not found the method returns null
	 * 
	 * @param handler
	 * @return
	 */
	public FinancialProduct search(Handler handler) {
		for (FinancialProduct product : this.financialProducts) {
			if (product.getIdFinancialProduct().compareTo(handler) == 0) {
				return product;
			}
		}
		return null;
	}
}
