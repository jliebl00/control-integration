package es.unileon.ulebank.brokerage.pack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.brokerage.buyable.Buyable;
import es.unileon.ulebank.handler.Handler;

/**
 * 
 * @author asanra
 *
 */
public class InvestmentFundPackTest {
	
	private InvestmentFundPack pack;
	private Buyable product1;
	private Handler id1;

	@Before
	public void setUp() throws Exception {
		
		product1 = new Buyable(id1, 5, 50.0);
		pack = new InvestmentFundPack(product1, 1050, null);
		
	
	}

	@Test
	public void testGetAmount() {
		
		assertEquals(1050, pack.getAmount());
		
	}
	
	@Test
	public void testGetAccount() {
		
		assertEquals(null, pack.getAccount());
		
	}
	
	@Test
	public void testGetProduct() {
		
		assertEquals(product1, pack.getProduct());
		
	}

}
