package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Locale;

public class trigonometry extends AppCompatActivity {
    private TextView textFinish;
    private EditText edit_number;
    private int startNumber;
    private double startNumberRa;
    public double result;
    private String strResult;
    private String spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        edit_number = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.trigonometryList)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(trigonometry.this,switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            spinnerValue = spinner_start.getSelectedItem().toString();
            startNumber = Integer.parseInt(edit_number.getText().toString().trim());
            getAnswer();
            strResult = String.format(Locale.UK, "%.5f ", result);
            textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        switch(spinnerValue){
            case"Sine":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.sin(startNumberRa);
                break;
            }
            case "Cosine":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.cos(startNumberRa);
                break;
            }
            case "Tangent":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.tan(startNumberRa);
                break;
            }
            case "Сotangent":{
                startNumberRa = Math.toRadians(startNumber);
                result = 1.0/Math.tan(startNumberRa);
                break;
            }
            case"Arcsine":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.asin(startNumberRa);
                break;
            }
            case "Arccosine":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.acos(startNumberRa);
                break;
            }
            case "Arctangent":{
                startNumberRa = Math.toRadians(startNumber);
                result = Math.atan(startNumberRa);
                break;
            }
            case "Arccotangent":{
                startNumberRa = Math.toRadians(startNumber);
                result = (Math.PI/2) - Math.atan(startNumber);
                break;
            }
        }
    }
}