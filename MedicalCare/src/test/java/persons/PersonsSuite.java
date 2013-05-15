/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Vincent
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({persons.PatientTest.class, persons.DataManagerTest.class, persons.ActorTest.class, persons.CRATest.class, persons.DoctorTest.class})
public class PersonsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
