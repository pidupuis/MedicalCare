/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Date;
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
public class DailyTestTest {
    
    public DailyTestTest() {
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
     * Test of getBloodPressure method, of class DailyTest.
     */
    @Test
    public void testGetBloodPressure() {
        System.out.println("getBloodPressure");
        DailyTest instance = null;
        int[] expResult = null;
        int[] result = instance.getBloodPressure();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBloodPressure method, of class DailyTest.
     */
    @Test
    public void testSetBloodPressure() {
        System.out.println("setBloodPressure");
        int[] bloodPressure = null;
        DailyTest instance = null;
        instance.setBloodPressure(bloodPressure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeartBeats method, of class DailyTest.
     */
    @Test
    public void testGetHeartBeats() {
        System.out.println("getHeartBeats");
        DailyTest instance = null;
        int expResult = 0;
        int result = instance.getHeartBeats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeartBeats method, of class DailyTest.
     */
    @Test
    public void testSetHeartBeats() {
        System.out.println("setHeartBeats");
        int heartBeats = 0;
        DailyTest instance = null;
        instance.setHeartBeats(heartBeats);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservations method, of class DailyTest.
     */
    @Test
    public void testGetObservations() {
        System.out.println("getObservations");
        DailyTest instance = null;
        String expResult = "";
        String result = instance.getObservations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservations method, of class DailyTest.
     */
    @Test
    public void testSetObservations() {
        System.out.println("setObservations");
        String observations = "";
        DailyTest instance = null;
        instance.setObservations(observations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCheckNotes method, of class DailyTest.
     */
    @Test
    public void testGetCheckNotes() {
        System.out.println("getCheckNotes");
        DailyTest instance = null;
        String expResult = "";
        String result = instance.getCheckNotes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCheckNotes method, of class DailyTest.
     */
    @Test
    public void testSetCheckNotes() {
        System.out.println("setCheckNotes");
        String checkNotes = "";
        DailyTest instance = null;
        instance.setCheckNotes(checkNotes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChecked method, of class DailyTest.
     */
    @Test
    public void testGetChecked() {
        System.out.println("getChecked");
        DailyTest instance = null;
        boolean expResult = false;
        boolean result = instance.getChecked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChecked method, of class DailyTest.
     */
    @Test
    public void testSetChecked() {
        System.out.println("setChecked");
        boolean checked = false;
        DailyTest instance = null;
        instance.setChecked(checked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyDate method, of class DailyTest.
     */
    @Test
    public void testGetDailyDate() {
        System.out.println("getDailyDate");
        DailyTest instance = null;
        Date expResult = null;
        Date result = instance.getDailyDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDailyDate method, of class DailyTest.
     */
    @Test
    public void testSetDailyDate() {
        System.out.println("setDailyDate");
        Date dailyDate = null;
        DailyTest instance = null;
        instance.setDailyDate(dailyDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReasonExclusion method, of class DailyTest.
     */
    @Test
    public void testGetReasonExclusion() {
        System.out.println("getReasonExclusion");
        DailyTest instance = null;
        String expResult = "";
        String result = instance.getReasonExclusion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReasonExclusion method, of class DailyTest.
     */
    @Test
    public void testSetReasonExclusion() {
        System.out.println("setReasonExclusion");
        String reasonExclusion = "";
        DailyTest instance = null;
        instance.setReasonExclusion(reasonExclusion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayInformations method, of class DailyTest.
     */
    @Test
    public void testDisplayInformations() {
        System.out.println("displayInformations");
        DailyTest instance = null;
        instance.displayInformations();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
