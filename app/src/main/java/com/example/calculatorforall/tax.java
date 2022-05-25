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

public class tax extends AppCompatActivity {
    private EditText editSuma;
    private EditText editPercent;
    private TextView textFinish;
    private TextView textTax;
    public double result;
    public double taxValue;
    private int allSuma;
    private int percent;
    private String strResult;
    private String strTaxValue;
    private String changes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        editSuma = findViewById(R.id.first_number);
        editPercent = findViewById(R.id.second_number);
        textFinish = findViewById(R.id.text_finish);
        textTax = findViewById(R.id.text_tax_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.upOrDown)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();

        switch_off.setOnClickListener(view -> {
          Intent intent = new Intent(tax.this,switch_off.class);
          startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            changes = spinner_start.getSelectedItem().toString();
            try {
                allSuma = Integer.parseInt(editSuma.getText().toString().trim());
                percent = Integer.parseInt(editPercent.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editPercent.setText(null);
                editSuma.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            strTaxValue = String.valueOf(taxValue);
            textFinish.setText(strResult);
            textTax.setText(strTaxValue);
        });
    }

    private void getAnswer() {
        switch (changes){
            case "Increment":{
                taxValue = allSuma * (percent*0.01);
                result = allSuma + taxValue;
                break;
            }
            case "Decrease":{
                taxValue = allSuma * (percent*0.01);
                result = allSuma - taxValue;
                break;
            }
        }
    }
}