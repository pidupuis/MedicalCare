/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persons.Actor;
import persons.CRA;
import persons.DataManager;
import persons.Doctor;
import persons.Patient;
import tests.BloodTest;
import tests.DailyTest;
import tests.EEG;
import tests.EffortTest;

/**
 *
 * @author Katia
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
    //@Test
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
    //@Test
    public void testFinalize() throws Exception, Throwable {
        System.out.println("finalize");
        DB_connector instance = null;
        instance.finalize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPatient method, of class DB_connector.
     */
    //@Test
    public void testAddPatient() throws Exception {
        System.out.println("addPatient");
        Patient p = null;
        DB_connector instance = null;
        instance.addPatient(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEEG method, of class DB_connector.
     */
    //@Test
    public void testAddEEG() {
        System.out.println("addEEG");
        EEG electro = null;
        Patient p = null;
        DB_connector instance = null;
        instance.addEEG(electro, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEffortTest method, of class DB_connector.
     */
    //@Test
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
     * Test of checkIfAnalysisExists method, of class DB_connector.
     */
    //@Test
    public void testCheckIfAnalysisExists() throws Exception {
        System.out.println("checkIfAnalysisExists");
        String analyse = "";
        String idPatient = "";
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.checkIfAnalysisExists(analyse, idPatient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDoctor method, of class DB_connector.
     */
    //@Test
    public void testAddDoctor() throws Exception {
        System.out.println("addDoctor");
        Doctor d = null;
        MedicalCenter centre = null;
        CRA c = null;
        DB_connector instance = null;
        instance.addDoctor(d, centre, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCRA method, of class DB_connector.
     */
    //@Test
    public void testAddCRA() throws Exception {
        System.out.println("addCRA");
        CRA c = null;
        DataManager dm = null;
        DB_connector instance = null;
        instance.addCRA(c, dm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDataManager method, of class DB_connector.
     */
    //@Test
    public void testAddDataManager() throws Exception {
        System.out.println("addDataManager");
        DataManager dm = null;
        DB_connector instance = null;
        instance.addDataManager(dm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DB_connector.
     */
    //@Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String id = "";
        String login = "";
        String password = "";
        int statut = 0;
        String question = "";
        DB_connector instance = null;
        instance.addUser(id, login, password, statut, question);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUser method, of class DB_connector.
     */
    //@Test
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
     * Test of getUserId method, of class DB_connector.
     */
    //@Test
    public void testGetUserId() throws Exception {
        System.out.println("getUserId");
        String firstname = "";
        String lastname = "";
        int statut = 0;
        DB_connector instance = null;
        int expResult = 0;
        int result = instance.getUserId(firstname, lastname, statut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserById method, of class DB_connector.
     */
    //@Test
    public void testGetUserById() throws Exception {
        System.out.println("getUserById");
        int id = 0;
        int statut = 0;
        DB_connector instance = null;
        Actor expResult = null;
        Actor result = instance.getUserById(id, statut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectionUser method, of class DB_connector.
     */
    //@Test
    public void testConnectionUser() throws Exception {
        System.out.println("connectionUser");
        String login = "";
        String password = "";
        String user = "";
        DB_connector instance = null;
        Actor expResult = null;
        Actor result = instance.connectionUser(login, password, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserQuestion method, of class DB_connector.
     */
    //@Test
    public void testGetUserQuestion() throws Exception {
        System.out.println("getUserQuestion");
        String login = "";
        DB_connector instance = null;
        String expResult = "";
        String result = instance.getUserQuestion(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserAnswer method, of class DB_connector.
     */
    //@Test
    public void testCheckUserAnswer() throws Exception {
        System.out.println("checkUserAnswer");
        String answer = "";
        String login = "";
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.checkUserAnswer(answer, login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class DB_connector.
     */
    //@Test
    public void testCheckPassword() throws Exception {
        System.out.println("checkPassword");
        String password = "";
        DB_connector instance = null;
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPassword method, of class DB_connector.
     */
    //@Test
    public void testResetPassword() throws Exception {
        System.out.println("resetPassword");
        String login = "";
        String password = "";
        DB_connector instance = null;
        instance.resetPassword(login, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excludePatient method, of class DB_connector.
     */
    //@Test
    public void testExcludePatient() throws Exception {
        System.out.println("excludePatient");
        String id = "";
        String why = "";
        DB_connector instance = null;
        instance.excludePatient(id, why);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatient method, of class DB_connector.
     */
    //@Test
    public void testGetPatient() throws Exception {
        System.out.println("getPatient");
        String lastname = "";
        String firstname = "";
        String birthday = "";
        DB_connector instance = null;
        Patient expResult = null;
        Patient result = instance.getPatient(lastname, firstname, birthday);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientById method, of class DB_connector.
     */
    @Test
    public void testGetPatientById() throws Exception {
        System.out.println("getPatientById");
        String id = "1";
        DB_connector instance = DB_connector.getInstance();
        Patient expResult = new Patient("John", "Smith", "1");
        Patient result = instance.getPatientById(id);
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of getListPatient method, of class DB_connector.
     */
    //@Test
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
     * Test of getListPatientFromDoctor method, of class DB_connector.
     */
    //@Test
    public void testGetListPatientFromDoctor() throws Exception {
        System.out.println("getListPatientFromDoctor");
        Doctor Doc = null;
        DB_connector instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getListPatientFromDoctor(Doc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctorByName method, of class DB_connector.
     */
    //@Test
    public void testGetDoctorByName() throws Exception {
        System.out.println("getDoctorByName");
        String nom = "";
        String prenom = "";
        DB_connector instance = null;
        Doctor expResult = null;
        Doctor result = instance.getDoctorByName(nom, prenom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctorById method, of class DB_connector.
     */
    //@Test
    public void testGetDoctorById() throws Exception {
        System.out.println("getDoctorById");
        String id = "";
        DB_connector instance = null;
        Doctor expResult = null;
        Doctor result = instance.getDoctorById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListDoctor method, of class DB_connector.
     */
    //@Test
    public void testGetListDoctor() throws Exception {
        System.out.println("getListDoctor");
        CRA cra = null;
        DB_connector instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getListDoctor(cra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnalysis method, of class DB_connector.
     */
    //@Test
    public void testGetAnalysis() throws Exception {
        System.out.println("getAnalysis");
        Patient pat = null;
        DB_connector instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getAnalysis(pat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDailyTest method, of class DB_connector.
     */
    //@Test
    public void testAddDailyTest() throws Exception {
        System.out.println("addDailyTest");
        DailyTest dt = null;
        Patient p = null;
        Doctor d = null;
        EEG eeg = null;
        BloodTest sang = null;
        EffortTest effort = null;
        DB_connector instance = null;
        instance.addDailyTest(dt, p, d, eeg, sang, effort);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStateDailyTest method, of class DB_connector.
     */
    //@Test
    public void testUpdateStateDailyTest() throws Exception {
        System.out.println("updateStateDailyTest");
        String d = null;
        String statut = "";
        DB_connector instance = null;
        instance.updateStateDailyTest(d, statut);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDailyTests method, of class DB_connector.
     */
    //@Test
    public void testGetDailyTests() throws Exception {
        System.out.println("getDailyTests");
        String idPatient = "";
        String day = "";
        DB_connector instance = null;
        DailyTest expResult = null;
        DailyTest result = instance.getDailyTests(idPatient, day);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyTest method, of class DB_connector.
     */
    //@Test
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
    //@Test
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
    //@Test
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
    //@Test
    public void testAddPatientToGroup() throws Exception {
        System.out.println("addPatientToGroup");
        Group g = null;
        DataManager dm = null;
        DB_connector instance = null;
        instance.addPatientToGroup(g, dm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupId method, of class DB_connector.
     */
    //@Test
    public void testGetGroupId() throws Exception {
        System.out.println("getGroupId");
        String g = "";
        DB_connector instance = null;
        int expResult = 0;
        int result = instance.getGroupId(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoSubGroup method, of class DB_connector.
     */
    //@Test
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

    /**
     * Test of getPatientsWithAnalysis method, of class DB_connector.
     */
    //@Test
    public void testGetPatientsWithAnalysis() throws Exception {
        System.out.println("getPatientsWithAnalysis");
        String idMedecin = "";
        DB_connector instance = null;
        LinkedHashMap expResult = null;
        LinkedHashMap result = instance.getPatientsWithAnalysis(idMedecin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
