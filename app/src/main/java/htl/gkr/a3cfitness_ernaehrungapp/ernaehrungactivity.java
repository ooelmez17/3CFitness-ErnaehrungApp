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
import android.widget.TextView;
import android.widget.TimePicker;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ernaehrung);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        edittextinfo = findViewById(R.id.edittexternäinfo);
        edittextkalorien = findViewById(R.id.edittextkalorien);
        buttonh = findViewById(R.id.buttonh);
        listfuerern = findViewById(R.id.listfuerern);
        texviewkaloriengesamt = findViewById(R.id.textviewergenis);
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listernaehrung2);
        listfuerern.setAdapter(adapter2);
        btnDatePicker2=(Button)findViewById(R.id.btn_date2);
        btnTimePicker2=(Button)findViewById(R.id.btn_time2);
        txtDate2=(EditText)findViewById(R.id.in_date2);
        txtTime2=(EditText)findViewById(R.id.in_time2);



        btnDatePicker2.setOnClickListener(this);

        btnTimePicker2.setOnClickListener(this);

        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listernaehrung2.add(edittextinfo.getText().toString()+" "+tag2+"/"+monat2+"/"+jahr2+" "+stunde2+":"+minute2+edittextkalorien.getText().toString());
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

