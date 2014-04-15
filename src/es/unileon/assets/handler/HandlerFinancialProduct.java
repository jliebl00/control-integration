package es.unileon.assets.handler;

public class HandlerFinancialProduct implements Handler {
	private LoanIdentificationNumberCode loanIdentification;
	
	/**
	 * Handler al cual se le pasa una instancia de LoanIdentificationNumberCode que es la 
	 * clase encargada de generar el numero de identificación
	 * @param linc
	 */
	public HandlerFinancialProduct(LoanIdentificationNumberCode linc) {
		this.loanIdentification = linc;
	}
	
	@Override
	public int compareTo(Handler anotherHandler) {
		return this.loanIdentification.toString().compareTo(anotherHandler.toString());
	}
	
	@Override
	public String toString() {
		return this.loanIdentification.toString();
	}
}
