package es.unileon.ulebank.handler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.MalformedHandlerException;

public class HandlerShareTest {

    private Handler test1, test2, test3;

    @Before
    public void setUp() throws Exception {
        this.test1 = new ShareHandler("san", "santander", "IBEX");
        this.test2 = new ShareHandler("BBVA", "BBVA", "IBEX");
        this.test3 = new ShareHandler("A3M", "A3Media", "IBEX");
    }

    @Test
    public void testTicker() {
        assertTrue(this.test1.toString().equals("SAN santander IBEX"));
        assertTrue(this.test2.toString().equals("BBVA BBVA IBEX"));
        assertTrue(this.test3.toString().equals("A3M A3Media IBEX"));
    }

    @Test
    public void testCompareTo() throws MalformedHandlerException {
        assertFalse(this.test1.compareTo(this.test2) == 0);
        assertTrue(this.test1.compareTo(new ShareHandler("san", "santander", "IBEX")) == 0);
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMalformedHandlerExceptionTwoTicker() throws MalformedHandlerException {
        new ShareHandler("BB", "BBVA", "IBEX");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testMalformedHandlerExceptionFiveTicker() throws MalformedHandlerException {
        new ShareHandler("SANTA", "santander", "IBEX");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testDiferentTickerNotEqualCompany() throws MalformedHandlerException {
        new ShareHandler("BBV", "Santander", "IBEX");
    }

    @Test(expected = MalformedHandlerException.class)
    public void testSpecialCharacterException() throws MalformedHandlerException {
        /**
         * Me quitan de las manos las acciones de bicicletas piticlin!
         */
        new ShareHandler("T.T", "Bicicletas Piticlin SA", "NASDAQ");
    }

}
