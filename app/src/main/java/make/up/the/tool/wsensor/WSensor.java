package make.up.the.tool.wsensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Displays all sensors work on your Android.
 *
 * @author Anatolii Nosenko
 * @version 20 December 2017
 */

public class WSensor extends Activity {

    private SensorManager sensorManager;
    private SensorEventListener listener;
    private LinearLayout.LayoutParams params;
    private int backgroundColor;
    private int textColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wsensor);

        final LinearLayout layout = findViewById(R.id.layout);
        backgroundColor = getResources().getColor(R.color.colorPrimaryDark);
        textColor = getResources().getColor(R.color.white);
        layout.setBackgroundColor(backgroundColor);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        for (Sensor sensor : sensorManager.getSensorList(Sensor.TYPE_ALL)) {

            if (sensor == null) {
                continue;
            }

            final TextView marker = new TextView(WSensor.this);
            marker.setBackgroundColor(backgroundColor);
            marker.setTextColor(textColor);
            marker.setText(sensor.getName());

            final TextView out = new TextView(WSensor.this);
            out.setBackgroundColor(backgroundColor);
            out.setTextColor(getResources().getColor(R.color.white));

            final StringBuilder stringBuilder = new StringBuilder();

            listener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent sensorEvent) {
                    stringBuilder.setLength(0);
                    stringBuilder.append("===============\t");
                    for (float f : sensorEvent.values) {
                        String result = String.format("%12s ", "" + f);
                        stringBuilder.append(result);
                    }

                    out.setText(stringBuilder.toString());

                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int i) {

                }
            };

            sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI);
            layout.addView(marker, params);
            layout.addView(out, params);
        }
    }
}
