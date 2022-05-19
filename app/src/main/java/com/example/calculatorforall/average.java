package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;

public class average extends AppCompatActivity {
    private EditText editFirstNumber;
    private EditText editSecondNumber;
    private TextView textFinish;
    private int spinner_pos;
    private String finishSystem;
    public double result;
    private String strResult;
    public double firstNumber;
    public double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average);
        editFirstNumber = findViewById(R.id.first_number);
        editSecondNumber = findViewById(R.id.second_number);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        textFinish = findViewById(R.id.text_finish);


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.average)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_start);
        spinner_finish.getSelectedItemId();

        calculate.setOnClickListener(view -> {
            spinner_pos = spinner_finish.getSelectedItemPosition();
            firstNumber = Integer.parseInt(editFirstNumber.getText().toString().trim());
            secondNumber = Integer.parseInt(editSecondNumber.getText().toString().trim());
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });


        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(average.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void chooseFinishValue() {
        switch (spinner_pos) {
            case 0: {
                finishSystem = "Arithmetic";
                break;
            }
            case 1: {
                finishSystem = "Geometric";
                break;
            }
            case 2: {
                finishSystem = "Square";
                break;
            }
            case 3: {
                finishSystem = "Harmonious";
                break;
            }
        }
    }

    private void getAnswer(){
        chooseFinishValue();
        switch (finishSystem){
            case "Arithmetic":{
                result = (firstNumber + secondNumber)/2;
                break;
            }
            case "Geometric":{
                result = Math.sqrt(firstNumber*secondNumber);
                break;
            }
            case "Square":{
                result = Math.sqrt((Math.pow(firstNumber,2)+Math.pow(secondNumber,2))/2);
                break;
            }
            case "Harmonious":{
                result = 2/((1/firstNumber) + (1/secondNumber));
            }
        }
    }
}