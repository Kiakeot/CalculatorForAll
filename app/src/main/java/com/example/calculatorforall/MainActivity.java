package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
Switch switch_off;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switch_off = (Switch) findViewById(R.id.switch_off);
        ImageButton algebra = (ImageButton) findViewById(R.id.algebra);
        ImageButton geometry = (ImageButton) findViewById(R.id.geometry);
        ImageButton physik = (ImageButton) findViewById(R.id.physik);
        ImageButton life = (ImageButton) findViewById(R.id.life);
        ImageButton finance = (ImageButton) findViewById(R.id.finance);
        Button search = (Button) findViewById(R.id.search);
        switch_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = new Intent(MainActivity.this,switch_off.class);
                startActivity(intent);
            }
        });
        algebra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,algebra.class);
                startActivity(intent);
            }
        });
        geometry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,geometry.class);
                startActivity(intent);
            }
        });
        physik.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,physik.class);
                startActivity(intent);
            }
        });
        life.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,life.class);
                startActivity(intent);
            }
        });
        finance.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,finance.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,search.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        switch_off.setChecked(false);
    }
}