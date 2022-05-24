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

public class weight extends AppCompatActivity {
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
        setContentView(R.layout.activity_weight);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        editNumber = findViewById(R.id.edit_text);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.weight)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.weight, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(weight.this, switch_off.class);
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
        switch (firstSpinner) {
            case "g": {
                switch (secondSpinner) {
                    case "g": {
                        result = startNumber;
                        break;
                    }
                    case "kg": {
                        result = 0.001 * startNumber;
                        break;
                    }
                    case "t": {
                        result = 0.000001 * startNumber;
                        break;
                    }
                    case "lb(pound)": {
                        result = 0.0022046 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "kg": {
                switch (secondSpinner) {
                    case "g": {
                        result = 1000 * startNumber;
                        break;
                    }
                    case "kg": {
                        result = startNumber;
                        break;
                    }
                    case "t": {
                        result = 0.001 * startNumber;
                        break;
                    }
                    case "lb(pound)": {
                        result = 2.20462 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "t": {
                switch (secondSpinner) {
                    case "g": {
                        result = 1000000 * startNumber;
                        break;
                    }
                    case "kg": {
                        result = 1000 * startNumber;
                        break;
                    }
                    case "t": {
                        result = startNumber;
                        break;
                    }
                    case "lb(pound)": {
                        result = 2204.62262 * startNumber;
                        break;
                    }
                }
                break;
            }
            case "ft": {
                switch (secondSpinner) {
                    case "g": {
                        result = 453.59237 * startNumber;
                        break;
                    }
                    case "kg": {
                        result = 0.45359 * startNumber;
                        break;
                    }
                    case "t": {
                        result = 0.00045359 * startNumber;
                        break;
                    }
                    case "lb(pound)": {
                        result = startNumber;
                        break;
                    }
                }
                break;
            }
        }
    }
}