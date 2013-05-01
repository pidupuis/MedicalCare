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
public class CRATest {
    
    public CRATest() {
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
     * Test of CreateLogin method, of class CRA.
     */
    @Test
    public void testCreateLogin() {
        System.out.println("CreateLogin");
        String login = "";
        CRA instance = null;
        boolean expResult = false;
        boolean result = instance.CreateLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreatePassword method, of class CRA.
     */
    @Test
    public void testCreatePassword() {
        System.out.println("CreatePassword");
        String password = "";
        CRA instance = null;
        boolean expResult = false;
        boolean result = instance.CreatePassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckLogin method, of class CRA.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("CheckLogin");
        String login = "";
        String password = "";
        CRA instance = null;
        boolean expResult = false;
        boolean result = instance.CheckLogin(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class CRA.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        CRA instance = null;
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLogin method, of class CRA.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        CRA instance = null;
        instance.setLogin(login);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class CRA.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        CRA instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class CRA.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        CRA instance = null;
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
