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
import java.util.Locale;

public class dataRate extends AppCompatActivity {
    private EditText startValue;
    private TextView finishValue;

    private String strResult;
    private String spinnerStartValue;
    private String spinnerFinishValue;

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

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.dataRate)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.dataRate, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);


        konvert.setOnClickListener(view -> {
            spinnerStartValue = spinner_start.getSelectedItem().toString();
            spinnerFinishValue = spinner_finish.getSelectedItem().toString();
            try {
                UserValue = Integer.parseInt(startValue.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
            }
            getAnswer();
            strResult = String.format(Locale.UK, "%.5f ", result);
            finishValue.setText(strResult);
        });


        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(dataRate.this, switch_off.class);
            startActivity(intent);
        });
    }



    private void getAnswer() {
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

