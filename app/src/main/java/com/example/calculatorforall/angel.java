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

public class angel extends AppCompatActivity {
    private String startSystem;
    private String finishSystem;
    public double result;
    private TextView textFinish;
    private int startNumber;
    private String strResult;
    private EditText edit_text_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel);
        edit_text_start = findViewById(R.id.edit_text_start);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        textFinish = findViewById(R.id.text_finish);



        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.angel)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();



        Spinner spinner_finish = findViewById(R.id.spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.angel, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);



        konvert.setOnClickListener(view -> {
            startSystem = spinner_start.getSelectedItem().toString();
            finishSystem = spinner_finish.getSelectedItem().toString();
            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
            convertData();
            strResult = String.format(Locale.UK, "%.5f ", result);
            textFinish.setText(strResult);
        });

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(angel.this, switch_off.class);
            startActivity(intent);
        });
    }


    private void convertData() {
        switch (startSystem) {
            case "radian":
                switch (finishSystem) {
                    case "radian":
                        result = startNumber;
                        break;
                    case "degree":
                        result = 57.29577 * startNumber;
                        break;
                    case "minute":
                        result = 3437.74677 * startNumber;
                        break;
                    case "second":
                        result = 206264.80625 * startNumber;
                        break;
                }
                break;

            case "degree":
                switch (finishSystem) {
                    case "radian":
                        result = 0.01745 * startNumber;
                        break;
                    case "degree":
                        result = startNumber;
                        break;
                    case "minute":
                        result =  60 * startNumber;
                        break;
                    case "Gal":
                        result = 3600 * startNumber;
                        break;
                }
                break;

            case "minute":
                switch (finishSystem) {
                    case "radian":
                        result = 0.0002908882 * startNumber;
                        break;
                    case "degree":
                        result = 0.01666 * startNumber;
                        break;
                    case "minute":
                        result = startNumber;
                        break;
                    case "second":
                        result = 60 * startNumber;
                        break;
                }
                break;
            case "second":
                switch (finishSystem) {
                    case "radian":
                        result = 0.0000048481 * startNumber;
                        break;
                    case "degree":
                        result =  0.0002777778 * startNumber;
                        break;
                    case "minute":
                        result = 0.01666667 * startNumber;
                        break;
                    case "second":
                        result = startNumber;
                        break;
                }
                break;
        }
    }

}