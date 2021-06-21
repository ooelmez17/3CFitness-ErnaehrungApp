package htl.gkr.a3cfitness_ernaehrungapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class ernaehrungactivity extends AppCompatActivity implements View.OnClickListener
{
    EditText edittextinfo;
    EditText txtDate2, txtTime2;
    private int jahr2, monat2, tag2, stunde2, minute2;
    private String timeFormat2;
    EditText edittextkalorien;
    Button buttonh;
    ListView listfuerern;
    TextView texviewkaloriengesamt;
    Button btnDatePicker2, btnTimePicker2;
    ArrayList<String> listernaehrung2 = new ArrayList<String>();
    ArrayAdapter<String> adapter2;
    Button alleeingabenlöschen;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ernaehrung);
        counter++;
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        edittextinfo = findViewById(R.id.edittexternäinfo);
        edittextkalorien = findViewById(R.id.edittextkalorien);
        buttonh = findViewById(R.id.buttonh);
        alleeingabenlöschen = findViewById(R.id.buttonalleeingabenlöschen);
        listfuerern = findViewById(R.id.listfuerern);
        texviewkaloriengesamt = findViewById(R.id.textviewergenis);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listernaehrung2);
        listfuerern.setAdapter(adapter2);
        btnDatePicker2=(Button)findViewById(R.id.btn_date2);
        btnTimePicker2=(Button)findViewById(R.id.btn_time2);
        txtDate2=(EditText)findViewById(R.id.in_date2);
        txtTime2=(EditText)findViewById(R.id.in_time2);
        ArrayList<Integer> li = new ArrayList<Integer>();


        btnDatePicker2.setOnClickListener(this);

        btnTimePicker2.setOnClickListener(this);
        if(counter>0)
        {
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            String a = sharedPreferences.getString("eingabe", "");
            listernaehrung2.add(a);



        }


        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edittextinfo.getText().toString().equals("") || edittextinfo.getText().toString() == null && tag2 == 0 || monat2 ==0|| jahr2 ==0|| stunde2 ==0|| minute2 ==0)
                {
                    Toast.makeText(ernaehrungactivity.this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    listernaehrung2.add(edittextinfo.getText().toString()+" "+tag2+"/"+monat2+"/"+jahr2+" "+stunde2+":"+minute2+"      Kalorien:"+edittextkalorien.getText().toString());
                    adapter2.notifyDataSetChanged();
                    String ein = edittextinfo.getText().toString()+" "+tag2+"/"+monat2+"/"+jahr2+" "+stunde2+":"+minute2+"      Kalorien:"+edittextkalorien.getText().toString();
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    for(int i =0;i<listernaehrung2.size();i++)
                    {
                        editor.putString("eingabe", listernaehrung2.get(i).toString());
                    }

                    editor.apply();
                }





                SharedPreferences sharedPreferences2 = getPreferences(MODE_PRIVATE);

              //  if(!sharedPreferences2.getString("eingabe","").equals(""))
              //  {
              //      SharedPreferences sharedP = getPreferences(MODE_PRIVATE);
              //      SharedPreferences.Editor edi = sharedPreferences.edit();
              //      editor.putString("eingabe2", ein);
               //     editor.apply();
              //  }

                li.add(Integer.parseInt(edittextkalorien.getText().toString()));



                int value =0;
                for(int val : li)
                {
                    value+=val;
                }



                if(value>0)
                {
                    texviewkaloriengesamt.setText("Gesamtkalorien: "+String.valueOf(value));
                }

            }
        });

alleeingabenlöschen.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

       listernaehrung2.clear();
       adapter2.notifyDataSetChanged();
    }
});
    }


    @Override
    public void onClick(View v) {
        if (v == btnDatePicker2) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            jahr2 = c.get(Calendar.YEAR);
            monat2 = c.get(Calendar.MONTH);
            tag2 = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate2.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                        }
                    }, jahr2, monat2, tag2);
            datePickerDialog.show();
        }
        if (v == btnTimePicker2) {


            final Calendar c = Calendar.getInstance();
            stunde2 = c.get(Calendar.HOUR_OF_DAY);
            minute2 = c.get(Calendar.MINUTE);



            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int selectedHour,
                                              int selectedMinute) {


                            String selectedTime = selectedHour + ":" + selectedMinute + " " + timeFormat2;

                            txtTime2.setText(selectedHour + ":" + selectedMinute);
                        }
                    }, stunde2, minute2, false);
            timePickerDialog.show();

        }
    }
    }

