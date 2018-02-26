package make.up.the.tool.wsensor;

import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Anatolii Nosenko
 * @version 26 February 2018
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({TestSensors.class})
public class AllTests {

    @Before
    public void setUp() throws Exception {
        Log.i(AllTests.class.getName(), "Tests has started... ");
    }

    @After
    public void tearDown() throws Exception {
        Log.i(AllTests.class.getName(), "Tests has finished... ");
    }
}
