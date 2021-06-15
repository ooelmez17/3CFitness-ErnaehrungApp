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
    Button tagesbedarfberechnenbutton;
    TextView textviewergebnissbmi;
   String alterzahl;
    int gewichtzahl;
    int groeßezahl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tagesbedarfberechnen);

    //  String  alterzahl = alter.getText().toString();
       tagesbedarfberechnenbutton =(Button) findViewById(R.id.buttontagesbedarfberechnen);

       textviewergebnissbmi = (TextView) findViewById(R.id.textviewergebnisskalorienbedarf);





       //  gewichtzahl = Integer.parseInt(gewicht.getText().toString());
        // groeßezahl = Integer.parseInt(groeße.getText().toString());



        tagesbedarfberechnenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alter =  (EditText) findViewById(R.id.edittextgewicht);
                 gewicht = (EditText) findViewById(R.id.edittextgewicht);
                 groeße = (EditText)findViewById(R.id.edittextgroeße2);
                 int alterzahl= Integer.parseInt(alter.getText().toString());
                 int gew = Integer.parseInt(gewicht.getText().toString());
                 int groeß = Integer.parseInt(groeße.getText().toString());
            }
        });
    }
}
