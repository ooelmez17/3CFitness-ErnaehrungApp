package htl.gkr.a3cfitness_ernaehrungapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        bmiberechnen =(Button) findViewById(R.id.buttonbmiberechnen);
        textviewergebnissbmi=(TextView) findViewById(R.id.textviewergebnissbmi);

        bmiberechnen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                gewicht = (EditText) findViewById(R.id.edittextgewichtbmi);
                groeße= (EditText) findViewById(R.id.edittextgroeßebmi);

                if(gewicht.getText().toString().equals("") || gewicht.getText().toString() == null && groeße.getText().toString().equals("") || groeße.getText().toString()==null)
                {
                    Toast.makeText(bodymassindexactivity.this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    int gew = Integer.parseInt(gewicht.getText().toString());
                    double groeß = Double.parseDouble(groeße.getText().toString());
                    double bmiwert = gew / (groeß *  groeß);
                    double gerundet = Math.round(bmiwert*100)/100;

                    String erg = String.valueOf(gerundet);
                    textviewergebnissbmi.setText("Ihr BMI beträgt: "+erg);
                }


            }
        });
    }
}
