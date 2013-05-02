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
 * @author Aurelie
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
     * Test of CheckPassword method, of class CRA.
     */
    @Test
    public void testCheckPassword() throws Exception {
        System.out.println("CheckPassword");
        String password = "Jaurelie";
        CRA instance = new CRA ("Joron", "Aurelie");
        boolean expResult = true;
        boolean result = instance.CheckPassword(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLogin method, of class CRA.
     */
    @Test
    public void testGetLogin() throws Exception {
        System.out.println("getLogin");
        CRA instance = new CRA ("Joron", "Aurelie");
        String expResult = "Jaurelie";
        String result = instance.getLogin();
        assertEquals(expResult, result);

    }

    /**
     * Test of setLogin method, of class CRA.
     */
    @Test
    public void testSetLogin() throws Exception {
        System.out.println("setLogin");
        CRA instance;
        instance = new CRA("Joron", "Aurelie");
        String expResult = "Jaurelie";
        instance.setLogin("Jaurelie");
        String result = instance.getLogin();
        assertEquals(expResult, result);
        instance.setLogin("Jaureo");
        result = instance.getLogin();
        expResult = "Jaureo";
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class CRA.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        CRA instance = new CRA ("Joron", "Aurelie");
        instance.setPassword("Jaurelie");
        String expResult = "Jaurelie";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class CRA.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        CRA instance = new CRA("Joron", "Aurelie");
        String expResult = "Jaurelie";
        System.out.println(instance.getPassword());
        instance.setPassword("Jaurelie");
        String result = instance.getPassword();
        assertEquals(expResult, result);
        instance.setPassword("Jaureo");
        result = instance.getPassword();
        expResult = "Jaureo";
        assertEquals(expResult, result);
    }
}
