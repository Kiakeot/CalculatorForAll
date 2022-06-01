package com.example.calculatorforall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
@SuppressLint("UseSwitchCompatOrMaterialCode")

Switch switch_off;
boolean firstStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_CalculatorForAll);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences settings = getSharedPreferences("PREFS",0);
        firstStart = settings.getBoolean("first_time_start",false);


        if(firstStart){
            @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("first_time_start",true);
            Intent intent = new Intent(getApplicationContext(),AppIntro.class);
            startActivity(intent);
        }

        switch_off = findViewById(R.id.switch_off);
        ImageButton algebra = findViewById(R.id.algebra);
        ImageButton geometry = findViewById(R.id.geometry);
        ImageButton physik = findViewById(R.id.physik);
        ImageButton life = findViewById(R.id.life);
        ImageButton finance = findViewById(R.id.finance);
        Button search = findViewById(R.id.search);


        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                    finance.setImageResource(R.drawable.ic_finance_icon_test);
                    life.setImageResource(R.drawable.ic_life_icon_test);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                    finance.setImageResource(R.drawable.temp);
                    life.setImageResource(R.drawable.secondtemp);
                break;
        }


        switch_off.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Intent intent1 = new Intent(MainActivity.this,switch_off.class);
            startActivity(intent1);
        });
        algebra.setOnClickListener(v -> {
            Intent intent12 = new Intent(MainActivity.this,algebra.class);
            startActivity(intent12);
        });
        geometry.setOnClickListener(v -> {
            Intent intent13 = new Intent(MainActivity.this,geometry.class);
            startActivity(intent13);
        });
        physik.setOnClickListener(v -> {
            Intent intent14 = new Intent(MainActivity.this,physik.class);
            startActivity(intent14);
        });
        life.setOnClickListener(v -> {
            Intent intent15 = new Intent(MainActivity.this,life.class);
            startActivity(intent15);
        });
        finance.setOnClickListener(v -> {
            Intent intent16 = new Intent(MainActivity.this,finance.class);
            startActivity(intent16);
        });
        search.setOnClickListener(v -> {
            Intent intent17 = new Intent(MainActivity.this,search.class);
            startActivity(intent17);
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        switch_off.setChecked(false);
    }
}