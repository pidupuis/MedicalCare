/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Cogotch
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({main.MainLiliTest.class, main.MedicalCenterTest.class, main.DB_connectorTest.class, main.PathologyTest.class, main.MainLoloTest.class, main.MainKatTest.class, main.GroupTest.class})
public class MainSuite {

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
