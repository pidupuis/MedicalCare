package tests;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persons.Patient;

/**
 *
 * @author Vincent Emonet
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
    public void testGetBloodPressure() throws Exception {
        System.out.println("getBloodPressure");
        DailyTest instance = new DailyTest(12, 13, 50, "Aucune", false, false, false);
        int[] expResult = new int[2];
        expResult[0] = 12;
        expResult[1] = 13;
        int[] result = instance.getBloodPressure();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setBloodPressure method, of class DailyTest.
     */
    @Test
    public void testSetBloodPressure() throws Exception {
        System.out.println("setBloodPressure");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false);
        int[] expResult = new int[2];
        expResult[0] = 12;
        expResult[1] = 20;
        try {
            instance.setBloodPressure(27, 20);  // Test si la valeur est bien refusee
        }
        catch (Exception e) {}
        int[] result = instance.getBloodPressure();
        assertArrayEquals(expResult, result);
        expResult[0] = 16;
        expResult[1] = 19;
        try {
            instance.setBloodPressure(16, 19);  // Test si la valeur est correcte.
        }
        catch (Exception e) {}
        result = instance.getBloodPressure();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getHeartBeats method, of class DailyTest.
     */
    @Test
    public void testGetHeartBeats() throws Exception {
        System.out.println("getHeartBeats");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false);
        int expResult = 50;
        int result = instance.getHeartBeats();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHeartBeats method, of class DailyTest.
     */
    @Test
    public void testSetHeartBeats() throws Exception {
        System.out.println("setHeartBeats");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false);
        try {
            instance.setHeartBeats(256);
        }
        catch (Exception e) {}
        int expResult = 50;
        int result = instance.getHeartBeats();
        assertEquals(expResult, result);
        instance.setHeartBeats(78);
        expResult = 78;
        result = instance.getHeartBeats();
        assertEquals(expResult, result);
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

    /**
     * Test of addBlood method, of class DailyTest.
     */
    @Test
    public void testAddBlood() {
        System.out.println("addBlood");
        float Hb = 0.0F;
        float GR = 0.0F;
        float GB = 0.0F;
        float hemato = 0.0F;
        float P = 0.0F;
        Patient p = null;
        DailyTest instance = null;
        instance.addBlood(Hb, GR, GB, hemato, P, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEEG method, of class DailyTest.
     */
    @Test
    public void testAddEEG() throws Exception {
        System.out.println("addEEG");
        int result_2 = 0;
        DailyTest instance = null;
        instance.addEEG(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEffort method, of class DailyTest.
     */
    @Test
    public void testAddEffort() throws Exception {
        System.out.println("addEffort");
        int before = 0;
        int after = 0;
        int later = 0;
        DailyTest instance = null;
        instance.addEffort(before, after, later);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTest method, of class DailyTest.
     */
    @Test
    public void testCheckTest() throws Exception {
        System.out.println("checkTest");
        DailyTest instance = null;
        instance.checkTest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
