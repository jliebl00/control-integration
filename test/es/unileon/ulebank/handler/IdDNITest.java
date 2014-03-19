package es.unileon.ulebank.handler;

import es.unileon.ulebank.exceptions.HandlerException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the IdDNITest class
 * 
 * @author dorian
 */
public class IdDNITest {

	IdDNI oneDNI;
	IdDNI anotherDNI;

	@Before
	public void setUp() {
		oneDNI = new IdDNI("71463395A");
		anotherDNI = new IdDNI("36167364W");
	}

	/**
	 * Test the builder with one parameter
	 */
	@Test
	public void testDNIString() {
		IdDNI id = new IdDNI("0T");
		IdDNI id2 = new IdDNI("000T");
		assertEquals(0, id.compareTo(id2));

	}

	/**
	 * Test the builder with two parameters
	 */
	@Test
	public void testDNIIntChar() {
		IdDNI id = new IdDNI(0, 'T');
		IdDNI id2 = new IdDNI("000T");
		assertEquals(0, id.compareTo(id2));

		IdDNI dni = new IdDNI(71463395, 'A');
		assertEquals(0, oneDNI.compareTo(dni));

	}

	/**
	 * Test the method getNif()
	 */
	public void testGetNif() {
		// int nif=oneDNI.getNif();
		// assertEquals(71463395, nif);
		//
		// nif=anotherDNI.getNif();
		// assertEquals(36167364, nif);

		fail("Implements the methods and descoment the test");
	}

	/**
	 * Test the method getLetter
	 */
	public void testGetLetter() {
		// char letter=oneDNI.getLetter();
		// assertEquals('A', letter);
		//
		// letter=anotherDNI.getLetter();
		// assertEquals('W', letter);

		fail("Implements the methods and descoment the test");
	}

	@Test(expected = HandlerException.class)
	public void testStringNull() {
		Handler id = new IdDNI(null);
	}

	@Test(expected = HandlerException.class)
	public void testIntNull() {
		Integer number = null;
		Handler id = new IdDNI(number, 'A');
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when
	 * there is no number. Need at least one
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testBadDNIStringLenght() throws HandlerException {
		IdDNI id = new IdDNI("A");
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when the
	 * number is too long
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testBadDNIStringTooLenght() throws HandlerException {
		IdDNI id = new IdDNI("7146339571469588A");
	}

	/**
	 * Test the builder with two parameters (int and letter) Throws an exception
	 * when the letter is not the correct letter for the nif
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testIncorrectLetter() throws HandlerException {
		// Letter W is not the correct letter for the dni
		IdDNI id = new IdDNI("71463395W");
	}

	/**
	 * Test the builder with two parameters (int, char) Throws an exception when
	 * the letter not exists as a part of dni
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testInexistLetterWithInt() throws HandlerException {
		// Letter O is not part of the dni
		IdDNI id = new IdDNI(71463395, 'O');
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when the
	 * letter not exists as a part of dni
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testInexistLetter() throws HandlerException {
		// Letter O is not part of the dni
		IdDNI id = new IdDNI("71463395O");
	}

	/**
	 * Test the builder with two parameters (int and letter) Throws an exception
	 * when the letter is not the correct letter for the nif
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testIncorrectLetterWithInt() throws HandlerException {
		// Letter W is not the correct letter for the dni
		IdDNI id = new IdDNI(71463395, 'W');
	}

	/**
	 * Test of builder with one parameter (string). test if throws an error when
	 * give another else instead of the letter
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testNoLetterString() throws HandlerException {
		IdDNI id = new IdDNI("714633959");
	}

	/**
	 * Test of builder with two parameters. test if throws an error when give
	 * another else instead of the letter
	 * 
	 * @throws HandlerException
	 */
	@Test(expected = HandlerException.class)
	public void testNoLetterStringWithInt() throws HandlerException {
		IdDNI id = new IdDNI(71463395, '5');
	}

	/**
	 * Test of compareTo method, of class IdDNI.
	 */
	@Test
	public void testCompareTo() {
		System.out.println("compareTo");
		assertEquals(0, oneDNI.compareTo(oneDNI));
		assertFalse(oneDNI.compareTo(anotherDNI) == 0);

		Handler copyDni = new IdDNI(oneDNI.toString());
		assertEquals(0, oneDNI.compareTo(copyDni));
	}

	/**
	 * Test of toString method, of class IdDNI.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		String expResult = "71463395A";
		String result = oneDNI.toString();
		assertEquals(expResult, result);

		expResult = "36167364W";
		result = anotherDNI.toString();
		assertEquals(expResult, result);
	}

}
