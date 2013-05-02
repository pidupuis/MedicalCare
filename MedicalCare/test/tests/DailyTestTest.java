package tests;

import java.util.Date;
import java.util.GregorianCalendar;
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
        DailyTest instance = new DailyTest(12, 13, 50, "Aucune", false, false, false, null);
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
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
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
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
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
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
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
    public void testGetCheckNotes() throws Exception {
        System.out.println("getCheckNotes");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = null;
        String result = instance.getCheckNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCheckNotes method, of class DailyTest.
     */
    @Test
    public void testSetCheckNotes() throws Exception {
        System.out.println("setCheckNotes");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = "Test des check notes.";
        instance.setCheckNotes("Test des check notes.");
        String result = instance.getCheckNotes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getChecked method, of class DailyTest.
     */
    @Test
    public void testGetChecked() throws Exception {
        System.out.println("getChecked");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        boolean expResult = false;
        boolean result = instance.getChecked();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChecked method, of class DailyTest.
     */
    @Test
    public void testSetChecked() throws Exception {
        System.out.println("setChecked");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        boolean expResult = false;
        boolean result = instance.getChecked();
        assertEquals(expResult, result);
        instance.setChecked(true);
        expResult = true;
        result = instance.getChecked();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDailyDate method, of class DailyTest.
     */
    @Test
    public void testGetDailyDate() throws Exception {
        System.out.println("getDailyDate");
        GregorianCalendar dailyDate = new GregorianCalendar(2005, 2, 10);
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, dailyDate);
        GregorianCalendar expResult = dailyDate;
        GregorianCalendar result = instance.getDailyDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDailyDate method, of class DailyTest.
     */
    @Test
    public void testSetDailyDate() throws Exception {
        System.out.println("setDailyDate");
        GregorianCalendar testDate = new GregorianCalendar(2005, 2, 10);
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, testDate);
        testDate = new GregorianCalendar(2005, 7, 10);
        instance.setDailyDate(testDate);
        GregorianCalendar expResult = testDate;
        GregorianCalendar result = instance.getDailyDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReasonExclusion method, of class DailyTest.
     */
    @Test
    public void testGetReasonExclusion() throws Exception {
        System.out.println("getReasonExclusion");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = null;
        String result = instance.getReasonExclusion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReasonExclusion method, of class DailyTest.
     */
    @Test
    public void testSetReasonExclusion() throws Exception {
        System.out.println("setReasonExclusion");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        instance.setReasonExclusion("Il est mort !");
        String expResult = "Il est mort !";
        String result = instance.getReasonExclusion();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getBloodTest method, of class DailyTest.
     */
    @Test
    public void testGetBloodTest() throws Exception {
        System.out.println("getBloodTest");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = null;
        BloodTest result = instance.getBloodTest();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBlood method, of class DailyTest.
     */
    @Test
    public void testAddBlood() throws Exception {
        System.out.println("addBlood");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        Patient testPatient = new Patient("Jean", "Moulin", 1980, 11, 13, true);
        boolean expResult = true;
        instance.addBlood(15, 5, 8, 45, 250, testPatient);
        boolean result = false;
        if (instance.getBloodTest() != null) {
            result = true;
        }
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEEGTest method, of class DailyTest.
     */
    @Test
    public void testGetEEGTest() throws Exception {
        System.out.println("getEEGTest");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = null;
        EEG result = instance.getEEGTest();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEEG method, of class DailyTest.
     */
    @Test
    public void testAddEEG() throws Exception {
        System.out.println("addEEG");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        boolean expResult = true;
        instance.addEEG(4);
        boolean result = false;
        if (instance.getEEGTest() != null) {
            result = true;
        }
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEffortTest method, of class DailyTest.
     */
    @Test
    public void testGetEffortTest() throws Exception {
        System.out.println("getEffortTest");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        String expResult = null;
        EffortTest result = instance.getEffortTest();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEffort method, of class DailyTest.
     */
    @Test
    public void testAddEffort() throws Exception {
        System.out.println("addEffort");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", false, false, false, null);
        boolean expResult = true;
        instance.addEffort(60, 110, 80);
        boolean result = false;
        if (instance.getEffortTest() != null) {
            result = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of checkTest method, of class DailyTest.
     */
    @Test
    public void testCheckTest() throws Exception {
        System.out.println("checkTest");
        DailyTest instance = new DailyTest(12, 20, 50, "Aucune", true, true, false, null);
        instance.addEffort(60, 110, 80);
        instance.addEEG(4);
        boolean expResult = true;
        boolean result = true;
        try {
            instance.checkTest();
        }
        catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);
    }
}
