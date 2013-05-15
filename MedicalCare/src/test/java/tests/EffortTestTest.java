package tests;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Cogotch
 */
public class EffortTestTest {
    
    public EffortTestTest() {
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
     * Test of getBeforeEffort method, of class EffortTest.
     */
    @Test
    public void testGetBeforeEffort() throws Exception {
        System.out.println("getBeforeEffort");
        EffortTest instance = new EffortTest(50, 70, 60);
        int expResult = 50;
        int result = instance.getBeforeEffort();
        assertEquals(expResult, result);
        try {
            instance = new EffortTest(300, 100, 90);
        }
        catch (Exception e) {}
        result = instance.getBeforeEffort();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBeforeEffort method, of class EffortTest.
     */
    @Test
    public void testSetBeforeEffort() throws Exception {
        System.out.println("setBeforeEffort");
        int beforeEffort = 55;
        EffortTest instance = new EffortTest(50, 70, 60);
        instance.setBeforeEffort(beforeEffort);
        int expResult = beforeEffort;
        int result = instance.getBeforeEffort();
        assertEquals(expResult, result);
        try {
            instance.setBeforeEffort(25);
        }
        catch (Exception e) {}
        result = instance.getBeforeEffort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostEffort method, of class EffortTest.
     */
    @Test
    public void testGetPostEffort() throws Exception {
        System.out.println("getPostEffort");
        EffortTest instance = new EffortTest(50, 70, 60);
        int expResult = 70;
        int result = instance.getPostEffort();
        assertEquals(expResult, result);
        try {
            instance = new EffortTest(80, 300, 90);
        }
        catch (Exception e) {}
        result = instance.getPostEffort();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPostEffort method, of class EffortTest.
     */
    @Test
    public void testSetPostEffort() throws Exception {
        System.out.println("setPostEffort");
        int postEffort = 80;
        EffortTest instance = new EffortTest(50, 70, 60);
        instance.setPostEffort(postEffort);
        int expResult = postEffort;
        int result = instance.getPostEffort();
        assertEquals(expResult, result);
        try {
            instance.setPostEffort(10);
        }
        catch (Exception e) {}
        result = instance.getPostEffort();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTimePlusOne method, of class EffortTest.
     */
    @Test
    public void testGetTimePlusOne() throws Exception {
        System.out.println("getTimePlusOne");
        EffortTest instance = new EffortTest(50, 70, 60);
        int expResult = 60;
        int result = instance.getTimePlusOne();
        assertEquals(expResult, result);
        try {
            instance = new EffortTest(80, 100, 300);
        }
        catch (Exception e) {}
        result = instance.getTimePlusOne();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimePlusOne method, of class EffortTest.
     */
    @Test
    public void testSetTimePlusOne() throws Exception {
        System.out.println("setTimePlusOne");
        int timePlusOne = 100;
        EffortTest instance = new EffortTest(50, 70, 60);
        instance.setTimePlusOne(timePlusOne);
        int expResult = timePlusOne;
        int result = instance.getTimePlusOne();
        assertEquals(expResult, result);
        try {
            instance.setTimePlusOne(15);
        }
        catch (Exception e) {}
        result = instance.getTimePlusOne();
        assertEquals(expResult, result);
    }
}
