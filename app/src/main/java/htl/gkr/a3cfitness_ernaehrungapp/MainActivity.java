package htl.gkr.a3cfitness_ernaehrungapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bodymassindex;
    Button ernaehrungstipps;
    Button kalorienbedarf;
    Button traininhinzufuegen;
    Button ernaehrung;
    Button stepsreset;
    int test;


    TextView stepcounter;
    private double MagnitudePrevious = 0;
    private Integer stepCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bodymassindex = (Button) findViewById(R.id.buttonbmi);
        ernaehrungstipps = (Button) findViewById(R.id.buttonernaehrungstipps);
        kalorienbedarf =(Button) findViewById(R.id.buttontagesbedarf);
        traininhinzufuegen =(Button) findViewById(R.id.buttontraininghinzufuegen);
        ernaehrung =(Button) findViewById(R.id.buttonernaehrung);
        stepcounter = (TextView) findViewById(R.id.stepcounter);
        stepsreset = (Button) findViewById(R.id.buttonreset);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //..


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener stepDetector = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    float x_acceleration = sensorEvent.values[0];
                    float y_acceleration = sensorEvent.values[1];
                    float z_acceleration = sensorEvent.values[2];

                    double Magnitude = Math.sqrt(x_acceleration * x_acceleration + y_acceleration * y_acceleration + z_acceleration * z_acceleration);
                    double MagnitudeDelta = Magnitude - MagnitudePrevious;
                    MagnitudePrevious = Magnitude;

                    if (MagnitudeDelta > 1) {
                        stepCount++;
                        stepCount =0;
                        stepCount= stepCount+10000;
                    }

                    stepcounter.setText("Steps: "+stepCount.toString());

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensorManager.registerListener(stepDetector, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        stepsreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                stepCount = 0;
                editor.putInt("stepCount", stepCount);
                editor.apply();

            }
        });




        bodymassindex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bodymassindexactivity.class);
                startActivity(intent);


            }
        });

        ernaehrungstipps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ernaehrungstippsactivity.class);
                startActivity(intent);

            }
        });

        kalorienbedarf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, tagesbedarfberechnenactivity.class);
                startActivity(intent);
            }
        });

        traininhinzufuegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, traininghinzufuegenactivity.class);
                startActivity(intent);
            }
        });

        ernaehrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ernaehrungactivity.class);
                startActivity(intent);
            }
        });



        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("StepsNotification", "StepsNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        int steps = sharedPreferences.getInt("stepCount", 0);


       steps = 10000;


        if(steps>=10000)
        {
            NotificationCompat.Builder builder= new NotificationCompat.Builder(MainActivity.this,"StepsNotification");
            builder.setContentTitle("Congratulations");
            builder.setContentText("You have reached 10.000 Steps");
            builder.setSmallIcon(R.drawable.icongroesser);
            builder.setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
            managerCompat.notify(1,builder.build());
        }



    }
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();

        editor.putInt("stepCount", stepCount);
        editor.apply();
    }

    protected void onStop () {
        super.onStop();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();

        editor.putInt("stepCount", stepCount);
        editor.apply();
    }

    protected void onResume () {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        stepCount = sharedPreferences.getInt("stepCount", 0);
    }

}
