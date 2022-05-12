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

public class dataStorage extends AppCompatActivity {
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
        setContentView(R.layout.activity_data_storage);
        startValue = findViewById(R.id.edit_start_value);
        finishValue = findViewById(R.id.text_finish);
        Button konvert = findViewById(R.id.konvert);
        ImageButton switch_off = findViewById(R.id.switch_off);

        Spinner spinner_start = findViewById(R.id.dataStorage_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.dataStorage)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.dataStorage_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.dataStorage, android.R.layout.simple_spinner_item);
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
            Intent intent = new Intent(dataStorage.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void getStartPosition() {
        switch (spinnerStartValuePosit) {
            case 0: {
                spinnerStartValue = "Mb";
                break;
            }
            case 1: {
                spinnerStartValue = "Gb";
                break;
            }
            case 2: {
                spinnerStartValue = "MB";
                break;
            }
            case 3: {
                spinnerStartValue = "GB";
                break;
            }
        }
    }

    private void getFinishPosition() {
        switch (spinnerFinishValuePosit) {
            case 0: {
                spinnerFinishValue = "Mb";
                break;
            }
            case 1: {
                spinnerFinishValue = "Gb";
                break;
            }
            case 2: {
                spinnerFinishValue = "MB";
                break;
            }
            case 3: {
                spinnerFinishValue = "GB";
                break;
            }
        }
    }


    private void getAnswer() {
        getFinishPosition();
        getStartPosition();
        switch (spinnerStartValue) {
            case "Mb":
                switch (spinnerFinishValue) {
                    case "Mb":
                        result = UserValue;
                        break;
                    case "Gb":
                        result = 0.001 * UserValue;
                        break;
                    case "MB":
                        result = 0.125 * UserValue;
                        break;
                    case "GB":
                        result = 0.000125 * UserValue;
                        break;

                }
                break;
            case "Gb":
                switch (spinnerFinishValue) {
                    case "Mb":
                        result = 1000 * UserValue;
                        break;
                    case "Gb":
                        result = UserValue;
                        break;
                    case "MB":
                        result = 125 * UserValue;
                        break;
                    case "GB":
                        result = 0.125 * UserValue;
                        break;
                }
                break;
            case "MB":
                switch (spinnerFinishValue) {
                    case "Mb":
                        result = 8 * UserValue;
                        break;
                    case "Gb":
                        result = 0.008 * UserValue;
                        break;
                    case "MB":
                        result = UserValue;
                        break;
                    case "GB":
                        result = 0.001 * UserValue;
                        break;
                }
                break;
            case "GB":
                switch (spinnerFinishValue) {
                    case "Mb":
                        result = 8000 * UserValue;
                        break;
                    case "Gb":
                        result = 8 * UserValue;
                        break;
                    case "MB":
                        result = 1000 * UserValue;
                        break;
                    case "GB":
                        result = UserValue;
                        break;
                }
                break;
        }
    }
}

