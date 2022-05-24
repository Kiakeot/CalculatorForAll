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

public class temperature extends AppCompatActivity {
    private String startSystem;
    private String strResult;
    private String finishSystem;
    private int startNumber;
    public double result;
    private TextView textFinish;
    private EditText edit_text_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        edit_text_start = findViewById(R.id.edit_text);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        textFinish = findViewById(R.id.text_finish);



        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.temperature)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();



        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.temperature, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);



        konvert.setOnClickListener(view -> {
            startSystem = spinner_start.getSelectedItem().toString();
            finishSystem = spinner_finish.getSelectedItem().toString();
            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
            convertData();
            strResult = String.format(Locale.UK, "%.5f", result);
            textFinish.setText(strResult);
        });

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(temperature.this, switch_off.class);
            startActivity(intent);
        });
    }



    private void convertData() {
        switch (startSystem) {
            case "Celsius":
                switch (finishSystem) {
                    case "Celsius":
                        result = startNumber;
                        break;
                    case "Fahrenheit":
                        result = (startNumber * 1.8) + 32;
                        break;
                    case "Kelvins":
                        result = startNumber - 273.15;
                        break;
                }
                break;

            case "Fahrenheit":
                switch (finishSystem) {
                    case "Celsius":
                        result = (startNumber - 32)/1.8;
                        break;
                    case "Fahrenheit":
                        result = startNumber;
                        break;
                    case "Kelvins":
                        result =  (1.8 * (startNumber - 273)) + 32.;
                        break;
                }
                break;

            case "Kelvins":
                switch (finishSystem) {
                    case "Celsius":
                        result = startNumber + 273.15;
                        break;
                    case "Fahrenheit":
                        result = (startNumber  + 459.67) * 5/9;
                        break;
                    case "Kelvins":
                        result = startNumber;
                        break;
                }
                break;
        }
    }
}