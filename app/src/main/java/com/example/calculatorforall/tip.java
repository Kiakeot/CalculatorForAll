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

public class tip extends AppCompatActivity {
    private EditText editBill;
    private EditText editPeople;
    private TextView textFinish;
    private String spinnerValue;
    private double result;
    private int firstNumber;
    private int secondNumber;
    private String strResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        editBill = findViewById(R.id.first_number);
        editPeople = findViewById(R.id.second_number);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.country)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_start);
        spinner_finish.getSelectedItemId();



        calculate.setOnClickListener(view -> {
            spinnerValue = spinner_finish.getSelectedItem().toString();
            try {
                firstNumber = Integer.parseInt(editBill.getText().toString().trim());
                secondNumber = Integer.parseInt(editPeople.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editPeople.setText(null);
                editBill.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });


        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(tip.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void getAnswer() {
        switch (spinnerValue){
            case "France":{
                result = (firstNumber * 0.15)/secondNumber;
                break;
            }
            case "Italy":
            case "Netherlands":
            case "Ukraine":
            case "Germany": {
                result = (firstNumber * 0.1)/secondNumber;
                break;
            }
            case "USA":{
                result = (firstNumber * 0.04)/secondNumber;
                break;
            }
            case "Japan":{
                result = 0;
                break;
            }
            case "Czech Republic":{
                result = (firstNumber * 0.14)/secondNumber;
                break;
            }
        }
    }
}