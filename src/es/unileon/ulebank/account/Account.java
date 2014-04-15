package es.unileon.ulebank.account;

import es.unileon.ulebank.account.exception.TransactionException;
import es.unileon.ulebank.account.handler.AccountHandler;
import es.unileon.ulebank.account.history.AccountHistory;
import es.unileon.ulebank.account.liquidation.LiquidationStrategy;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.history.Transaction;
import es.unileon.ulebank.history.TransactionType;
import es.unileon.ulebank.Office;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * 
 * @author runix
 */
public abstract class Account {

	// TODO, need to add liquidation frequency
	// and a method to perform the liquidation
	/**
	 * The logger of the class
	 */
	private static final Logger LOG = Logger.getLogger(Account.class.getName());
	/**
	 * The account identifier
	 */
	private Handler id;

	/**
	 * The account balance
	 */
	private double balance;
	/**
	 * The account titulars
	 */
	private final List<Client> titulars;
	/**
	 * The account authorizeds
	 */
	private final List<Client> authorizeds;
	/**
	 * The history of the account
	 */
	private final AccountHistory history;
	/**
	 * The strategy to liquidate the account
	 */
	private LiquidationStrategy strategy;
	/**
	 * The last liquidation
	 */
	private Date lastLiquidation;
	/**
	 * The liquidation frequency in months
	 */
	private int liquidationFrecuency;

	/**
	 * The default liquidation frecuency
	 */
	private static final int DEFAULT_LIQUIDATION_FREQUENCY = 6;

	/**
	 * Create a new account
	 * 
	 * @param office
	 *            (The office of the account)
	 * 
	 * @param bank
	 *            ( The bank of the office )
	 * 
	 * @param accountnumber
	 *            (the accountNumber)
	 * 
	 * @throws es.unileon.ulebank.handler.MalformedHandlerException
	 * 
	 */
	public Account(Office office, Bank bank, String accountnumber)
			throws MalformedHandlerException {
		this.id = new AccountHandler(office.getIdOffice(), bank.getID(),
				accountnumber);
		this.history = new AccountHistory();
		this.balance = 0.0d;
		this.titulars = new ArrayList<>();
		this.authorizeds = new ArrayList<>();
		this.lastLiquidation = new Date(System.currentTimeMillis());
		this.liquidationFrecuency = DEFAULT_LIQUIDATION_FREQUENCY;
		LOG.info("Create a new account with number " + accountnumber
				+ " office " + office.getIdOffice().toString() + " bank "
				+ bank.getID());
	}

	/**
	 * Set the liquidation frecuency in months
	 * 
	 * ( Default {
	 * 
	 * @see DEFAULT_LIQUIDATION_FREQUENCY )
	 * 
	 * @param liquidationFrecuency
	 *            ( new liquidation frecuency )
	 * 
	 * @return (true if success, false if the param is negative or zero)
	 */
	public boolean setLiquidationFrecuency(int liquidationFrecuency) {
		LOG.info("Change liquidation frecuency to " + liquidationFrecuency);
		if (liquidationFrecuency >= 1) {
			this.liquidationFrecuency = liquidationFrecuency;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Add a new titular
	 * 
	 * @param client
	 *            ( client to add)
	 * 
	 * @return ( true if success, else false )
	 */
	public boolean addTitular(Client client) {
		for (int i = 0; i < this.titulars.size(); i++) {
			if (this.titulars.get(i).getId().compareTo(client.getId()) == 0) {
				LOG.error("Cannot add the titular " + client.getId().toString()
						+ " , the titular already exists");
				return false;
			}
		}
		LOG.info(("Add new titular " + client.getId()));
		this.titulars.add(client);
		return true;
	}

	/**
	 * 
	 * Delete a titular
	 * 
	 * @param id
	 *            ( The client id )
	 * 
	 * @return ( true if success, else false )
	 */
	public boolean deleteTitular(Handler id) {
		for (int i = 0; i < this.titulars.size(); i++) {
			if (this.titulars.get(i).getId().compareTo(id) == 0) {
				LOG.info("Delete " + id.toString() + " titular");
				this.titulars.remove(i);
				return true;
			}
		}
		LOG.error("Cannot remove the titular " + id.toString()
				+ " because it doesn't exist");
		return false;
	}

	/**
	 * 
	 * Add a new authorized
	 * 
	 * @param authorized
	 *            ( authorized to add)
	 * 
	 * @return ( true if success, else false )
	 */
	public boolean addAuthorized(Client authorized) {
		for (int i = 0; i < this.authorizeds.size(); i++) {
			if (this.authorizeds.get(i).getId().compareTo(authorized.getId()) == 0) {
				LOG.error("Cannot add the authorized "
						+ authorized.getId().toString()
						+ " , the authorized already exists");
				return false;
			}
		}
		LOG.info(("Add new titular " + authorized.getId()));
		return this.authorizeds.add(authorized);
	}

	/**
	 * 
	 * Delete a titular
	 * 
	 * @param id
	 *            ( The authorized id )
	 * 
	 * @return ( true if success, else false )
	 */
	public boolean deleteAuthorized(Handler id) {
		for (int i = 0; i < this.authorizeds.size(); i++) {
			if (this.authorizeds.get(i).getId().compareTo(id) == 0) {
				LOG.info("Delete " + id.toString() + " authorized");
				this.authorizeds.remove(i);
				return true;
			}
		}
		LOG.error("Cannot remove the authorized " + id.toString()
				+ " because it doesn't exist");
		return false;
	}

	/**
	 * Get the account titulars
	 * 
	 * @return ( The titulars )
	 */
	public List<Client> getTitulars() {
		return new ArrayList<>(this.titulars);
	}

	/**
	 * Get the authorizeds
	 * 
	 * @return ( the authorizeds )
	 */
	public List<Client> getAuthorizeds() {
		return new ArrayList<>(this.authorizeds);
	}

	/**
	 * Get the account balance
	 * 
	 * @return (the balance)
	 * 
	 * @author runix
	 */
	public final double getBalance() {
		return this.balance;
	}

	/**
	 * Check if there are incosistences. If the program crash when a transaction
	 * was being doing maybe the account balance not be the same as the sum of
	 * all transactions. So, if the method return false imply that a transaction
	 * hadn't been finished.
	 * 
	 * @return ( True if the account is consistent, and false otherwise)
	 */
	public boolean checkInconsistences() {
		Iterator<Transaction> iterator = this.getHistory().getTransactions()
				.iterator();
		double balance = 0.0d;
		while (iterator.hasNext()) {
			balance += iterator.next().getAmount();
		}
		return balance == this.balance;
	}

	/**
	 * Withdraw money from the account.
	 * 
	 * @param transaction
	 *            ( transaction to do )
	 * 
	 * @throws es.unileon.ulebank.account.exception.TransactionException
	 *             (if there are some null fields in the transaction)
	 */
	public synchronized void doWithdrawal(Transaction transaction)
			throws TransactionException {
		StringBuilder err = new StringBuilder();
		if (transaction.getSubject() == null) {
			err.append("The subject cannot be null \n");
		} else {
			if (transaction.getSubject().length() == 0) {
				err.append("Transaction length cannot be 0 \n");
			}
		}

		if (transaction.getType() != TransactionType.CHARGE) {
			err = err.append("Withdrawal operations must be ")
					.append(TransactionType.CHARGE).append(" type\n");
		}

		if (transaction.getId() == null) {
			err.append(("The id cannot be null \n"));
		} else {
			if (transaction.getId().toString().length() == 0) {
				err.append(("The id size cannot be 0 \n"));
			}
		}
		if (transaction.getDate() == null) {
			err.append("The date cannot be null \n");
		}

		if (transaction.getAmount() < 0) {
			err.append("Fail, the amount of money cannot be less than zero\n");
		}
		if (err.length() > 0) {
			LOG.error(err.toString());
			throw new TransactionException(err.toString());
		}
		transaction.setEffectiveDate(new Date(System.currentTimeMillis()));
		boolean success = this.history.addTransaction(transaction);
		if (success) {
			this.balance -= transaction.getAmount();
		} else {
			String error = "Cannot store the transaction\n";
			LOG.error(error);
			throw new TransactionException(error);
		}

	}

	/**
	 * Deposit money in the account
	 * 
	 * @param transaction
	 *            ( transaction to do )
	 * 
	 * @throws es.unileon.ulebank.account.exception.TransactionException
	 *             (if there are some null fields in the transaction)
	 */
	public synchronized void doDeposit(Transaction transaction)
			throws TransactionException {
		StringBuilder err = new StringBuilder();
		if (transaction.getSubject() == null) {
			err.append("The subject cannot be null \n");
		} else {
			if (transaction.getSubject().length() == 0) {
				err.append("Transaction length cannot be 0 \n");
			}
		}

		if (transaction.getType() != TransactionType.PAYMENT) {
			err = err.append("Deposit operations must be")
					.append(TransactionType.PAYMENT).append(" type\n");
		}

		if (transaction.getId() == null) {
			err.append(("The id cannot be null \n"));
		} else {
			if (transaction.getId().toString().length() == 0) {
				err.append(("The id size cannot be 0 \n"));
			}
		}

		if (transaction.getDate() == null) {
			err.append("The date cannot be null \n");
		}

		if (transaction.getAmount() < 0) {
			err.append("Fail, the amount of money cannot be less than zero\n");
		}

		if (err.length() > 0) {
			LOG.error(err.toString());
			throw new TransactionException(err.toString());
		}
		transaction.setEffectiveDate(new Date(System.currentTimeMillis()));
		boolean success = this.history.addTransaction(transaction);
		if (success) {
			this.balance += transaction.getAmount();
		} else {
			String error = "Cannot store the transaction\n";
			LOG.error(error);
			throw new TransactionException(error);
		}
	}

	/**
	 * Set the strategy to liquidate the account
	 * 
	 * @param strategy
	 *            ( The strategy )
	 */
	public void setLiquidationStrategy(LiquidationStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Get the account transactions
	 * 
	 * @return (The transactions)
	 */
	public AccountHistory getHistory() {
		return this.history;
	}

	/**
	 * Get the account ID
	 * 
	 * @return (the account id)
	 * @author runix
	 */
	public final Handler getID() {
		return this.id;
	}

	public void addBalance(float f) {
		// TODO Auto-generated method stub
		
	}
}
