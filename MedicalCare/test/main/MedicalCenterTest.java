/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void testGetName() throws Exception {
        System.out.println("getName");
        MedicalCenter instance = new MedicalCenter("test", "test");
        String expResult = "test";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class MedicalCenter.
     */
    @Test
    public void testSetName() throws Exception {
        System.out.println("setName");
        MedicalCenter instance = new MedicalCenter("test", "test");
        instance.setName("reset");
        String expResult = "reset";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class MedicalCenter.
     */
    @Test
    public void testGetAddress() throws Exception {
        System.out.println("getAddress");
        MedicalCenter instance = new MedicalCenter("test", "17 rue Montaigne");
        String expResult = "17 rue Montaigne";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class MedicalCenter.
     */
    @Test
    public void testSetAddress() throws Exception {
        System.out.println("setAddress");
        String address = "30 route du val de Gorbio";
        MedicalCenter instance = new MedicalCenter("test", "17 rue Montaigne");
        instance.setAddress(address);
        String expResult = address;
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
