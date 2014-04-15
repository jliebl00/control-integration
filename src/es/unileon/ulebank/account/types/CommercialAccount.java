package es.unileon.ulebank.account.types;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.Office;
import es.unileon.ulebank.exceptions.MalformedHandlerException;

/**
 * 
 * @author runix
 */
public class CommercialAccount extends Account {

	public CommercialAccount(Office office, Bank bank, String accountnumber)
			throws MalformedHandlerException {
		super(office, bank, accountnumber);
	}

}
