package make.up.the.tool.wsensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import make.up.the.tool.wsensor.model.Sensors;

/**
 * @author Anatolii Nosenko
 * @version 26 February 2018
 */

public class TestSensors extends AndroidTestCase{
    private SensorManager sensorManager;

    @Before
    public void setUp() throws Exception {
        Log.i(TestSensors.class.getName(), "TestSensors has started... ");
        sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
    }

    @Test
    public void testSensorsList() throws Exception {
        List<Sensor> list = new Sensors(sensorManager).getSensorsList();
        assertNotNull(list);
    }

    @After
    public void tearDown() throws Exception {
        Log.i(TestSensors.class.getName(), "TestSensors has finished... ");
    }
}
