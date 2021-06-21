package htl.gkr.a3cfitness_ernaehrungapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class tagesbedarfberechnenactivity extends AppCompatActivity
{
    EditText alter;
    EditText gewicht;
    EditText groeße;
    Button tagesbedarfberechnenbutton;
    TextView textviewergebniskalorien;
    CheckBox checkboxmaennlich;
    CheckBox checkBoxweiblich;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tagesbedarfberechnen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    //  String  alterzahl = alter.getText().toString();
       tagesbedarfberechnenbutton =(Button) findViewById(R.id.buttontagesbedarfberechnen);

       textviewergebniskalorien = (TextView) findViewById(R.id.textviewergebnisskalorienbedarf);





       //  gewichtzahl = Integer.parseInt(gewicht.getText().toString());
        // groeßezahl = Integer.parseInt(groeße.getText().toString());



        tagesbedarfberechnenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            checkboxmaennlich = (CheckBox) findViewById(R.id.checkBoxMaennlich);
            checkBoxweiblich =(CheckBox) findViewById(R.id.checkBoxWeiblich);

                alter =  (EditText) findViewById(R.id.edittextaltertagesbedarf);
                 gewicht = (EditText) findViewById(R.id.edittextgewichttagesbedarf);
                 groeße = (EditText) findViewById(R.id.edittextgroeßetagesbedarf);
                if(alter.getText().toString().equals("") || alter.getText().toString() == null && gewicht.getText().toString().equals("") || gewicht.getText().toString()==null && groeße.getText().toString().equals("") || groeße.getText().toString() == null&& !checkBoxweiblich.isChecked() || !checkboxmaennlich.isChecked())
                {
                    Toast.makeText(tagesbedarfberechnenactivity.this,"Bitte alle Daten eingeen",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(checkboxmaennlich.isChecked())
                    {
                        String a = alter.getText().toString();
                        int age =0;
                        age = age+ Integer.parseInt(a);
                        String b = gewicht.getText().toString();
                        int weight =0;
                        weight = weight+ Integer.parseInt(b);
                        String c = groeße.getText().toString();
                        int tall =0;
                        tall = tall+ Integer.parseInt(c);
                        double erg = 66.5+(13.75*weight)+(5.0*tall)-(6.76*age);
                        double leistunsumsatz = erg *0.45;
                        double fullerg = erg+leistunsumsatz;
                        textviewergebniskalorien.setText("Ihr Tagesbedarf beträgt "+String.valueOf(fullerg)+" Kalorien");
                    }
                    if(checkBoxweiblich.isChecked())
                    {
                        String a = alter.getText().toString();
                        int age =0;
                        age = age+ Integer.parseInt(a);
                        String b = gewicht.getText().toString();
                        int weight =0;
                        weight = weight+ Integer.parseInt(b);
                        String c = groeße.getText().toString();
                        int tall =0;
                        tall = tall+ Integer.parseInt(c);
                        double erg = 655.1+(9.56*weight)+(1.85*tall)-(4.7*age);
                        double leistunsumsatz = erg *0.45;
                        double fullerg = erg+leistunsumsatz;
                        textviewergebniskalorien.setText("Ihr Tagesbedarf beträgt "+String.valueOf(fullerg)+" Kalorien");
                    }

                }



             //    int alterzahl= Integer.parseInt(alter.getText().toString());
              //  int  gewichtzahl = Integer.parseInt(gewicht.getText().toString());
              //  int groeßezahl = Integer.parseInt(groeße.getText().toString());
               //  textviewergebniskalorien.setText("Dein Tagesbedarf ist "+String.valueOf(erg));
            }
        });
    }
}
