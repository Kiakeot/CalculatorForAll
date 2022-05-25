package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class power extends AppCompatActivity {
    private EditText editFirstNumber;
    private EditText editSecondNumber;
    private TextView textFinish;
    public double result;
    private double firstNumber;
    private double secondNumber;
    private String strResult;
    private String firstSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        editFirstNumber = findViewById(R.id.first_number);
        editSecondNumber = findViewById(R.id.second_number);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.power)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();

        spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    editFirstNumber.setHint(R.string.allWork);
                    editSecondNumber.setHint(R.string.allTimes);
                }
                if(position == 1){
                    editFirstNumber.setHint(R.string.voltage);
                    editSecondNumber.setHint(R.string.amperage);
                }
                if(position == 2){
                    editFirstNumber.setHint(R.string.amperage);
                    editSecondNumber.setHint(R.string.resistance);
                }
                if(position == 3){
                    editFirstNumber.setHint(R.string.amperage);
                    editSecondNumber.setHint(R.string.resistance);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(power.this,switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            firstSpinner = spinner_start.getSelectedItem().toString();
            try {
                firstNumber = Integer.parseInt(editFirstNumber.getText().toString().trim());
                secondNumber = Integer.parseInt(editSecondNumber.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editFirstNumber.setText(null);
                editSecondNumber.setText(null);
            }
            getAnswer();
            strResult = String.format(Locale.UK, "%.3f ", result);
            textFinish.setText(strResult);

        });
    }

    private void getAnswer() {
        switch (firstSpinner){
            case "A/t":{
                result = firstNumber/secondNumber;
                break;
            }
            case "U*I":{
                result = firstNumber*secondNumber;
                break;
            }
            case "I^2*R":{
                result = Math.pow(firstNumber,2)*secondNumber;
                break;
            }
            case "U^2/R":{
                result = Math.pow(firstNumber,2)*secondNumber;
                break;
            }
        }
    }
}