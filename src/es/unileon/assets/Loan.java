package es.unileon.assets;

import java.util.ArrayList;

import es.unileon.assets.handler.Handler;
import es.unileon.assets.strategy.loan.FrenchMethod;
import es.unileon.assets.strategy.loan.GermanMethod;
import es.unileon.assets.strategy.loan.ScheduledPayment;
import es.unileon.assets.strategy.loan.StrategyBaseLoan;

public class Loan implements FinancialProduct {
	private double debt;
	StrategyBaseLoan strategyBaseLoan;
	private double interest;
	private int month;
	private PaymentPeriod paymentPeriod;
	private double totalLoan;
	// no se cuanto es por defecto
	private double comisionForOpenning;
	private Handler idFinancialProduct;
	private double delayedPaymentInterest;
	private double comisionForCancel;

	/**
	 * Constructor
	 * 
	 * @param idFinancialProduct
	 * @param totalLoan
	 * @param interest
	 * @param paymentPeriod
	 * @param month
	 * @param comisionForOpenning
	 */
	public Loan(Handler idFinancialProduct, double totalLoan, double interest,
			PaymentPeriod paymentPeriod, int month, double comisionForOpenning) {
		this.idFinancialProduct = idFinancialProduct;
		this.totalLoan = totalLoan;
		this.comisionForOpenning = comisionForOpenning;
		this.interest = interest;
		this.debt = totalLoan + comisionForOpenning;
		this.paymentPeriod = paymentPeriod;
		this.month = month;

	}

	/**
	 * This method returns an Arraylist with all fees of the loan
	 * 
	 * @return
	 */
	public ArrayList<ScheduledPayment> calcPayments() {
		this.strategyBaseLoan.CalculateInterest();
		return this.strategyBaseLoan.getPayments();
	}

	/**
	 * This method return the handler Id
	 */
	public Handler getIdFinancialProduct() {
		return idFinancialProduct;
	}

	/**
	 * This method set the Handler Id
	 */
	public void setIdFinancialProduct(Handler idFinancialProduct) {
		this.idFinancialProduct = idFinancialProduct;
	}

	/**
	 * Obtain the strategy pattern
	 * 
	 * @return
	 */
	public StrategyBaseLoan getStrategyBaseLoan() {
		return this.strategyBaseLoan;
	}

	/**
	 * Set the strategy pattern
	 * 
	 * @param strategyBaseLoan
	 */
	public void setstrategyBaseLoan(StrategyBaseLoan strategyBaseLoan) {
		this.strategyBaseLoan = strategyBaseLoan;
	}

	/**
	 * This method allows to know what is the price that one person must pay if
	 * he decide cancel the loan. This amount of money is the total amount of
	 * money for cancel the loan
	 * 
	 * @param numLastFeeCancel
	 *            Fee loan number in which the owner cancel the loan
	 * @return amount of money to pay
	 */
	/**
	 * Importe de cancelaci��n de pr��stamo en una cuota concreta
	 * 
	 * Permite saber el importe que tendremos que pagar para cancelar un
	 * pr��stamo despu��s de haber pagado una cuota concreta. El importe de
	 * cancelaci��n incluye dicha cuota. Adem��s el importe depende tambi��n de
	 * la comisi��n de Cancelaci��n pactada. Responde a la cuesti��n ��cu��nto
	 * hay que pagar para cancelar el cr��dito en el pago n�� x? Para no ser
	 * dependiente del FrenchMethod habr��a que replantear la clase ancestro que
	 * tendr��a que definir como abstracto el m��todo calculateMonthlyFee para
	 * que lo implementasen las heredadas. Para no replantear hacemos un
	 * casting. Si el responsable de la clase lo replantea, entonces se podr��
	 * eliminar el casting y se podr��a generalizar a cualquier sistema de
	 * c��lculo y no s��lo al franc��s.
	 * 
	 * @param numLastFeeCancel
	 *            n�� de cuota en que cancelamos el pr��stamo
	 * @return
	 */
	public double cancelLoan(int numLastFeeCancel) {

		ArrayList<ScheduledPayment> payments = this.strategyBaseLoan
				.getPayments();
		ScheduledPayment lastPayment = null;
		double importCancel = ((FrenchMethod) this.strategyBaseLoan)
				.calculateMonthlyFee();
		double pendingCapital = totalLoan;
		if (payments.size() > 0) {
			lastPayment = payments.get(numLastFeeCancel - 1);
			pendingCapital = lastPayment.getOutstandingCapital();
		}
		importCancel += pendingCapital * (1 + this.comisionForCancel / 100);
		return importCancel;
	}

	/**
	 * Method that calculate the interest of a loan with the strategy pattern
	 */
	public void interestCalc() {
		this.strategyBaseLoan.CalculateInterest();
	}

	/**
	 * Recalculate the fees from the month in which the interest change if the
	 * owner wants to change the interest or if the owner decides to do some
	 * changes in the loan
	 * 
	 * @param monthChange
	 *            Month in which change the interest type
	 * @param newInterest
	 *            New aplicated interest
	 * 
	 * @return double The new fee to pay
	 */
	/**
	 * Recalcula el cuadro de amortizaci��n a partir del mes en el que cambia el
	 * tipo de inter��s
	 * 
	 * Se le pasa el mes a partir del cual ya es de aplicaci��n el nuevo tipo.
	 * Si le pasamo el mes 6 significa que hasta ese mes es de aplicaci��n el
	 * antiguo tipo y a partir de ��l es de aplicaci��n el nuevo tipo. Va a
	 * devolver la cuota que es de aplicaci��n en el resto del cuadro. Para
	 * saber el n��mero de cuota que corresponde a un mes concreto, implemento
	 * un m��todo p��blico numFee en el enum PaymentPeriod
	 * 
	 * @param monthChange
	 *            mes en el que cambia el tipo
	 * @param newInterest
	 *            nuevo inter��s que se aplica
	 * 
	 * @return double la nueva cuota a aplicar
	 */
	public double updatePayments(int monthChange, double newInterest) {
		double newFee = 0.0;
		// Calcula el ��ltimo n��mero de cuota antes del cambio
		int numFeeChange = paymentPeriod.numFee(monthChange);
		ArrayList<ScheduledPayment> payments = this.strategyBaseLoan
				.getPayments();
		ScheduledPayment lastPayment = null;
		double pendingCapital = totalLoan;
		if (payments.size() >= numFeeChange) {
			lastPayment = payments.get(numFeeChange - 1);
			pendingCapital = lastPayment.getOutstandingCapital();
			int monthRest = this.month - monthChange;
			// Generamos un nuevo cuadro con el capital pendiente, nuevo
			// inter��s y resto de meses
			StrategyBaseLoan cuadro = new FrenchMethod(pendingCapital,
					newInterest, this.paymentPeriod, monthRest);
			cuadro.CalculateInterest();
			// Obtenemos la nueva cuota
			newFee = ((FrenchMethod) cuadro).calculateMonthlyFee();
			ArrayList<ScheduledPayment> newPayments = cuadro.getPayments();
			// Sustituimos el cuadro actual por el nuevo cuadro generado.
			for (int i = numFeeChange; i < payments.size(); i++) {
				payments.set(i, newPayments.get(i - numFeeChange));
			}
		}
		return newFee;
	}

	public void update(Double InterestRate) {

	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("id " + this.idFinancialProduct.toString() + "\n");
		output.append("Debt " + this.getDebt() + "\n");
		output.append("Pay period " + this.paymentPeriod + "\n");
		output.append("Comision for opening " + this.comisionForOpenning + "\n");
		return output.toString();
	};

	/**
	 * Returns the debt
	 */
	@Override
	public double getDebt() {
		return debt;
	}

	/**
	 * Method that calculates the total fee in the case that the owner do not
	 * pay a fee in the correct time
	 * 
	 * @param residue
	 * @param MonthlyFee
	 * @param interes
	 *            Interes apply for the delay
	 * @return
	 */
	public double delayedPayment(double residue, double MonthlyFee,
			double interes) {
		double result = residue;
		double aux = interes;

		if ((aux > 0.0 && aux < 1.0) == false) {

			aux = aux / 100;

		}

		if (MonthlyFee > 0 && interes > 0) {

			return residue + MonthlyFee * aux;
		}

		return result;

	}

	public double delayedPayment() {
		return this.delayedPayment();
	}
}
