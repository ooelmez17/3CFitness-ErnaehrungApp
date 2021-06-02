package htl.gkr.a3cfitness_ernaehrungapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bodymassindexactivity extends AppCompatActivity
{

    EditText gewicht;
    EditText groeße;
    Button bmiberechnen;
    TextView textviewergebnissbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bodymassindex);

        gewicht = findViewById(R.id.edittextgewicht);
        groeße= findViewById(R.id.edittextgroeße);
        bmiberechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textviewergebnissbmi.setText("...");
            }
        });
    }
}
