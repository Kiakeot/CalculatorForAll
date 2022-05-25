package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class random extends AppCompatActivity {
    private EditText editFirstBarrier;
    private EditText editSecondBarrier;
    private TextView textfinish;
    public int result;
    private int min;
    private int max;
    private String strResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number_generator);
        Button calculate = findViewById(R.id.calculate);
        ImageButton switch_off = findViewById(R.id.switch_off);
        editFirstBarrier = findViewById(R.id.first_number);
        editSecondBarrier = findViewById(R.id.second_number);
        textfinish = findViewById(R.id.text_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(random.this,switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            try {
                min = Integer.parseInt(editFirstBarrier.getText().toString().trim());
                max = Integer.parseInt(editSecondBarrier.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editSecondBarrier.setText(null);
                editFirstBarrier.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            textfinish.setText(strResult);
        });
    }

    private void getAnswer() {
        result = new Random().nextInt((max - min) + 1) + min;
    }
}