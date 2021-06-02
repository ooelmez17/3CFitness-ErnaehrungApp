package htl.gkr.a3cfitness_ernaehrungapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bodymassindex;
    Button ernaehrungstipps;
    Button kalorienbedarf;
    Button traininhinzufuegen;
    Button ernaehrung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bodymassindex = findViewById(R.id.buttonbmi);
        ernaehrungstipps = findViewById(R.id.buttonernaehrungstipps);
        kalorienbedarf = findViewById(R.id.buttontagesbedarf);
        traininhinzufuegen = findViewById(R.id.buttontraininghinzufuegen);
        ernaehrung = findViewById(R.id.buttonernaehrung);
        //..





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
                Intent intent = new Intent(MainActivity.this, traininghinzufügenactivity.class);
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

    }
}