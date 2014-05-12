package es.unileon.ulebank.brokerage;

import java.util.ArrayList;

import es.unileon.ulebank.brokerage.TypeFinancialProducts;
public class FinantialProductDescription {
	
	private TypeFinancialProducts productDescription;
	//pregustas necesarias para acceder a este producto
	
	private ArrayList<Integer > requirements = new ArrayList<>();
	
	public FinantialProductDescription(TypeFinancialProducts financialProduct) {
		this.productDescription = financialProduct;
		
		
		if(TypeFinancialProducts.Funds.equals(financialProduct)) {
			this.requirements.add(3);
			this.requirements.add(4);
		}
		
		if(TypeFinancialProducts.Share.equals(financialProduct)){
			this.requirements.add(1);
			this.requirements.add(2);
			this.requirements.add(4);
		}
	}
	
	
	public boolean canOffer(ArrayList<Integer > requirements) {
		return this.requirements.containsAll(requirements);
	}
	
	
	private void addRequirement(int requirements){
		this.requirements.add(requirements);
	}
	
	public static void main(String[] args) {
		//Mis respuestas afirmativas
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(4);
		
		//Lista de productos
		ArrayList<FinantialProductDescription> productos = new ArrayList<>();
		productos.add(new FinantialProductDescription(TypeFinancialProducts.Share));
		productos.add(new FinantialProductDescription(TypeFinancialProducts.Funds));
		
		for(FinantialProductDescription p : productos){
			if(p.canOffer(arr)){
				System.out.println("puedo acceder a :" + p);
			}
		}
		

	}
	
	@Override
	public String toString() {
		return this.productDescription.toString();
	}
}
