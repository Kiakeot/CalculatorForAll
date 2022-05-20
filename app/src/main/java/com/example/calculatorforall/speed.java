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

public class speed extends AppCompatActivity {
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
        setContentView(R.layout.activity_speed);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        editNumber = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);


        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.speed)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.speed, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(speed.this,switch_off.class);
            startActivity(intent);
        });

        konvert.setOnClickListener(view -> {
            firstSpinner = spinner_start.getSelectedItem().toString();
            secondSpinner = spinner_finish.getSelectedItem().toString();
            startNumber = Integer.parseInt(editNumber.getText().toString().trim());
            getAnswer();
            strResult = String.format(Locale.UK, "%.5f ", result);
            textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        switch (firstSpinner){
            case "m/s":{
                switch (secondSpinner){
                    case "m/s":{
                        result = startNumber;
                        break;
                    }
                    case "km/h":{
                        result = 3.6 * startNumber;
                        break;
                    }
                    case "mph":{
                        result = 2.23693 * startNumber;
                        break;
                    }
                    case "ft/s":{
                        result = 3.28083 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "km/h":{
                switch (secondSpinner){
                    case "m/s":{
                        result = 0.27777 * startNumber;
                        break;
                    }
                    case "km/h":{
                        result = startNumber;
                        break;
                    }
                    case "mph":{
                        result = 0.62137 * startNumber;
                        break;
                    }
                    case "ft/s":{
                        result = 0.91134 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "mph":{
                switch (secondSpinner){
                    case "m/s":{
                        result = 0.44704 * startNumber;
                        break;
                    }
                    case "km/h":{
                        result = 1.60934 * startNumber;
                        break;
                    }
                    case "mph":{
                        result = startNumber;
                        break;
                    }
                    case "ft/s":{
                        result = 1.46666 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ft/s":{
                switch (secondSpinner){
                    case "m/s":{
                        result = 0.3048 * startNumber;
                        break;
                    }
                    case "km/h":{
                        result = 1.09728 * startNumber;
                        break;
                    }
                    case "mph":{
                        result = 0.68181 * startNumber;
                        break;
                    }
                    case "ft/s":{
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
        }
    }
}