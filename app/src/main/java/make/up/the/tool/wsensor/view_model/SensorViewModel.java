package make.up.the.tool.wsensor.view_model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import make.up.the.tool.wsensor.BR;
import make.up.the.tool.wsensor.model.Constants;

import static make.up.the.tool.wsensor.model.Constants.PATTERN_SENSOR_VALUES;

/**
 * @author Anatolii Nosenko
 * @version 25 February 2018
 */

public class SensorViewModel extends BaseObservable {
    private final String sensorName;
    private final SensorEventListener listener;

    private String sensorValues;

    public SensorViewModel(Sensor sensor, SensorManager sensorManager) {
        this.sensorName = sensor.getName();

        listener = new SensorEventListener() {
            private final StringBuilder stringBuilder = new StringBuilder();

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                stringBuilder.setLength(0);
                for (float f : sensorEvent.values) {
                    String result = String.format(PATTERN_SENSOR_VALUES, "" + f);
                    stringBuilder.append(result);
                }
                setSensorValues(stringBuilder.toString());
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
    }

    public String getSensorName() {
        return sensorName;
    }

    @Bindable
    public String getSensorValues() {
        return sensorValues;
    }

    private void setSensorValues(String sensorValues) {
        this.sensorValues = sensorValues;
        notifyPropertyChanged(BR.sensorValues);
    }
}
