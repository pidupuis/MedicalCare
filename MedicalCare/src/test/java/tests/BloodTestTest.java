/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import persons.Patient;

/**
 *
 * @author Katia
 */
public class BloodTestTest {
    
    public BloodTestTest() {
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
     * Test of checkResult method, of class BloodTest.
     */
    @Test
    public void testCheckResult() throws Exception {
        System.out.println("checkResult");
        BloodTest instance = new BloodTest();
        instance.checkResult();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkP method, of class BloodTest.
     */
    @Test
    public void testCheckP() {
        System.out.println("checkP");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGB method, of class BloodTest.
     */
    @Test
    public void testCheckGB() {
        System.out.println("checkGB");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkGB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkHb method, of class BloodTest.
     */
    @Test
    public void testCheckHb() {
        System.out.println("checkHb");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkHb();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGR method, of class BloodTest.
     */
    @Test
    public void testCheckGR() {
        System.out.println("checkGR");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkGR();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkHemato method, of class BloodTest.
     */
    @Test
    public void testCheckHemato() {
        System.out.println("checkHemato");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkHemato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAllResults method, of class BloodTest.
     */
    @Test
    public void testCheckAllResults() throws Exception {
        System.out.println("checkAllResults");
        BloodTest instance = new BloodTest();
        boolean expResult = false;
        boolean result = instance.checkAllResults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHb method, of class BloodTest.
     */
    @Test
    public void testGetHb() {
        System.out.println("getHb");
        BloodTest instance = new BloodTest();
        float expResult = 0.0F;
        float result = instance.getHb();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHb method, of class BloodTest.
     */
    @Test
    public void testSetHb() throws Exception {
        System.out.println("setHb");
        float Hb = 0.0F;
        BloodTest instance = new BloodTest();
        instance.setHb(Hb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGR method, of class BloodTest.
     */
    @Test
    public void testGetGR() {
        System.out.println("getGR");
        BloodTest instance = new BloodTest();
        float expResult = 0.0F;
        float result = instance.getGR();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGR method, of class BloodTest.
     */
    @Test
    public void testSetGR() throws Exception {
        System.out.println("setGR");
        float GR = 0.0F;
        BloodTest instance = new BloodTest();
        instance.setGR(GR);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGB method, of class BloodTest.
     */
    @Test
    public void testGetGB() {
        System.out.println("getGB");
        BloodTest instance = new BloodTest();
        float expResult = 0.0F;
        float result = instance.getGB();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGB method, of class BloodTest.
     */
    @Test
    public void testSetGB() throws Exception {
        System.out.println("setGB");
        float GB = 0.0F;
        BloodTest instance = new BloodTest();
        instance.setGB(GB);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHemato method, of class BloodTest.
     */
    @Test
    public void testGetHemato() {
        System.out.println("getHemato");
        BloodTest instance = new BloodTest();
        float expResult = 0.0F;
        float result = instance.getHemato();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHemato method, of class BloodTest.
     */
    @Test
    public void testSetHemato() throws Exception {
        System.out.println("setHemato");
        float hemato = 0.0F;
        BloodTest instance = new BloodTest();
        instance.setHemato(hemato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getP method, of class BloodTest.
     */
    @Test
    public void testGetP() {
        System.out.println("getP");
        BloodTest instance = new BloodTest();
        float expResult = 0.0F;
        float result = instance.getP();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setP method, of class BloodTest.
     */
    @Test
    public void testSetP() throws Exception {
        System.out.println("setP");
        float P = 0.0F;
        BloodTest instance = new BloodTest();
        instance.setP(P);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPat method, of class BloodTest.
     */
    @Test
    public void testGetPat() {
        System.out.println("getPat");
        BloodTest instance = new BloodTest();
        Patient expResult = null;
        Patient result = instance.getPat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPat method, of class BloodTest.
     */
    @Test
    public void testSetPat() {
        System.out.println("setPat");
        Patient pat = null;
        BloodTest instance = new BloodTest();
        instance.setPat(pat);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BloodTest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        BloodTest instance = new BloodTest();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
