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

public class pressure extends AppCompatActivity {
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
        setContentView(R.layout.activity_pressure);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        editNumber = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.pressure_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.pressure)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.pressure_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.pressure, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(pressure.this,switch_off.class);
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
            case "atm":{
                switch (secondSpinner){
                    case "atm":{
                        result = startNumber;
                        break;
                    }
                    case "bar":{
                        result = 1.01325 * startNumber;
                        break;
                    }
                    case "N/m^2":{
                        result = 101325 * startNumber;
                        break;
                    }
                    case "psi":{
                        result = 14.69594 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "bar":{
                switch (secondSpinner){
                    case "atm":{
                        result = 0.98692 * startNumber;
                        break;
                    }
                    case "bar":{
                        result = startNumber;
                        break;
                    }
                    case "N/m^2":{
                        result = 100000 * startNumber;
                        break;
                    }
                    case "psi":{
                        result = 14.50377 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "N/m^2":{
                switch (secondSpinner){
                    case "atm":{
                        result = 9.86923 * startNumber;
                        break;
                    }
                    case "bar":{
                        result = 0.00001 * startNumber;
                        break;
                    }
                    case "N/m^2":{
                        result = startNumber;
                        break;
                    }
                    case "psi":{
                        result = 0.00014 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "psi":{
                switch (secondSpinner){
                    case "atm":{
                        result = 0.068045 * startNumber;
                        break;
                    }
                    case "bar":{
                        result = 0.068947 * startNumber;
                        break;
                    }
                    case "N/m^2":{
                        result = 6894.75729 * startNumber;
                        break;
                    }
                    case "psi":{
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
        }
    }
}