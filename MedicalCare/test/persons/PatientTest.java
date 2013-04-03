/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

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
public class PatientTest {
    
    public PatientTest() {
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
     * Test of getSex method, of class Patient.
     */
    @Test
    public void testGetSex() {
        System.out.println("getSex");
        Patient instance = new Patient( );
        boolean expResult = false;
        boolean result = instance.getSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSex method, of class Patient.
     */
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        boolean sex = false;
        Patient instance = new Patient();
        instance.setSex(sex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthDate method, of class Patient.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Patient instance = new Patient();
        Date expResult = null;
        int result = instance.getBirthDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthDate method, of class Patient.
     */
    @Test
    public void testSetBirthDate() {
        System.out.println("setBirthDate");
        int birthDate = null;
        Patient instance = new Patient();
        instance.setBirthDate(birthDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomNumber method, of class Patient.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getRoomNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomNumber method, of class Patient.
     */
    @Test
    public void testSetRoomNumber() {
        System.out.println("setRoomNumber");
        String roomNumber = "";
        Patient instance = new Patient();
        instance.setRoomNumber(roomNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatientEligibility method, of class Patient.
     */
    @Test
    public void testGetPatientEligibility() {
        System.out.println("getPatientEligibility");
        Patient instance = new Patient();
        boolean expResult = false;
        boolean result = instance.getPatientEligibility();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Patient.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Patient.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        Patient instance = new Patient();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Patient.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Patient.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Patient instance = new Patient();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Patient.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Patient instance = new Patient();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Patient.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Patient instance = new Patient();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExclusion method, of class Patient.
     */
    @Test
    public void testSetExclusion() {
        System.out.println("setExclusion");
        boolean Exclusion = false;
        Patient instance = new Patient();
        instance.setExclusion(Exclusion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeletPatient method, of class Patient.
     */
    @Test
    public void testDeletPatient() {
        System.out.println("DeletPatient");
        String id = "";
        Patient instance = new Patient();
        instance.DeletPatient(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExclusion method, of class Patient.
     */
    @Test
    public void testGetExclusion() {
        System.out.println("getExclusion");
        Patient instance = new Patient();
        boolean expResult = false;
        boolean result = instance.getExclusion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
