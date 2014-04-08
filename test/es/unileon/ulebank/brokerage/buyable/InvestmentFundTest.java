package es.unileon.ulebank.brokerage.buyable;

import org.junit.Before;
import org.junit.Test;

public class InvestmentFundTest {

	InvestmentFund invesFundTest1;
	InvestmentFund invesFundTest2;
	InvestmentFund invesFundTest3;
	int participations = -10;
	
	@Before
	public void setUp() throws InvalidBuyableException {
//public InvestmentFund(Handler id, int amount, double totalPrice, Employee opener, FeeStrategy fee, double profitability)
		invesFundTest2 = new InvestmentFund(null, 10, 200.27, null, null, 0.03);
		invesFundTest3 = new InvestmentFund(null, 10, 200.27, null, null, 0.03);
		
	}

	@Test
	public void testInvestmentFund() throws InvalidBuyableException{
		invesFundTest1 = new InvestmentFund(null, 10, 200.27, null, null, 0.03);
	}

//	Es un simple get	
//	@Test
//	public void testGetOpener() {
//		fail("Not yet implemented");
//	}

	@Test (expected = TotalLowerThanBoughtException.class)
	public void testSetParticipations() throws TotalLowerThanBoughtException {
		invesFundTest2.setParticipations(participations);
	}

//	No es necesario
//	@Test
//	public void testGetFee() {
//		fail("Not yet implemented");
//	}

// 	No es necesario
//	@Test
//	public void testSetFee() {
//		fail("Not yet implemented");
//	}

//	No es necesario
//	@Test
//	public void testGetProfitability() {
//		fail("Not yet implemented");
//	}

//	No es necesario
//	@Test
//	public void testSetProfitability() {
//		fail("Not yet implemented");
//	}

}
