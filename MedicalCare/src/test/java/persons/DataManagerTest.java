/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

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
public class DataManagerTest {
    
    public DataManagerTest() {
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
     * Test of getLogin method, of class DataManager.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        DataManager instance = null;
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class DataManager.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        DataManager instance = null;
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class DataManager.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        DataManager instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class DataManager.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        DataManager instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssignment method, of class DataManager.
     */
    @Test
    public void testSetAssignment() {
        System.out.println("setAssignment");
        boolean b = false;
        DataManager instance = null;
        instance.setAssignment(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssignment method, of class DataManager.
     */
    @Test
    public void testGetAssignment() {
        System.out.println("getAssignment");
        DataManager instance = null;
        boolean expResult = false;
        boolean result = instance.getAssignment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of assignment method, of class DataManager.
     */
    @Test
    public void testAssignment() throws Exception {
        System.out.println("assignment");
        DataManager instance = null;
        instance.assignment();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
