package es.unileon.ulebank.pack;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;


import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.brokerage.pack.StockPack;

/**
 * 
 * @author asanra
 *
 */
public class StockPackTest {
	
	private StockPack stockPack1;
	private StockPack stockPack2;
	private Date date;

	@SuppressWarnings("deprecated")
	@Before
	public void setUp() throws Exception {
		
		date = new Date(112,7,7,18,25,12);
		stockPack1 = new StockPack(null, 1000, null, 20.5, null);
		stockPack2 = new StockPack(null, 1000, null, 165.25, date);
		
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

}
