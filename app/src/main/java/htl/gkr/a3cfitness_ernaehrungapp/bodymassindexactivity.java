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
        bmiberechnen =(Button) findViewById(R.id.buttonbmiberechnen);
        textviewergebnissbmi=(TextView) findViewById(R.id.textviewergebnissbmi);

        bmiberechnen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                gewicht = (EditText) findViewById(R.id.edittextgewichtbmi);
                groeße= (EditText) findViewById(R.id.edittextgroeßebmi);
                int gew = Integer.parseInt(gewicht.getText().toString());
                int groeß = Integer.parseInt(groeße.getText().toString());
                int bmiwert = gew / (groeß *  groeß);
                String erg = String.valueOf(bmiwert);
                textviewergebnissbmi.setText("BMI= "+erg);
            }
        });
    }
}
