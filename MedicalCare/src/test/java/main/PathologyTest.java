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
 * @author Vincent
 */
public class PathologyTest {
    
    public PathologyTest() {
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
     * Test of values method, of class Pathology.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Pathology[] expResult = null;
        Pathology[] result = Pathology.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Pathology.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Pathology expResult = null;
        Pathology result = Pathology.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of affichePatho method, of class Pathology.
     */
    @Test
    public void testAffichePatho() {
        System.out.println("affichePatho");
        Pathology.affichePatho();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
