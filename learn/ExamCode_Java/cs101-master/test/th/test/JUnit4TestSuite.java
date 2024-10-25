package th.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({th.test.UtilsJUnit4Test.class, th.test.VectorsJUnit4Test.class})
public class JUnit4TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* JUnit4TestSuite: @BeforeClass method");        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* JUnit4TestSuite: @AfterClass method");                
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("* JUnit4TestSuite: @Before method");        
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("* JUnit4TestSuite: @After method");                
    }    
}
