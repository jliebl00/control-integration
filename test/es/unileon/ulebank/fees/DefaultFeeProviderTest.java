package es.unileon.ulebank.fees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sun.security.jca.GetInstance;

public class DefaultFeeProviderTest {

	FeeStrategy defaultFee;
	DefaultFeeProvider instance;
	
	@Before
	public void setUp() throws InvalidFeeException {
		this.defaultFee = new LinearFee(0.5, 10);
		this.instance = DefaultFeeProvider.getInstance();
	}
	
	@Test
	public void testGetInstance() {
		assertNotNull(DefaultFeeProvider.getInstance());
		assertEquals(instance, DefaultFeeProvider.getInstance());
	}

	@Test
	public void testGetDefaultFee() {
		assertEquals(this.defaultFee, instance.getDefaultFee());
	}

}
