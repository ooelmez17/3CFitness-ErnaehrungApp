package htl.gkr.a3cfitness_ernaehrungapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class allleingabenanzeigeacitivty extends AppCompatActivity
{
    TextView listviewalleeingaben;
    ArrayAdapter<String> adapter2;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alleingaben);
        listviewalleeingaben = findViewById(R.id.listviewalleeingaben);
      //  listviewalleeingaben = findViewById(R.id.listviewalleeingaben);
       // adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
       // listviewalleeingaben.setAdapter(adapter2);
       // list.add("sdfsd");
      //  list.add("sfd");
       // adapter2.notifyDataSetChanged();
        Intent intent = getIntent();
     String daten = intent.getStringExtra("daten");
        listviewalleeingaben.setText(daten);
    }
}
