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
import java.util.Locale;

public class SquareConvertor extends AppCompatActivity {
    private EditText editNumber;
    private TextView textFinish;
    public double result;
    private int startNumber;
    private String strResult;
    private String firstSpinner;
    private String secondSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_convertor);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        editNumber = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.square)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.square, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(SquareConvertor.this,switch_off.class);
            startActivity(intent);
        });

        konvert.setOnClickListener(view -> {
            firstSpinner = spinner_start.getSelectedItem().toString();
            secondSpinner = spinner_finish.getSelectedItem().toString();
            try {
                startNumber = Integer.parseInt(editNumber.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editNumber.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        switch (firstSpinner) {
            case "cm^2": {
                switch (secondSpinner) {
                    case "cm^2": {
                        result = startNumber;
                        break;
                    }
                    case "m^2": {
                        result = 0.0001 * startNumber;
                        break;
                    }
                    case "km^2": {
                        result = 0.0000000001 * startNumber;
                        break;
                    }
                    case "ft^2": {
                        result = 0.0010763 * startNumber;
                        break;
                    }
                    case "yd^2": {
                        result = 0.00011959 * startNumber;
                        break;
                    }
                    case "ar": {
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "ha": {
                        result = 0.00000001 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "m^2":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 10000 *startNumber;
                        break;
                    }
                    case "m^2":{
                        result = startNumber;
                        break;
                    }
                    case "km^2":{
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "ft^2":{
                        result = 10.76391 * startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = 1.19599 * startNumber;
                        break;
                    }
                    case "ar":{
                        result = 0.01 * startNumber;
                        break;
                    }
                    case "ha":{
                        result = 0.0001 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "km^2":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 100000 * 100000 * startNumber;
                        break;
                    }
                    case "m^2":{
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "km^2":{
                        result =  startNumber;
                        break;
                    }
                    case "ft^2":{
                        result = 10763910.41671 * startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = 1195990.04630 * startNumber;
                        break;
                    }
                    case "ar":{
                        result = 10000 * startNumber;
                        break;
                    }
                    case "ha":{
                        result = 100 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ft^2":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 929.0304 * startNumber;
                        break;
                    }
                    case "m^2":{
                        result = 0.09290 * startNumber;
                        break;
                    }
                    case "km^2":{
                        result = 9.290304E-8 * startNumber;
                        break;
                    }
                    case "ft^2":{
                        result =  startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = 0.11111 * startNumber;
                        break;
                    }
                    case "ar":{
                        result = 0.00092903 * startNumber;
                        break;
                    }
                    case "ha":{
                        result = 9.290304E-6 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "yd^2":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 8361.2736 * startNumber;
                        break;
                    }
                    case "m^2":{
                        result = 0.83612 * startNumber;
                        break;
                    }
                    case "km^2":{
                        result = 8.3612736E-7 * startNumber;
                        break;
                    }
                    case "ft^2":{
                        result = 9 * startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = startNumber;
                        break;
                    }
                    case "ar":{
                        result = 0.0083612 * startNumber;
                        break;
                    }
                    case "ha":{
                        result = 8.3612736E-5 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ar":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "m^2":{
                        result = 100 * startNumber;
                        break;
                    }
                    case "km^2":{
                        result = 0.0001 * startNumber;
                        break;
                    }
                    case "ft^2":{
                        result = 1076.39104 * startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = 119.59900 * startNumber;
                        break;
                    }
                    case "ar":{
                        result = startNumber;
                        break;
                    }
                    case "ha":{
                        result = 0.01 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ha":{
                switch (secondSpinner){
                    case "cm^2":{
                        result = 100000000 * startNumber;
                        break;
                    }
                    case "m^2":{
                        result = 10000 * startNumber;
                        break;
                    }
                    case "km^2":{
                        result = 0.01 * startNumber;
                        break;
                    }
                    case "ft^2":{
                        result = 107639.10416 * startNumber;
                        break;
                    }
                    case "yd^2":{
                        result = 11959.90046 * startNumber;
                        break;
                    }
                    case "ar":{
                        result = 100 * startNumber;
                        break;
                    }
                    case "ha":{
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
        }
    }
}