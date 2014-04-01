package es.unileon.assets.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import es.unileon.assets.KindOfMethod;
import es.unileon.assets.Loan;
import es.unileon.assets.PaymentPeriod;
import es.unileon.assets.handler.*;
import es.unileon.assets.strategy.loan.FrenchMethod;
import es.unileon.assets.strategy.loan.GermanMethod;
import es.unileon.assets.strategy.loan.ItalianMethod;
import es.unileon.assets.strategy.loan.ScheduledPayment;
import es.unileon.assets.strategy.loan.StrategyBaseLoan;

/**
 * Model class which implements loans functionality
 */
public class Model {
	Handler handler;
	Loan loan;

	private PaymentPeriod paymentPeriod;
	private int month = 4;

	private ArrayList<ScheduledPayment> payments;
	private double interest;
	private double comisionForOpenning;
	private double totalLoan;
	private String method;
	private StrategyBaseLoan strategyBaseLoan;
	/**
	 * Method to obtain scheduled payments
	 * 
	 * @return payments
	 */
	public ArrayList<ScheduledPayment> getPayments() {
		return payments;
	}

	/**
	 * Class constructor
	 */
	public Model() {
		try {
			String[] countris = Locale.getISOCountries();
			this.handler = new HandlerFinancialProduct(
					new LoanIdentificationNumberCode("LN", countris[0]));
			System.out.println(handler);
		} catch (MalformedExceptionLINC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to create a new loan
	 */
	public void CreateLoan() {

		this.loan = new Loan(handler, totalLoan, interest, paymentPeriod,
				month, comisionForOpenning);
		this.loan.setstrategyBaseLoan(strategyBaseLoan);
		payments = this.loan.calcPayments();
	}
	
	

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public PaymentPeriod getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(PaymentPeriod paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getComisionForOpenning() {
		return comisionForOpenning;
	}

	public void setComisionForOpenning(double comisionForOpenning) {
		this.comisionForOpenning = comisionForOpenning;
	}

	public double getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(double totalLoan) {
		this.totalLoan = totalLoan;
	}

	public void setPayments(ArrayList<ScheduledPayment> payments) {
		this.payments = payments;
	}

	public StrategyBaseLoan getStrategyBaseLoan() {
		return strategyBaseLoan;
	}

	public void setStrategyBaseLoan(KindOfMethod method) {
		switch (method) {
		case French:
			this.strategyBaseLoan=new FrenchMethod(totalLoan, interest, paymentPeriod, month);
			break;
		case German:
			this.strategyBaseLoan=new GermanMethod(totalLoan, interest, month);
			break;
		case Italian:
			this.strategyBaseLoan=new ItalianMethod(totalLoan, interest, paymentPeriod, month);
			break;

		default:
			break;
		}
	}

}
