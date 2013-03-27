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
public class AnalysisTest {
    
    public AnalysisTest() {
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
     * Test of getObservations method, of class Analysis.
     */
    @Test
    public void testGetObservations() {
        System.out.println("getObservations");
        Analysis instance = new AnalysisImpl();
        String expResult = "";
        String result = instance.getObservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservations method, of class Analysis.
     */
    @Test
    public void testSetObservations() {
        System.out.println("setObservations");
        String observations = "";
        Analysis instance = new AnalysisImpl();
        instance.setObservations(observations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AnalysisImpl extends Analysis {
    }
}
