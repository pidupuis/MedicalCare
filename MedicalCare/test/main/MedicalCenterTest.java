package main;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vincent Emonet
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
        MedicalCenter instance = new MedicalCenter("test name", "test");
        String expResult = "test name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class MedicalCenter.
     */
    @Test
    public void testSetName() throws Exception {
        System.out.println("setName");
        MedicalCenter instance = new MedicalCenter("testname", "test");
        try {
            instance.setName("reset");
        }
        catch (Exception e) {}
        String expResult = "reset";
        String result = instance.getName();
        assertEquals(expResult, result);
        try {
            instance.setName("r");
            
        }
        catch (Exception e) {}
        expResult = "reset";
        result = instance.getName();
        assertEquals(expResult, result);
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
    }

    /**
     * Test of setAddress method, of class MedicalCenter.
     */
    @Test
    public void testSetAddress() throws Exception {
        System.out.println("setAddress");
        MedicalCenter instance = new MedicalCenter("test name", "test");
        try {
            instance.setName("r");
        }
        catch (Exception e) {
            
        }
        String expResult = "test name";
        String result = instance.getName();
        assertEquals(expResult, result);
        try {
            instance.setName("40 avenue des Champignons");
        }
        catch (Exception e) {
            
        }
        expResult = "40 avenue des Champignons";
        result = instance.getName();
        assertEquals(expResult, result);
    }
}
