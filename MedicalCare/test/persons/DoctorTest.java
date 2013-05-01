package persons;

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
public class DoctorTest {
    
    public DoctorTest() {
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
     * Test of getName method, of class Actor.
     */
    @Test
    public void testGetLogin() throws Exception {
        System.out.println("getLogin");
        Doctor instance = new Doctor("Vincent", "Emonet");
        String expResult = "vemonet";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Actor.
     */
    @Test
    public void testGetPassword() throws Exception {
        System.out.println("getPassword");
        Doctor instance = new Doctor("test", "test");
        instance.setPassword("testpw");
        String expResult = "testpw";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Actor.
     */
    @Test
    public void testSetPassword() throws Exception {
        System.out.println("setPassword");
        Doctor instance = new Doctor("test", "test");
        String expResult = "testpw";
        instance.setPassword("testpw");
        String result = instance.getPassword();
        assertEquals(expResult, result);
        instance.setPassword("test2");
        result = instance.getPassword();
        expResult = "test2";
        assertEquals(expResult, result);
        try {
            instance.setPassword("tes");
        }
        catch (Exception e) {
            
        }
        result = instance.getPassword();
        assertEquals(expResult, result);
    }
}
