package tests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vincent Emonet
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
        Analysis instance = new AnalysisImpl("Tests observations");
        String expResult = "Tests observations";
        String result = instance.getObservations();
        assertEquals(expResult, result);
    }

    /**
     * Test of setObservations method, of class Analysis.
     */
    @Test
    public void testSetObservations() {
        System.out.println("setObservations");
        String observations = "Test observations";
        Analysis instance = new AnalysisImpl("Test test");
        instance.setObservations(observations);
        String result = instance.getObservations();
        String expResult = observations;
        assertEquals(expResult, result);
    }

    public class AnalysisImpl extends Analysis {
        public AnalysisImpl(String observations) {
            super(observations);
        }
    }
}
