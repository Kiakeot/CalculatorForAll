package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class deposit extends AppCompatActivity {
    private TextView textFinish;
    private EditText edit_data;
    private EditText edit_suma;
    private EditText edit_percent;
    public double result;
    public String strResult;
    private int data;
    private int suma;
    private double percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        textFinish = findViewById(R.id.text_finish);
        edit_data = findViewById(R.id.edit_data);
        edit_percent = findViewById(R.id.edit_percent);
        edit_suma = findViewById(R.id.edit_suma);

        calculate.setOnClickListener(view -> {
            data = Integer.parseInt(edit_data.getText().toString().trim());
            suma = Integer.parseInt(edit_suma.getText().toString().trim());
            percent = Integer.parseInt(edit_percent.getText().toString().trim());
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });


        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(deposit.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void getAnswer(){
        result = suma * (percent/100) * data;
    }
}
