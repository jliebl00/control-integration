package es.unileon.ulebank.handler;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.MalformedHandlerException;
import static org.junit.Assert.*;

/**
 * Test for the IdOffice class
 * 
 * @author dorian
 */
public class IdOfficeTest {

	OfficeHandler oneIdOffice;
	OfficeHandler anotherIdOffice;

	@Before
	public void setUp() throws MalformedHandlerException {
		oneIdOffice = new OfficeHandler(1234);
		anotherIdOffice = new OfficeHandler(9876);
	}

	@Test
	public void testBuilder() throws MalformedHandlerException {
		oneIdOffice = new OfficeHandler(4637);
		assertEquals("4637", oneIdOffice.toString());
	}

	/**
	 * No more than 4 digits
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testBadIdOffice() throws MalformedHandlerException {
		new OfficeHandler(12345);
	}
        
        /**
         * Test if throw an exception when pass letters instead of numbers
         */
        @Test(expected = MalformedHandlerException.class)
        public void testBadIdOfficeLetters() throws MalformedHandlerException{
            new OfficeHandler("number");
        }

	/**
	 * Test the builder
	 */
	@Test
	public void testIdOffice() throws MalformedHandlerException {
		OfficeHandler id = new OfficeHandler(1234);
		assertEquals(0, id.compareTo(oneIdOffice));
                
                id = new OfficeHandler("1234");
		assertEquals(0, id.compareTo(oneIdOffice));

	}

	/**
	 * Test the method getIdOffice()
	 */
	public void testGetIdOffice() {
		 int id=oneIdOffice.getIdOffice();
		 assertEquals(1234, id);
		
		 id=anotherIdOffice.getIdOffice();
		 assertEquals(9876, id);
	}

	/**
	 * Test of compareTo method, of class IdOffice.
	 */
	@Test
	public void testCompareTo() throws MalformedHandlerException {
		System.out.println("compareTo");
		assertEquals(0, oneIdOffice.compareTo(oneIdOffice));
		assertFalse(oneIdOffice.compareTo(anotherIdOffice) == 0);

		Handler copyIdOffice = new OfficeHandler(Integer.parseInt(oneIdOffice
				.toString()));
		assertEquals(0, oneIdOffice.compareTo(copyIdOffice));
	}

	/**
	 * Test of toString method, of class IdDNI.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "1234";
		String result = oneIdOffice.toString();
		assertEquals(expResult, result);

		expResult = "9876";
		result = anotherIdOffice.toString();
		assertEquals(expResult, result);
	}

}
