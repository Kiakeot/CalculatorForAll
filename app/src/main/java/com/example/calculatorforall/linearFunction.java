package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class linearFunction extends AppCompatActivity {
    private EditText firstEdit;
    private EditText secondEdit;
    private TextView finishText;
    private String firstSpinnerValue;
    private String secondSpinnerValue;
    private int firstSpinnerPos;
    private int secondSpinnerPos;
    public double result;
    private String strResult;
    public double firstValue;
    public double secondValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        ImageButton switch_off = findViewById(R.id.switch_off);
        firstEdit = findViewById(R.id.first_number);
        secondEdit = findViewById(R.id.second_number);
        finishText = findViewById(R.id.text_finish);
        Button calculate = findViewById(R.id.calculate);

        Spinner spinner_start = findViewById(R.id.spinner_first_znak);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.znak)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_second_znak);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.znak, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(linearFunction.this,switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            firstSpinnerPos = spinner_start.getSelectedItemPosition();
            secondSpinnerPos = spinner_finish.getSelectedItemPosition();
            firstValue = Integer.parseInt(firstEdit.getText().toString().trim());
            secondValue = Integer.parseInt(secondEdit.getText().toString().trim());
            getAnswer();
            strResult = String.valueOf(result);
            finishText.setText(strResult);
        });
    }

    private void getAnswer() {
        getFirstSpinnerPosition();
        getSecondSpinnerPosition();
        if(firstSpinnerValue.contains("+") && secondSpinnerValue.contains("+") || firstSpinnerValue.contains("-") && secondSpinnerValue.contains("-")){
            result = secondValue/firstValue;
        }
        if(firstSpinnerValue.contains("+") && secondSpinnerValue.contains("-") || firstSpinnerValue.contains("-") && secondSpinnerValue.contains("+")){
            result = (-1) * (secondValue/firstValue);
        }
    }

    private void getSecondSpinnerPosition() {
        if (firstSpinnerPos == 0){
            firstSpinnerValue = "+";
        }else{
            firstSpinnerValue = "-";
        }
    }

    private void getFirstSpinnerPosition() {
        if (secondSpinnerPos == 0){
            secondSpinnerValue = "+";
        }else{
            secondSpinnerValue = "-";
        }
    }
}