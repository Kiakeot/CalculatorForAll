package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class acceleration extends AppCompatActivity {
    private String startSystem;
    private String finishSystem;
    private int startSystemPos;
    private int finishSystemPos;
    public String strStartNumber;
    public double result;
    private TextView textFinish;
    private int startNumber;
    private String strResult;
    private EditText edit_text_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceleration);
        edit_text_start = findViewById(R.id.edit_text_start);
        Button switch_off = findViewById(R.id.switch_off);
        Button konvert = findViewById(R.id.konvert);
        textFinish = findViewById(R.id.text_finish);

        edit_text_start.setOnKeyListener((v, keyCode, event) -> {
                    if (event.getAction() == KeyEvent.ACTION_DOWN &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        strStartNumber = edit_text_start.getText().toString();
                        return true;
                    }
                    return false;
                }
        );


        Spinner spinner_start = findViewById(R.id.acceleration_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.acceleration)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();


//        spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                startSystemPos = i;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });

        Spinner spinner_finish = findViewById(R.id.acceleration_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.acceleration, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);
//
//        spinner_finish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                finishSystemPos = i;
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        konvert.setOnClickListener(view -> {
            finishSystemPos = spinner_finish.getSelectedItemPosition();
            startSystemPos = spinner_start.getSelectedItemPosition();
            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
            convertData();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(acceleration.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void chooseFinishValue() {
        switch (finishSystemPos) {
            case 0: {
                finishSystem = "m/s^2";
                break;
            }
            case 1: {
                finishSystem = "ft/s^2";
                break;
            }
            case 2: {
                finishSystem = "g";
                break;
            }
            case 3: {
                finishSystem = "Gal";
                break;
            }
        }
    }

    private void chooseStartValue() {
        switch (startSystemPos) {
            case 0: {
                startSystem = "m/s^2";
                break;
            }
            case 1: {
                startSystem = "ft/s^2";
                break;
            }
            case 2: {
                startSystem = "g";
                break;
            }
            case 3: {
                startSystem = "Gal";
                break;
            }
        }
    }

    private void convertData() {
        chooseStartValue();
        chooseFinishValue();

        switch (startSystem) {
            case "m/s^2":
                switch (finishSystem) {
                    case "m/s^2":
                        result = startNumber;
                        break;
                    case "ft/s^2":
                        result = 3.28083 * startNumber;
                        break;
                    case "g":
                        result = 0.10193 * startNumber;
                        break;
                    case "Gal":
                        result = 100 * startNumber;
                        break;
                }
                break;

            case "ft/s^2":
                switch (finishSystem) {
                    case "m/s^2":
                        result = 0.3048 * startNumber;
                        break;
                    case "ft/s^2":
                        result = startNumber;
                        break;
                    case "g":
                        result = 0.03107 * startNumber;
                        break;
                    case "Gal":
                        result = 30.48 * startNumber;
                        break;
                }
                break;

            case "g":
                switch (finishSystem) {
                    case "m/s^2":
                        result = 9.81 * startNumber;
                        break;
                    case "ft/s^2":
                        result = 32.18503 * startNumber;
                        break;
                    case "g":
                        result = startNumber;
                        break;
                    case "Gal":
                        result = 981 * startNumber;
                        break;
                }
                break;
            case "Gal":
                switch (finishSystem) {
                    case "m/s^2":
                        result = 0.01 * startNumber;
                        break;
                    case "ft/s^2":
                        result = 0.03280 * startNumber;
                        break;
                    case "g":
                        result = 0.00101 * startNumber;
                        break;
                    case "Gal":
                        result = startNumber;
                        break;
                }
                break;
        }

//        if (!startSystem.equals("m/s^2") && !finishSystem.equals("m/s^2")) {
//            result = startNumber;
//        }
//        if (!startSystem.equals("m/s^2") && !finishSystem.equals("ft/s^2")) {
//            result = 3.28083 * startNumber;
//        }
//        if (!startSystem.equals("m/s^2") && !finishSystem.equals("g")) {
//            result = 0.10193 * startNumber;
//        }
//        if (!startSystem.equals("m/s^2") && !finishSystem.equals("Gal")) {
//            result = 100 * startNumber;
//        }
//
//
//        if (!startSystem.equals("ft/s^2") && !finishSystem.equals("m/s^2")) {
//            result = 0.3048 * startNumber;
//        }
//        if (!startSystem.equals("ft/s^2") && !finishSystem.equals("ft/s^2")) {
//            result = startNumber;
//        }
//        if (!startSystem.equals("ft/s^2") && !finishSystem.equals("g")) {
//            result = 0.03107 * startNumber;
//        }
//        if (!startSystem.equals("ft/s^2") && !finishSystem.equals("Gal")) {
//            result = 30.48 * startNumber;
//        }
//
//
//        if (!startSystem.equals("g") && !finishSystem.equals("m/s^2")) {
//            result = 9.81 * startNumber;
//        }
//        if (!startSystem.equals("g") && !finishSystem.equals("ft/s^2")) {
//            result = 32.18503 * startNumber;
//        }
//        if (!startSystem.equals("g") && !finishSystem.equals("g")) {
//            result = startNumber;
//        }
//        if (!startSystem.equals("g") && !finishSystem.equals("Gal")) {
//            result = 981 * startNumber;
//        }
//
//
//        if (!startSystem.equals("Gal") && !finishSystem.equals("m/s^2")) {
//            result = 0.01 * startNumber;
//        }
//        if (!startSystem.equals("Gal") && !finishSystem.equals("ft/s^2")) {
//            result = 0.03280 * startNumber;
//        }
//        if (!startSystem.equals("Gal") && !finishSystem.equals("g")) {
//            result = 0.00101 * startNumber;
//        }
//        if (!startSystem.equals("Gal") && !finishSystem.equals("Gal")) {
//            result = startNumber;
//        }
    }

}