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

public class fuel extends AppCompatActivity {
    private String startSystem;
    private String strResult;
    private String finishSystem;
    private int startSystemPos;
    private int finishSystemPos;
    private int startNumber;
    public double result;
    private TextView textFinish;
    private EditText edit_text_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);
        edit_text_start = findViewById(R.id.edit_text_start);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        textFinish = findViewById(R.id.text_finish);



        Spinner spinner_start = findViewById(R.id.fuel_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.fuel)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();



        Spinner spinner_finish = findViewById(R.id.fuel_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.fuel, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);



        konvert.setOnClickListener(view -> {
            finishSystemPos = spinner_finish.getSelectedItemPosition();
            startSystemPos = spinner_start.getSelectedItemPosition();
            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(fuel.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void chooseFinishValue() {
        switch (finishSystemPos) {
            case 0: {
                finishSystem = "l/100km";
                break;
            }
            case 1: {
                finishSystem = "mpg";
                break;
            }
            case 2: {
                finishSystem = "l/m";
                break;
            }
            case 3: {
                finishSystem = "mpl";
                break;
            }
        }
    }

    private void chooseStartValue() {
        switch (startSystemPos) {
            case 0: {
                startSystem = "l/100km";
                break;
            }
            case 1: {
                startSystem = "mpg";
                break;
            }
            case 2: {
                startSystem = "l/m";
                break;
            }
            case 3: {
                startSystem = "mpl";
                break;
            }
        }
    }
    private void getAnswer(){
        chooseStartValue();
        chooseFinishValue();
        switch (startSystem) {
            case "l/100km":
                switch (finishSystem) {
                    case "l/100km":
                        result = startNumber;
                        break;
                    case "mpg":
                        result = 235.2145 * startNumber;
                        break;
                    case "l/m":
                        result = 0.00001 * startNumber;
                        break;
                    case "mpl":
                        result = 62.13711/startNumber;
                        break;
                }
                break;

            case "mpg":
                switch (finishSystem) {
                    case "l/100km":
                        result = 235.21458 * startNumber;
                        break;
                    case "mpg":
                        result = startNumber;
                        break;
                    case "l/m":
                        result = 0.0023521 * startNumber;
                        break;
                    case "mpl":
                        result = 0.220 * startNumber;
                        break;
                }
                break;

            case "l/m":
                switch (finishSystem) {
                    case "l/100km":
                        result = 100000 * startNumber;
                        break;
                    case "mpg":
                        result = 0.0023521 * startNumber;
                        break;
                    case "l/m":
                        result = startNumber;
                        break;
                    case "mpl":
                        result = 0.0023521 * 0.220 *  startNumber;
                        break;
                }
                break;
            case "mpl":
                switch (finishSystem) {
                    case "l/100km":
                        result = 62.13711/startNumber;
                        break;
                    case "mpg":
                        result = 4.546 * startNumber;
                        break;
                    case "l/m":
                        result = (0.62/startNumber) * 0.001;
                        break;
                    case "mpl":
                        result = startNumber;
                        break;
                }
                break;
        }
    }
}