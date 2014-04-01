package es.unileon.assets.strategy.loan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import es.unileon.assets.PaymentPeriod;

public class ItalianMethod extends StrategyBaseLoan {

	private ArrayList<ScheduledPayment> payments;
	PaymentPeriod paymentPeriod;

	/**
	 * Constructor al cual se le pasa el capital, el tipo de interes y el numero
	 * de cuotas
	 * 
	 * @param capital
	 * @param interes
	 * @param numeroCuotas
	 */
	public ItalianMethod(double capital, double interests,
			PaymentPeriod paymentPeriod, int numberOfFees) {
		this.capital = capital;
		this.interests = interests;
		this.amortizationTime = numberOfFees;
		this.payments = new ArrayList<ScheduledPayment>();
		this.paymentPeriod = paymentPeriod;
	}

	/**
	 * Metodo que realiza todo el calculo de las coutas
	 */
	public void doItalianMethod() {
		int monthToAdd = 12 / paymentPeriod.getPeriod();
		Calendar date = Calendar.getInstance();
		double amortizedCapital = this.capital / this.amortizationTime;
		double interests = (this.capital * this.interests) / 100; // Dividimos
																	// entre 100
																	// para el
																	// tanto por
																	// ciento
		double cuota = amortizedCapital + interests;
		double capitalPendiente = this.capital - amortizedCapital;
		amortizedCapital = this.round(amortizedCapital, 100);
		interests = this.round(interests, 100);
		cuota = this.round(cuota, 100);
		capitalPendiente = this.round(capitalPendiente, 100);

		for (int i = 0; i < this.amortizationTime; i++) {
			// creo que el añadir esta parte la tendrias que hacer al final(lo
			// de añadirlo a la lista)

			date.add(Calendar.MONTH, monthToAdd);
			this.payments.add(new ScheduledPayment(date.getTime(), cuota,
					amortizedCapital, interests, capitalPendiente));
			interests = (capitalPendiente * this.interests) / 100; // Dividimos
																	// entre 100
																	// para el
																	// tanto por
																	// ciento
			cuota = amortizedCapital + interests;
			capitalPendiente = capitalPendiente - amortizedCapital;
			interests = this.round(interests, 100);
			cuota = this.round(cuota, 100);
			capitalPendiente = this.round(capitalPendiente, 100);
		}
	}

	/**
	 * Metodo de la interfaz el cual se llama para hacer el calculo de las
	 * cuotas
	 */
	@Override
	public void CalculateInterest() {
		doItalianMethod();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (ScheduledPayment payment : this.payments) {
			sb.append(payment.toString());
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * Metodo que devuleve una lista con los pagos a realizar
	 * 
	 * @return
	 */
	public ArrayList<ScheduledPayment> getPayments() {
		return this.payments;
	}

	/**
	 * Metodo utilizado para round un numero. Se deben de pasa el numero a
	 * redindear y el factor.
	 * 
	 * @param num
	 * @param factor
	 * @return
	 */
	public double round(double num, int factor) {
		num = num * factor;
		num = Math.round(num);
		num = num / factor;
		return num;
	}

}
