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

public class ValueConvertor extends AppCompatActivity {
    private EditText editNumber;
    private TextView textFinish;
    public double result;
    private double startNumber;
    private String strResult;
    private String firstSpinner;
    private String secondSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_convertor);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        editNumber = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.value)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.value, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(ValueConvertor.this, switch_off.class);
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
            strResult = String.format(Locale.UK, "%.5f ", result);
            textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        switch (firstSpinner) {
            case "m^3": {
                switch (secondSpinner) {
                    case "m^3": {
                        result = startNumber;
                        break;
                    }
                    case "l": {
                        result = 1000 * startNumber;
                        break;
                    }
                    case "mm^3": {
                        result = 1000000000 * startNumber;
                        break;
                    }
                    case "ml":{
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "cm^3": {
                        result = 1000000 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "l": {
                switch (secondSpinner) {
                    case "m^3": {
                        result = 0.001 * startNumber;
                        break;
                    }
                    case "l": {
                        result = startNumber;
                        break;
                    }
                    case "mm^3": {
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "ml":{
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "cm^3": {
                        result = 1000 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "mm^3": {
                switch (secondSpinner) {
                    case "m^3": {
                        result = 0.000000001 * startNumber;
                        break;
                    }
                    case "l": {
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "mm^3": {
                        result = startNumber;
                        break;
                    }
                    case "ml":{
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "cm^3": {
                        result = 0.001 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ml":{
                switch (secondSpinner) {
                    case "m^3": {
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "l": {
                        result = 0.001 * startNumber;
                        break;
                    }
                    case "mm^3": {
                        result = 1000 * startNumber;
                        break;
                    }
                    case "ml": {
                        result = startNumber;
                        break;
                    }
                    case "cm^3": {
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
            case "cm^3": {
                switch (secondSpinner) {
                    case "m^3": {
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "l": {
                        result = 0.001 * startNumber;
                        break;
                    }
                    case "mm^3": {
                        result = 1000 * startNumber;
                        break;
                    }
                    case "ml":{
                        result = startNumber;
                        break;
                    }
                    case "cm^3": {
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
        }
    }
}