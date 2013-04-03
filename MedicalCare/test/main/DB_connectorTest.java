/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persons.Patient;
import tests.BloodTest;
import tests.DailyTest;
import tests.EEG;
import tests.EffortTest;

/**
 *
 * @author Cogotch
 */
public class DB_connectorTest {
    
    public DB_connectorTest() {
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
     * Test of addPatient method, of class DB_connector.
     */
    @Test
    public void testAddPatient() {
        System.out.println("addPatient");
        Patient p = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.addPatient(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBloodTest method, of class DB_connector.
     */
    @Test
    public void testAddBloodTest() {
        System.out.println("addBloodTest");
        BloodTest bt = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.addBloodTest(bt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEEG method, of class DB_connector.
     */
    @Test
    public void testAddEEG() {
        System.out.println("addEEG");
        EEG electro = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.addEEG(electro);
        assertEquals(expResult, result);

    }

    /**
     * Test of addEffortTest method, of class DB_connector.
     */
    @Test
    public void testAddEffortTest() {
        System.out.println("addEffortTest");
        EffortTest effort = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.addEffortTest(effort);
        assertEquals(expResult, result);

    }

    /**
     * Test of addDoctor method, of class DB_connector.
     */
    @Test
    public void testAddDoctor() {
        System.out.println("addDoctor");
        DB_connector instance =null;
        instance.addDoctor();

    }

    /**
     * Test of addCRA method, of class DB_connector.
     */
    @Test
    public void testAddCRA() {
        System.out.println("addCRA");
        DB_connector instance =null;
        instance.addCRA();

    }

    /**
     * Test of getUncheckedInfo method, of class DB_connector.
     */
    @Test
    public void testGetUncheckedInfo() {
        System.out.println("getUncheckedInfo");
        DB_connector instance =null;
        DailyTest[] expResult = null;
        DailyTest[] result = instance.getUncheckedInfo();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of userSelection method, of class DB_connector.
     */
    @Test
    public void testUserSelection() {
        System.out.println("userSelection");
        String login = "";
        String password = "";
        DB_connector instance =null;
        instance.userSelection(login, password);

    }

    /**
     * Test of delPatient method, of class DB_connector.
     */
    @Test
    public void testDelPatient() {
        System.out.println("delPatient");
        String id = "";
        DB_connector instance =null;
        instance.delPatient(id);

    }

    /**
     * Test of getDoctorConsultations method, of class DB_connector.
     */
    @Test
    public void testGetDoctorConsultations() {
        System.out.println("getDoctorConsultations");
        int idDoctor = 0;
        DB_connector instance =null;
        ArrayList expResult = null;
        ArrayList result = instance.getDoctorConsultations(idDoctor);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPatient method, of class DB_connector.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        String id = "";
        DB_connector instance =null;
        //DB_connector.getPatient(id);

    }

    /**
     * Test of getListPatient method, of class DB_connector.
     */
    @Test
    public void testGetListPatient() {
        System.out.println("getListPatient");
        DB_connector instance =null;
        ArrayList expResult = null;
        ArrayList result = instance.getListPatient();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDailyTests method, of class DB_connector.
     */
    @Test
    public void testGetDailyTests() {
        System.out.println("getDailyTests");
        String idPatient = "";
        String day = "";
        DB_connector instance =null;
        instance.getDailyTests(idPatient, day);

    }

    /**
     * Test of updateDailyTest method, of class DB_connector.
     */
    @Test
    public void testUpdateDailyTest() {
        System.out.println("updateDailyTest");
        int idTest = 0;
        DB_connector instance =null;
        instance.updateDailyTest(idTest);

    }

    /**
     * Test of addSubGroup method, of class DB_connector.
     */
    @Test
    public void testAddSubGroup() {
        System.out.println("addSubGroup");
        Group sg = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.addSubGroup(sg);
        assertEquals(expResult, result);

    }

    /**
     * Test of setSubGroup method, of class DB_connector.
     */
    @Test
    public void testSetSubGroup() {
        System.out.println("setSubGroup");
        Patient p = null;
        DB_connector instance =null;
        boolean expResult = false;
        boolean result = instance.setSubGroup(p);
        assertEquals(expResult, result);

    }

    /**
     * Test of addPatientToGroup method, of class DB_connector.
     */
    @Test
    public void testAddPatientToGroup() {
        System.out.println("addPatientToGroup");
        Patient p = null;
        Group g = null;
        DB_connector instance =null;
        instance.addPatientToGroup(p, g);

    }

    /**
     * Test of getInfoSubGroup method, of class DB_connector.
     */
    @Test
    public void testGetInfoSubGroup() {
        System.out.println("getInfoSubGroup");
        String id = "";
        DB_connector instance =null;
        Group expResult = null;
        Group result = instance.getInfoSubGroup(id);
        assertEquals(expResult, result);

    }
}