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
import persons.Patient;

/**
 *
 * @author Vincent
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
     * Test of checkResult method, of class BloodTest.
     */
    @Test
    public void testCheckResult() throws Exception {
        System.out.println("checkResult");
        float Hb = 0.0F;
        float GR = 0.0F;
        float GB = 0.0F;
        float hemato = 0.0F;
        float P = 0.0F;
        Patient p = null;
        BloodTest instance = null;
        instance.checkResult(Hb, GR, GB, hemato, P, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResults method, of class BloodTest.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        int index = 0;
        BloodTest instance = null;
        float expResult = 0.0F;
        float result = instance.getResults(index);
        assertEquals(expResult, result, 0.0);
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
