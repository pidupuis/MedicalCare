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
     * Test of values method, of class Group.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Group[] expResult = null;
        Group[] result = Group.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Group.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Group expResult = null;
        Group result = Group.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addGroup method, of class Group.
     */
    @Test
    public void testAddGroup() {
        System.out.println("addGroup");
        String grp = "";
        Group instance = null;
        instance.addGroup(grp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGroup method, of class Group.
     */
    @Test
    public void testDeleteGroup() {
        System.out.println("deleteGroup");
        Group grp = null;
        Group instance = null;
        instance.deleteGroup(grp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
