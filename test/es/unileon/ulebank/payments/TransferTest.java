package es.unileon.ulebank.payments;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.exceptions.TransferException;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.history.TransactionException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transactionManager.TransactionManager;

/**
 * Test about Transfer Class
 * @author Rober dCR
 * @date 02/04/2014
 */
public class TransferTest {

	public Account senderAccount;
	public Account receiverAccount;
	public float quantity;
	Transfer transfer;
    private Office office;
    private Bank bank;
    private TransactionManager manager;

    private String accountNumber = "0000000000";
	
	@Before
	public void setUp(){
		this.manager = new TransactionManager();
        this.bank = new Bank(manager, new GenericHandler("1234"));
        this.office = new Office(new GenericHandler("1234"), this.bank);
		this.senderAccount = new Account(office, bank, accountNumber);
		this.receiverAccount = new Account(office, bank, accountNumber);
		this.quantity = (float) 20.5;
	}
	
	@Test
	public void transferMoneyWithBalanceTest() throws TransferException, TransactionException {
		this.senderAccount.setBalance(100);
		this.receiverAccount.setBalance(0);
		double beforeMoneyReceiver = this.receiverAccount.getBalance();
		double beforeMoneySender = this.senderAccount.getBalance();
		this.transfer = new Transfer(this.senderAccount, this.receiverAccount, this.quantity);
		this.transfer.makeTransfer("Concepto");
		double afterMoneyReceiver = this.receiverAccount.getBalance();
		double afterMoneySender = this.senderAccount.getBalance();
		
		assertEquals(afterMoneyReceiver - beforeMoneyReceiver, this.quantity, 0.01);
		assertEquals(afterMoneyReceiver, this.quantity + beforeMoneyReceiver, 0.01);
		assertEquals(beforeMoneySender - afterMoneySender, this.quantity, 0.01);
		assertEquals(afterMoneySender, beforeMoneySender - this.quantity, 0.01);
	}

	@Test (expected = TransferException.class)
	public void transferMoneyWithOutBalanceTest()throws TransferException, TransactionException {
		this.senderAccount.setBalance(0);
		this.receiverAccount.setBalance(0);
		this.transfer = new Transfer(this.senderAccount, this.receiverAccount, this.quantity);
		this.transfer.makeTransfer("Concepto");
	}
	
	@Test (expected = TransferException.class)
	public void transferMoneyEqualsAccountTest()throws TransferException {
		Account exAccount = new Account(office, bank, accountNumber);
		this.transfer = new Transfer(exAccount, exAccount, this.quantity);
	}
}
