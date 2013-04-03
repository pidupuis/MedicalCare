/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
public class MedicalCenterTest {
    
    public MedicalCenterTest() {
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
     * Test of getName method, of class MedicalCenter.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        MedicalCenter instance = new MedicalCenter();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class MedicalCenter.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        MedicalCenter instance = new MedicalCenter();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class MedicalCenter.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        MedicalCenter instance = new MedicalCenter();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class MedicalCenter.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        MedicalCenter instance = new MedicalCenter();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
