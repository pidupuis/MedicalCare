/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vincent
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
     * Test of getGender method, of class Patient.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Patient instance = null;
        boolean expResult = false;
        boolean result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthDate method, of class Patient.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Patient instance = null;
        Calendar expResult = null;
        Calendar result = instance.getBirthDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAge method, of class Patient.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        Patient instance = null;
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomNumber method, of class Patient.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        Patient instance = null;
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
    public void testSetRoomNumber() throws Exception {
        System.out.println("setRoomNumber");
        String roomNumber = "";
        Patient instance = null;
        instance.setRoomNumber(roomNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Patient.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Patient instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Patient.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Patient instance = null;
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Patient.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Patient instance = null;
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInclusion method, of class Patient.
     */
    @Test
    public void testSetInclusion() {
        System.out.println("setInclusion");
        boolean Exclusion = false;
        Patient instance = null;
        instance.setInclusion(Exclusion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInclusion method, of class Patient.
     */
    @Test
    public void testGetInclusion() {
        System.out.println("getInclusion");
        Patient instance = null;
        boolean expResult = false;
        boolean result = instance.getInclusion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
