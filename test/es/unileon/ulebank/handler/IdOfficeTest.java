package es.unileon.ulebank.handler;

import es.unileon.ulebank.exceptions.HandlerException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the IdOffice class
 * @author dorian
 */
public class IdOfficeTest {
    
    IdOffice oneIdOffice;
    IdOffice anotherIdOffice;

    @Before
    public void setUp() {
        oneIdOffice = new IdOffice(1234);
        anotherIdOffice = new IdOffice(9876);
    }
    
    @Test
    public void testBuilder(){
        oneIdOffice=new IdOffice(4637);
        assertEquals(4637, oneIdOffice.toString());
    }
    
    /**
     * No more than 4 digits
     */
    @Test(expected = HandlerException.class)
    public void testBadIdOffice(){
        new IdOffice(12345);
    }

    /**
     * Test the builder
     */
    @Test
    public void testIdOffice() {
        IdOffice id = new IdOffice(1234);
        assertEquals(0, id.compareTo(oneIdOffice));

    }
    
    /**
     * Test the method getIdOffice()
     */
    public void testGetIdOffice(){
//        int id=oneDNI.getIdOffice();
//        assertEquals(1234, id);
//        
//        id=anotherDNI.getIdOffice();
//        assertEquals(9876, id);
        
        fail("Implements the methods and descoment the test");
    }
    
     /**
     * Test of compareTo method, of class IdOffice.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        assertEquals(0, oneIdOffice.compareTo(oneIdOffice));
        assertFalse(oneIdOffice.compareTo(anotherIdOffice) == 0);

        Handler copyIdOffice = new IdOffice(Integer.parseInt(oneIdOffice.toString()));
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
