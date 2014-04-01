package es.unileon.assets.strategy.loan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Implementacion de una de las estrategias para calcular las cuotas mensuales de los prestamos siguiendo el metodo aleman
 * 
 * 
 * v1.0 Initial version
 */
public class GermanMethod extends StrategyBaseLoan {
	
	/**
	 * ArrayList con las cuotas que deben ser realizadas para abonar el prestamo concedido
	 */
	private ArrayList<ScheduledPayment> payments;
	
	/**
	 * En el constructor se pasan el capital que va a ser prestado, 
	 * el tipo de interes en tanto por ciento y el tiempo para ser amortizado.
	 * @param capital
	 * @param interests
	 * @param amortizationTime
	 */
	public GermanMethod(double capital, double interests, int amortizationTime) {
		this.payments = new ArrayList<ScheduledPayment>();
		this.capital = capital;
		this.interests = interests/100;
		this.amortizationTime = amortizationTime;
	}
	
	/**
	 * Metodo de la interfaz al cual se llama para realizar el calculo
	 */
	public void CalculateInterest() {
		doNewGermanMethod();
	}
	
	/**
	 * Metodo que calcula todas las cuotas utilizando el metodo aleman
	 */
	public void doNewGermanMethod() {
		Calendar date = Calendar.getInstance();
		double capital = super.capital;
		double pago = super.capital * super.interests;
		double interests = pago;
		double amortizado = pago - interests;
		
		// Redondeo 
		capital = round(capital,100);
		pago = round(pago,100);
		amortizado = round(amortizado,100);
		interests = round(interests,100);
		
		this.payments.add(new ScheduledPayment(new Date(),  pago, amortizado,
				interests, capital));

		pago = (this.capital * this.interests)
				/ (1 - Math.pow((1 - this.interests), this.amortizationTime));

		for (int i = 0; i < this.amortizationTime; i++) {
			capital = capital - pago;
			interests = capital * this.interests;
			amortizado = pago - interests;
			
			
			// Redondeo 
			capital = round(capital,100);
			pago = round(pago,100);
			amortizado = round(amortizado,100);
			interests = round(interests,100);
			
			if(interests < 0){
				amortizado = interests + amortizado;
				amortizado = round(amortizado, 100);
				interests = 0;
			}
			
			if(capital < 0){
				capital = 0;
			}
			
			
			date.add(Calendar.MONTH, amortizationTime);
			
			this.payments.add(new ScheduledPayment(date.getTime(), pago, amortizado,
					interests, capital));
		}

	}
	
	/**
	 * Metodo utilizado para redondear un numero.
	 * Se deben de pasa el numero a redondear y el factor.
	 * @param num Numero que se quiere redondear
	 * @param factor Numero de decimales a los que se quiere redondear
	 * @return Numero redondeado
	 */
	public double round(double num, int factor) { 
		num = num * factor;
		num = Math.round(num);
		num = num / factor;
		return num;
	}
	
	/**
	 * Metodo que devuelve una lista con todos los pagos a realizar.
	 * @return lista de los pagos
	 */
	public ArrayList<ScheduledPayment> getPayments() {
		return this.payments;
	}

	@Override
	/**
	 * Metodo utilizado para devolver un string con las cuota halladas por el metodo aleman
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (ScheduledPayment payment : this.payments) {
			sb.append(payment.toString());
			sb.append("\n");
		}

		return sb.toString();
	}

}
