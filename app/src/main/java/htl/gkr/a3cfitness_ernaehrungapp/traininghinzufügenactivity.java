package htl.gkr.a3cfitness_ernaehrungapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class traininghinzufügenactivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    private int jahr, monat, tag, stunde, minute;
    private String timeFormat;
    ListView listViewtraining;
    ArrayList<String> listtraining = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    EditText trainingeingabe;
    Button traininghi;
    String ozan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traininghinzufuegen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        trainingeingabe = (EditText) findViewById(R.id.edittexteingabetraining);
        traininghi = (Button) findViewById(R.id.buttontraininghinzufu);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listtraining);
        listViewtraining =(ListView) findViewById(R.id.listviewfürtraining);
        listViewtraining.setAdapter(adapter);
      //  listViewtraining = (ListView) findViewById(R.id.listviewfürtraining);
     //   listViewtraining.setAdapter(adapter);
        btnDatePicker=(Button)findViewById(R.id.btn_date);
        btnTimePicker=(Button)findViewById(R.id.btn_time);
        txtDate=(EditText)findViewById(R.id.in_date);
        txtTime=(EditText)findViewById(R.id.in_time);





        btnDatePicker.setOnClickListener(this);

        btnTimePicker.setOnClickListener(this);

        traininghi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(trainingeingabe.getText().toString().equals("") || trainingeingabe.getText().toString() == null &&  tag == 0 || monat ==0|| jahr ==0|| stunde ==0|| minute ==0)
                {
                    Toast.makeText(traininghinzufügenactivity.this, "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    traininghi = (Button) findViewById(R.id.buttontraininghinzufu);
                    listtraining.add(trainingeingabe.getText().toString()+" "+tag+"/"+monat+"/"+jahr+" "+stunde+":"+minute);
                    adapter.notifyDataSetChanged();
                }




            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            jahr = c.get(Calendar.YEAR);
            monat = c.get(Calendar.MONTH);
            tag = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);

                        }
                    }, jahr, monat, tag);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {


            final Calendar c = Calendar.getInstance();
            stunde = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);



            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int selectedHour,
                                              int selectedMinute) {


                            String selectedTime = selectedHour + ":" + selectedMinute + " " + timeFormat;

                            txtTime.setText(selectedHour + ":" + selectedMinute);
                        }
                    }, stunde, minute, false);
            timePickerDialog.show();

        }
    }


}
