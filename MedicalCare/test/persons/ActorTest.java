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
public class ActorTest {
    
    public ActorTest() {
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
     * Test of getId method, of class Actor.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        Actor instance = new ActorTest.ActorImpl("testName", "testLastName");
        String expResult = null;
        String result = instance.getId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setId method, of class Actor.
     */
    @Test
    public void testSetId() throws Exception {
        System.out.println("setId");
        String idTest = "test";
        Actor instance = new ActorTest.ActorImpl("testfirst", idTest);
        instance.setId(idTest);
        String expResult = idTest;
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Actor.
     */
    @Test
    public void testGetFirstName() throws Exception {
        System.out.println("getName");
        Actor instance = new ActorTest.ActorImpl("test", "testlast");
        String expResult = "test";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Actor.
     */
    @Test
    public void testSetFirstName() throws Exception {
        System.out.println("setName");
        String name = "test";
        Actor instance = new ActorTest.ActorImpl("testfirst", "testlast");
        instance.setFirstName(name);
        String expResult = name;
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        try 
        {
            instance.setFirstName("i");
        }
        catch (Exception e) {}
        result = instance.getFirstName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getLastName method, of class Actor.
     */
    @Test
    public void testGetLastName() throws Exception {
        System.out.println("getLastName");
        Actor instance = new ActorTest.ActorImpl("testfirst", "test");
        String expResult = "test";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Actor.
     */
    @Test
    public void testSetLastName() throws Exception {
        System.out.println("setLastName");
        String lastName = "test";
        Actor instance = new ActorTest.ActorImpl("testfirst", lastName);
        instance.setLastName(lastName);
        String expResult = lastName;
        String result = instance.getLastName();
        assertEquals(expResult, result);
        try 
        {
            instance.setLastName("tre2");
        }
        catch (Exception e) {}
        
        result = instance.getLastName();
        assertEquals(expResult, result);
    }

    public class ActorImpl extends Actor {
        
        public ActorImpl(String firstName, String lastName) throws Exception {
            super(firstName, lastName);
        }
    }
}
