package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class dataRate extends AppCompatActivity {
    private EditText startValue;
    private TextView finishValue;

    private String strResult;
    private String spinnerStartValue;
    private String spinnerFinishValue;

    private int spinnerStartValuePosit;
    private int spinnerFinishValuePosit;
    private int UserValue;

    public double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_rate);
        startValue = findViewById(R.id.edit_start_value);
        finishValue = findViewById(R.id.text_finish);
        Button konvert = findViewById(R.id.konvert);
        ImageButton switch_off = findViewById(R.id.switch_off);

        Spinner spinner_start = findViewById(R.id.dataRate_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.dataRate)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.dataRate_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.dataRate, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);


        konvert.setOnClickListener(view -> {
            spinnerStartValuePosit = spinner_start.getSelectedItemPosition();
            spinnerFinishValuePosit = spinner_finish.getSelectedItemPosition();
            UserValue = Integer.parseInt(startValue.getText().toString().trim());
            getAnswer();
            strResult = String.valueOf(result);
            finishValue.setText(strResult);
        });


        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(dataRate.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void getStartPosition() {
        switch (spinnerStartValuePosit) {
            case 0: {
                spinnerStartValue = "Kb/s";
                break;
            }
            case 1: {
                spinnerStartValue = "Mb/s";
                break;
            }
            case 2: {
                spinnerStartValue = "Gb/s";
                break;
            }
            case 3: {
                spinnerStartValue = "Tb/s";
                break;
            }
        }
    }

    private void getFinishPosition() {
        switch (spinnerFinishValuePosit) {
            case 0: {
                spinnerFinishValue = "Kb/s";
                break;
            }
            case 1: {
                spinnerFinishValue = "Mb/s";
                break;
            }
            case 2: {
                spinnerFinishValue = "Gb/s";
                break;
            }
            case 3: {
                spinnerFinishValue = "Tb/s";
                break;
            }
        }
    }


    private void getAnswer() {
        getFinishPosition();
        getStartPosition();
        switch (spinnerStartValue) {
            case "Kb/s":
                switch (spinnerFinishValue) {
                    case "Kb/s":
                        result = UserValue;
                        break;
                    case "Mb/s":
                        result = 0.001 * UserValue;
                        break;
                    case "Gb/s":
                        result = 0.000001 * UserValue;
                        break;
                    case "Tb/s":
                        result = 0.000000001 * UserValue;
                        break;

                }
                break;
            case "Mb/s":
                switch (spinnerFinishValue) {
                    case "Kb/s":
                        result = 1000 * UserValue;
                        break;
                    case "Mb/s":
                        result = UserValue;
                        break;
                    case "Gb/s":
                        result = 0.001 * UserValue;
                        break;
                    case "Tb/s":
                        result = 0.000001 * UserValue;
                        break;
                }
                break;
            case "Gb/s":
                switch (spinnerFinishValue) {
                    case "Kb/s":
                        result = 1000000 * UserValue;
                        break;
                    case "Mb/s":
                        result = 1000 * UserValue;
                        break;
                    case "Gb/s":
                        result = UserValue;
                        break;
                    case "Tb/s":
                        result = 0.001 * UserValue;
                        break;
                }
                break;
            case "Tb/s":
                switch (spinnerFinishValue) {
                    case "Kb/s":
                        result = 1000000000 * UserValue;
                        break;
                    case "Mb/s":
                        result = 1000000 * UserValue;
                        break;
                    case "Gb/s":
                        result = 1000 * UserValue;
                        break;
                    case "Tb/s":
                        result = UserValue;
                        break;
                }
                break;
            }
        }
    }

