/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
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
public class GroupTest {
    
    public GroupTest() {
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
     * Test of setGroupe method, of class Group.
     */
    @Test
    public void testSetGroupe() {
        System.out.println("setGroupe");
        String groupe = "";
        ArrayList nouveau = null;
        Group instance = new Group();
        instance.setGroupe(groupe, nouveau);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupe method, of class Group.
     */
    @Test
    public void testGetGroupe() {
        System.out.println("getGroupe");
        String groupe = "";
        Group instance = new Group();
        ArrayList expResult = null;
        ArrayList result = instance.getGroupe(groupe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
