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
 * @author Cogotch
 */
public class BloodTestTest {
    
    public BloodTestTest() {
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
     * Test of getResults method, of class BloodTest.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        BloodTest instance = null;
        float[] expResult = null;
        float[] result = instance.getResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResults method, of class BloodTest.
     */
    @Test
    public void testSetResults() {
        System.out.println("setResults");
        float[] results = null;
        BloodTest instance = null;
        instance.setResults(results);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
