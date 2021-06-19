package htl.gkr.a3cfitness_ernaehrungapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Menue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ladebildschirm);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        final int LOAD_TIME = 4000;
        {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Menue.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, LOAD_TIME);

        }
    }
}