package tests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vincent
 */
public class EEGTest {
    
    public EEGTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getResult method, of class EEG.
     */
    @Test
    public void testGetResult() throws Exception {
        System.out.println("getResult");
        EEG instance = new EEG(5);
        int expResult = 5;
        int result = instance.getResult();
        assertEquals(expResult, result);
    }

    /**
     * Test of setResult method, of class EEG.
     */
    @Test
    public void testSetResult() throws Exception {
        System.out.println("setResult");
        EEG instance = new EEG(5);
        try {
            instance.setResult(7);
        }
        catch (Exception e) {}
        int expResult = 7;
        int result = instance.getResult();
        assertEquals(expResult, result);
        try {
            instance.setResult(11);
        }
        catch (Exception e) {}
        result = instance.getResult();
        assertEquals(expResult, result);
    }
}
