package es.unileon.ulebank.payments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.exceptions.CommissionException;
import es.unileon.ulebank.exceptions.PaymentException;
import es.unileon.ulebank.fees.InvalidFeeException;
import es.unileon.ulebank.fees.LinearFee;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.CardTransaction;
import es.unileon.ulebank.history.TransactionException;

/**
 * @author Israel, Rober dCR
 * Clase que representa la tarjeta de credito
 */
public class CreditCard extends Card {
	/**
	 * Cuenta a la que esta asociada la tarjeta
	 */
	private Account account;
	/**
	 * Duegno de la tarjeta
	 */
	private Client owner;
	/**
	 * Dia del mes en el que se carga los gastos de la tarjeta
	 */
	private int monthDay;
	/**
	 * Lista de transacciones de la tarjeta
	 */
	private List<CardTransaction> transactionList;
	
	/**
	 * Constructor de la clase
	 * @param cardId
	 * @param owner
	 * @param account
	 * @param buyLimitDiary
	 * @param buyLimitMonthly
	 * @param cashLimitDiary
	 * @param cashLimitMonthly
	 * @param commissionEmission
	 * @param commissionMaintenance
	 * @param commissionRenovate
	 * @throws CommissionException
	 * @throws InvalidFeeException 
	 */
	public CreditCard(Handler cardId, Client owner, Account account, double buyLimitDiary, double buyLimitMonthly, 
			double cashLimitDiary, double cashLimitMonthly, double commissionEmission, 
			double commissionMaintenance, double commissionRenovate) throws CommissionException, InvalidFeeException {
		super(cardId, CardType.CREDIT, buyLimitDiary, buyLimitMonthly, cashLimitDiary, cashLimitMonthly,
				new LinearFee(0,commissionEmission),
				new LinearFee(0,commissionMaintenance),
				new LinearFee(0,commissionRenovate));
		this.account = account;
		this.owner = owner;
		this.transactionList = new ArrayList<CardTransaction>();
	}
	
	/**
	 * Method that makes the payment
	 * @param quantity Amount of the payment
	 * @param payConcept Concept of the payment
	 * @throws PaymentException 
	 * @throws TransactionException 
	 */
	@Override
	public void makeTransaction(double quantity, String payConcept) throws PaymentException, TransactionException {
		//Agyadimos la transaccion a la lista
		CardTransaction transaction = new CardTransaction(quantity, new Date(), payConcept);
		transaction.setEffectiveDate(this.obtainEffectiveDate());
		this.transactionList.add(transaction);
	}
	
	/**
	 * Devuelve el duegno de la tarjeta
	 * @return Client
	 */
	public Client getOwner() {
		return owner;
	}
	
	/**
	 * Method that obtain the day when the amount of the purchases is done.
	 * @return
	 */
	public int getMonthDay() {
		return monthDay;
	}

	/**
	 * Method that sets the day when the amount of the purchases is done.
	 * @param monthDay
	 */
	public void setMonthDay(int monthDay) {
		this.monthDay = monthDay;
	}
	
	/**
	 * Method that get the account associated to the card
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Method that calculate the effective day when the payment is taken
	 * @return date
	 */
	@SuppressWarnings("deprecation")
	private Date obtainEffectiveDate(){
		Date effectiveDate = new Date();
		effectiveDate.setDate(this.monthDay);
		if (effectiveDate.getMonth() != 11)
			effectiveDate.setMonth(effectiveDate.getMonth()+1);
		else {
			effectiveDate.setMonth(0);
			effectiveDate.setYear(effectiveDate.getYear()+1);
		}
		
		return effectiveDate;
	}
	
	/**
	 * Method that calculate the amount of all transaction which have the effectiveDate
	 * @param effectiveDate
	 * @return amount of purchases
	 */
	public double getAmount(Date effectiveDate){
		double amount = 0.0;
		
		//Recorremos todas las transacciones de la lista acumulando las cantidades de dichas transacciones
		for ( int i = 0; i < this.transactionList.size(); i++){
			if ( this.transactionList.get(i).getEffectiveDate().compareTo(effectiveDate) == 0 ) {
				amount += this.transactionList.get(i).getAmount();
			}
		}
		
		return amount;
	}
}
