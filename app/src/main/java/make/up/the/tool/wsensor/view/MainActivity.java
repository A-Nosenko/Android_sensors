package make.up.the.tool.wsensor.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import make.up.the.tool.wsensor.R;
import make.up.the.tool.wsensor.model.Sensors;
import make.up.the.tool.wsensor.view_model.SensorViewModel;

import static make.up.the.tool.wsensor.model.Constants.CREATE;
import static make.up.the.tool.wsensor.model.Constants.DESTROY;
import static make.up.the.tool.wsensor.model.Constants.LOG_MARKER;
import static make.up.the.tool.wsensor.model.Constants.PAUSE;
import static make.up.the.tool.wsensor.model.Constants.RESUME;
import static make.up.the.tool.wsensor.model.Constants.SAVE_STATE;
import static make.up.the.tool.wsensor.model.Constants.START;
import static make.up.the.tool.wsensor.model.Constants.STOP;

/**
 * Displays all sensors work on your Android.
 *
 * @author Anatolii Nosenko
 * @version 20 December 2017
 */

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private SensorManager sensorManager;
    private Sensors sensors;
    private List<SensorViewModel> viewModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.class.getName(), CREATE + LOG_MARKER);

        setContentView(R.layout.main_activity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = new Sensors(sensorManager);

        viewModelList = new ArrayList<>();
        for (Sensor sensor : sensors.getSensorsList()) {
            viewModelList.add(new SensorViewModel(sensor, sensorManager));
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SensorViewAdapter(viewModelList));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(MainActivity.class.getName(), SAVE_STATE + LOG_MARKER);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.class.getName(), START + LOG_MARKER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.class.getName(), RESUME + LOG_MARKER);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivity.class.getName(), PAUSE + LOG_MARKER);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.class.getName(), STOP + LOG_MARKER);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.class.getName(), DESTROY + LOG_MARKER);
    }
}
