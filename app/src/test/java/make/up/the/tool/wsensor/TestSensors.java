package make.up.the.tool.wsensor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import make.up.the.tool.wsensor.model.Sensors;

/**
 * @author Anatolii Nosenko
 * @version 26 February 2018
 */

public class TestSensors {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    SensorManager sensorManager;
    private Sensors sensors;

    @Before
    public void setUp() throws Exception {
        Log.i(TestSensors.class.getName(), "TestSensors has started... ");
        sensors = new Sensors(sensorManager);
    }

    @Test
    public void testSensorsList() throws Exception {
        List<Sensor> sensorList = sensors.getSensorsList();
        Assert.assertNotNull(sensorList);
        sensorList.forEach(sensor -> Log.i(TestSensors.class.getName(), sensor.getName()));
    }

    @After
    public void tearDown() throws Exception {
        Log.i(TestSensors.class.getName(), "TestSensors has finished... ");
    }
}
