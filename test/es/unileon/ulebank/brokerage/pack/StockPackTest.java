package es.unileon.ulebank.brokerage.pack;

import es.unileon.ulebank.brokerage.buyable.Buyable;
import es.unileon.ulebank.brokerage.buyable.Enterprise;
import es.unileon.ulebank.brokerage.buyable.EnterpriseHandler;
import es.unileon.ulebank.brokerage.buyable.NotEnoughParticipationsException;
import java.text.ParseException;
import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author asanra
 *
 */
public class StockPackTest {
	
	private StockPack stockPack1;
	private StockPack stockPack2;
	private Date date;
	private Buyable product1;
	private EnterpriseHandler id1;
	private int amount;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		
		amount = 1000;
		product1 = new Enterprise(id1, 5, 50.0);
		date = new Date(112,7,7,18,25,12);
		stockPack1 = new StockPack(product1, amount, 20.5, null);
		stockPack2 = new StockPack(null, 1, 165.25, date);
		
	}

	@Test
	public void testGetPrice() {
		
		assertEquals(20.5, stockPack1.getPrice(), 0.00);
		assertEquals(165.25, stockPack2.getPrice(), 0.00);
		
	}
	
	@Test
	public void testGetDate() throws ParseException {
		
		assertEquals(null, stockPack1.getDate());
		assertEquals(date, stockPack2.getDate());
		
	}
	
	@Test
	public void testSell() throws NotEnoughParticipationsException {
		
		stockPack1.sell(500);
		assertEquals(500, stockPack1.getAmount());
		
	}
	
	@Test
	public void testSellAll() throws NotEnoughParticipationsException {
		
		stockPack1.sell(1000);
		assertEquals(0, stockPack1.getAmount());
		
	}
	
	@Test (expected = NotEnoughParticipationsException.class)
	public void testNotEnoughParticipations() throws NotEnoughParticipationsException {
		
		stockPack1.sell(1026);
		
	}
	
	@Test
	public void testGetAmount() {
		
		assertEquals(amount, stockPack1.getAmount());
		assertEquals(1, stockPack2.getAmount());
		
	}
	
	@Test
	public void testGetAccount() {
		
		assertEquals(null, stockPack1.getAccount());
		
	}
	
	@Test
	public void testGetProduct() {
		
		assertEquals(product1, stockPack1.getProduct());
		
	}
	
	

}
