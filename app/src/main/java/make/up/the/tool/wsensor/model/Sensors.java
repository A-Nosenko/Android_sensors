package make.up.the.tool.wsensor.model;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.List;

/**
 * @author Anatolii Nosenko
 * @version 25 February 2018
 */

public class Sensors {
    private final List<Sensor> sensorsList;

    public Sensors(SensorManager sensorManager) {
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);
    }

    public List<Sensor> getSensorsList() {
        return sensorsList;
    }
}
