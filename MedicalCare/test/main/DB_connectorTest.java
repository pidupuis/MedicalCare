/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
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
 * @author Vincent
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
     * Test of getInstance method, of class DB_connector.
     */
    @Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        DB_connector expResult = null;
        DB_connector result = DB_connector.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finalize method, of class DB_connector.
     */
    @Test
    public void testFinalize() throws Exception {
        System.out.println("finalize");
        DB_connector instance = null;
        //instance.finalize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPatient method, of class DB_connector.
     */
    @Test
    public void testAddPatient() throws Exception {
        System.out.println("addPatient");
        Patient p = null;
        DB_connector instance = null;
        instance.addPatient(p);
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
        DB_connector instance = null;
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
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.addEEG(electro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEffortTest method, of class DB_connector.
     */
    @Test
    public void testAddEffortTest() {
        System.out.println("addEffortTest");
        EffortTest effort = null;
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.addEffortTest(effort);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDoctor method, of class DB_connector.
     */
    @Test
    public void testAddDoctor() {
        System.out.println("addDoctor");
        DB_connector instance = null;
        instance.addDoctor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCRA method, of class DB_connector.
     */
    @Test
    public void testAddCRA() {
        System.out.println("addCRA");
        DB_connector instance = null;
        instance.addCRA();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUncheckedInfo method, of class DB_connector.
     */
    @Test
    public void testGetUncheckedInfo() {
        System.out.println("getUncheckedInfo");
        DB_connector instance = null;
        DailyTest[] expResult = null;
        DailyTest[] result = instance.getUncheckedInfo();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DB_connector.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String login = "";
        String password = "";
        String statut = "";
        DB_connector instance = null;
        instance.addUser(login, password, statut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class DB_connector.
     */
    @Test
    public void testCheckUser() throws Exception {
        System.out.println("checkUser");
        String login = "";
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.checkUser(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userSelection method, of class DB_connector.
     */
    @Test
    public void testUserSelection() {
        System.out.println("userSelection");
        String login = "";
        String password = "";
        DB_connector instance = null;
        instance.userSelection(login, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delPatient method, of class DB_connector.
     */
    @Test
    public void testDelPatient() {
        System.out.println("delPatient");
        String id = "";
        DB_connector instance = null;
        instance.delPatient(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctorConsultations method, of class DB_connector.
     */
    @Test
    public void testGetDoctorConsultations() {
        System.out.println("getDoctorConsultations");
        int idDoctor = 0;
        DB_connector instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getDoctorConsultations(idDoctor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatient method, of class DB_connector.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        String lastname = "";
        String firstname = "";
        Calendar birthday = null;
        DB_connector instance = null;
        instance.getPatient(lastname, firstname, birthday);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPatient method, of class DB_connector.
     */
    @Test
    public void testGetListPatient() throws Exception {
        System.out.println("getListPatient");
        DB_connector instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getListPatient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyTests method, of class DB_connector.
     */
    @Test
    public void testGetDailyTests() {
        System.out.println("getDailyTests");
        String idPatient = "";
        String day = "";
        DB_connector instance = null;
        instance.getDailyTests(idPatient, day);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyTest method, of class DB_connector.
     */
    @Test
    public void testUpdateDailyTest() {
        System.out.println("updateDailyTest");
        int idTest = 0;
        DB_connector instance = null;
        instance.updateDailyTest(idTest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addSubGroup method, of class DB_connector.
     */
    @Test
    public void testAddSubGroup() {
        System.out.println("addSubGroup");
        Group sg = null;
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.addSubGroup(sg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubGroup method, of class DB_connector.
     */
    @Test
    public void testSetSubGroup() {
        System.out.println("setSubGroup");
        Patient p = null;
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.setSubGroup(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPatientToGroup method, of class DB_connector.
     */
    @Test
    public void testAddPatientToGroup() {
        System.out.println("addPatientToGroup");
        Patient p = null;
        Group g = null;
        DB_connector instance = null;
        instance.addPatientToGroup(p, g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoSubGroup method, of class DB_connector.
     */
    @Test
    public void testGetInfoSubGroup() {
        System.out.println("getInfoSubGroup");
        String id = "";
        DB_connector instance = null;
        Group expResult = null;
        Group result = instance.getInfoSubGroup(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
