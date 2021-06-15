package htl.gkr.a3cfitness_ernaehrungapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ernaehrungstippsactivity extends AppCompatActivity
{
    ListView listViewtipps;
    ArrayList<String> listtipps = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ernaehrungsipps);
        listViewtipps = findViewById(R.id.listviewtipps);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listtipps);
        listViewtipps.setAdapter(adapter);
        listtipps.add("*Ernährung ist wichtiger als Training");
        listtipps.add("*Achte auf eine ausgewogene Ernährung");
        listtipps.add("*Um Muskel aufzubauen, musst du im Kalorienüberschuss sein");
        listtipps.add("*Berechne deinen Tagesbedarf, um genau deinen Kalorienbedarf zu wissen");
        listtipps.add("*Ernähre dich abwechslungsreich");
        listtipps.add("*Übertreibe nicht das Konsum von Süssigkeiten und Fleisch");
    }
}
