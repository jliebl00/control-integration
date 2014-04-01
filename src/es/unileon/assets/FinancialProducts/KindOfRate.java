package es.unileon.assets.FinancialProducts;


public enum KindOfRate {
	Euribor("euribor"),IRS("irs");
	String name;
	KindOfRate(String name){
		this.name=name;
	}
	public String getName(){
		return name;
		
	}
}
