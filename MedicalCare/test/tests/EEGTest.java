/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testGetResult() {
        System.out.println("getResult");
        EEG instance = null;
        int expResult = 0;
        int result = instance.getResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResult method, of class EEG.
     */
    @Test
    public void testSetResult() throws Exception {
        System.out.println("setResult");
        int result_2 = 0;
        EEG instance = null;
        instance.setResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
