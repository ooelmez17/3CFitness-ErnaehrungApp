package htl.gkr.a3cfitness_ernaehrungapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tagesbedarfberechnenactivity extends AppCompatActivity
{
    EditText alter;
    EditText gewicht;
    EditText groeße;
    Button tagesbedarfberechnen;
    TextView textviewergebnissbmi;
   String alterzahl;
    int gewichtzahl;
    int groeßezahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tagesbedarfberechnen);
       EditText alter =  (EditText) findViewById(R.id.edittextgewicht);
       EditText gewicht = (EditText) findViewById(R.id.edittextgewicht);
       EditText groeße = (EditText)findViewById(R.id.edittextgroeße2);
    //  String  alterzahl = alter.getText().toString();
       tagesbedarfberechnen = findViewById(R.id.buttontagesbedarfberechnen);
       textviewergebnissbmi = (TextView) findViewById(R.id.textviewergebnisskalorienbedarf);

        alterzahl = alter.getText().toString();



       //  gewichtzahl = Integer.parseInt(gewicht.getText().toString());
        // groeßezahl = Integer.parseInt(groeße.getText().toString());



        tagesbedarfberechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textviewergebnissbmi.setText(Integer.parseInt(alterzahl));
            }
        });
    }
}
