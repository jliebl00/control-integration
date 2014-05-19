package es.unileon.ulebank.history;

import java.util.Date;

/**
 * Transaction for the Card
 * @author Rober dCR
 * @date 8/05/2014
 * @brief Class that allows all monetary transactions with cards
 */
public class CardTransaction extends Transaction{
	
	/**
	 * Class constructor
	 * @param amount
	 * @param datezz
	 * @param subject
	 * @param type
	 * @param senderAccount
	 * @param receiverAccount
	 * @throws TransactionException 
	 */
	public CardTransaction(double amount, Date date, String subject
				) throws TransactionException {
		super(amount, date, subject);
	}

}
