package es.unileon.assets.strategy.loan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import es.unileon.assets.PaymentPeriod;

/**
 * Implementation of strategy for calculated all fee of the loan following the
 * french method
 * 
 * 
 * v1.0 Initial version
 */
public class FrenchMethod extends StrategyBaseLoan
{

	/**
	 * Percent of interest for calculating the loan and after the fees
	 */
	private double interest;
	/**
	 * Period of time in months for repayment the loan
	 */
	private int month;
	/**
	 * Period of time between payments
	 */
	private PaymentPeriod paymentPeriod;
	/**
	 * Total money that is needed for repayment
	 */
	private double totalLoan;

	/**
	 * Constructor of FrenchMethod
	 * 
	 * @param totalLoan
	 *            Total money that is needed for repayment
	 * @param interest
	 *            Percent of interest for calculating the loan and after the
	 *            fees
	 * @param paymentPeriod
	 *            Period of time between payments
	 * @param month
	 *            Period of time in months for repayment the loan
	 */
	public FrenchMethod(double totalLoan, double interest, PaymentPeriod paymentPeriod, int month)
	{
		this.totalLoan = totalLoan;
		this.interest = interest;
		this.paymentPeriod = paymentPeriod;
		this.month = month;
		payments = new ArrayList<ScheduledPayment>();

	}
	
	/**
	 * Method used to calculating the effective interest of do the fees
	 * @return Double with the value of this effective interest
	 */
	public double calculateInterestEf()
	{
		double interestEf = 0;
		interestEf = (this.interest / 100) / (365 / 30 * this.paymentPeriod.getPeriod());
		return interestEf;
	}
	
	/**
	 * Method used to calculating the fees of loan
	 * @return Double with the value of this fees of loan
	 */
	public double calculateMonthlyFee()
	{
		double fee = 0;
		double interesEf = this.calculateInterestEf();
		int numFee = (this.month / this.calculatePayment());
		double fracc = ((Math.pow((1 + interesEf), numFee)) * interesEf) / (Math.pow(1 + interesEf, numFee) - 1);
		fee = this.totalLoan * fracc;
		return fee;
	}
	
	/**
	 * Method used to invert the payment period for calculated the total number of payments for repayment the loan
	 * @return Integer with the value of number of payments in one year
	 */
	private int calculatePayment()
	{
		int num = this.paymentPeriod.getPeriod();
		if (num == 12)
			return 1;
		else if (num == 6)
			return 2;
		else if (num == 4)
			return 3;
		else if (num == 2)
			return 6;
		else if (num == 1)
			return 12;
		return 0;
	}
	
	/**
	 * Method used to calculating the fees of loan and give dates for perform this payments
	 */
	public void CalculateInterest()
	{
		int monthToAdd = 12/paymentPeriod.getPeriod();
		Calendar date = Calendar.getInstance();
		double fee = this.calculateMonthlyFee();
		double interestEf = this.calculateInterestEf();
		double interest = 0;
		double amortized = 0;
		double totalCapital = fee * this.month;
		for (int i = 0; i < this.month; i++) {
			totalCapital -= fee;
			interest = totalCapital * interestEf;
			amortized = fee - interest;
			totalCapital = redondear(totalCapital, 100);
			fee = redondear(fee, 100);
			amortized = redondear(amortized, 100);
			interest = redondear(interest, 100);
			//
			for (int j = 0; j < this.calculatePayment(); j++) {
				date.add(Calendar.MONTH, monthToAdd);
			}
			this.payments.add(new ScheduledPayment(date.getTime(), totalCapital, fee, interest, amortized));
		}
	}

	/**
	 * Metodo utilizado para redondear un numero.
	 * Se deben de pasa el numero a redondear y el factor.
	 * @param num Numero que se quiere redondear
	 * @param factor Numero de decimales a los que se quiere redondear
	 * @return Numero redondeado
	 */
	public double redondear(
			double num,
			int factor)
	{
		num = num * factor;
		num = Math.round(num);
		num = num / factor;
		return num;
	}
}
