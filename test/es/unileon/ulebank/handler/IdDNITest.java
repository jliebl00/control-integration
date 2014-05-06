package es.unileon.ulebank.handler;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.MalformedHandlerException;
import static org.junit.Assert.*;

/**
 * Test for the IdDNITest class
 * 
 * @author dorian
 */
public class IdDNITest {
	DNIHandler oneDNI;
	DNIHandler anotherDNI;

	@Before
	public void setUp() throws MalformedHandlerException {
		oneDNI = new DNIHandler("71463395A");
		anotherDNI = new DNIHandler("36167364W");
	}

	/**
	 * Test the builder with one parameter
	 */
	@Test
	public void testDNIString() throws MalformedHandlerException {
		DNIHandler id = new DNIHandler("0T");
		DNIHandler id2 = new DNIHandler("000T");
		assertEquals(0, id.compareTo(id2));

	}

	/**
	 * Test the builder with two parameters
	 */
	@Test
	public void testDNIIntChar() throws MalformedHandlerException {
		DNIHandler id = new DNIHandler(0, 'T');
		DNIHandler id2 = new DNIHandler("000T");
		assertEquals(0, id.compareTo(id2));

		DNIHandler dni = new DNIHandler(71463395, 'A');
		assertEquals(0, oneDNI.compareTo(dni));

	}

	/**
	 * Test the method getNif()
	 */
        /*
	public void testGetNif() {
		int nif = oneDNI.getNif();
		assertEquals(71463395, nif);

		nif = anotherDNI.getNif();
		assertEquals(36167364, nif);
	}

	/**
	 * Test the method getLetter
	 */
        /*
	public void testGetLetter() {
		char letter = oneDNI.getLetter();
		assertEquals('A', letter);

		letter = anotherDNI.getLetter();
		assertEquals('W', letter);
	}*/

	/**
	 * Test if throw an exception when give null
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testStringNull() throws MalformedHandlerException {
		new DNIHandler(null);
	}

	/**
	 * Test if throw an exception when give null
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testIntNull() throws MalformedHandlerException {
		Integer number = null;
		new DNIHandler(number, 'A');
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when
	 * there is no number. Need at least one
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testBadDNIStringLenght() throws MalformedHandlerException {
		new DNIHandler("A");
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when the
	 * number is too long
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testBadDNIStringTooLenght() throws MalformedHandlerException {
		new DNIHandler("714633957A");
	}

	/**
	 * Test the builder with two parameters (int and letter) Throws an exception
	 * when the letter is not the correct letter for the nif
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testIncorrectLetter() throws MalformedHandlerException {
		// Letter W is not the correct letter for the dni
		new DNIHandler("71463395W");
	}

	/**
	 * Test the builder with two parameters (int, char) Throws an exception when
	 * the letter not exists as a part of dni
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testInexistLetterWithInt() throws MalformedHandlerException {
		// Letter O is not part of the dni
		new DNIHandler(71463395, 'O');
	}

	/**
	 * Test the builder with one parameter (string) Throws an exception when the
	 * letter not exists as a part of dni
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testInexistLetter() throws MalformedHandlerException {
		// Letter O is not part of the dni
		new DNIHandler("71463395O");
	}

	/**
	 * Test the builder with two parameters (int and letter) Throws an exception
	 * when the letter is not the correct letter for the nif
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testIncorrectLetterWithInt() throws MalformedHandlerException {
		// Letter W is not the correct letter for the dni
		new DNIHandler(71463395, 'W');
	}

	/**
	 * Test of builder with one parameter (string). test if throws an error when
	 * give another else instead of the letter
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testNoLetterString() throws MalformedHandlerException {
		new DNIHandler("714633959");
	}

	/**
	 * Test of builder with two parameters. test if throws an error when give
	 * another else instead of the letter
	 * 
	 * @throws MalformedHandlerException
	 */
	@Test(expected = MalformedHandlerException.class)
	public void testNoLetterStringWithInt() throws MalformedHandlerException {
		new DNIHandler(71463395, '5');
	}

	/**
	 * Test of compareTo method, of class IdDNI.
	 */
	@Test
	public void testCompareTo() throws MalformedHandlerException {
		System.out.println("compareTo");
		assertEquals(0, oneDNI.compareTo(oneDNI));
		assertFalse(oneDNI.compareTo(anotherDNI) == 0);

		Handler copyDni = new DNIHandler(oneDNI.toString());
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
