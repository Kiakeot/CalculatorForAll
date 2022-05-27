package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ConeSquare extends AppCompatActivity {
    private EditText editRadius;
    private EditText editheight;
    private TextView textFinish;
    public double result;
    private String strResult;
    private String startSystem;
    public double firstNumber;
    public double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone_square);

        editRadius = findViewById(R.id.first_number);
        editheight = findViewById(R.id.second_number);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        textFinish = findViewById(R.id.text_finish);

        Spinner spinner_start = findViewById(R.id.spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.Creative)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();

        spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 0){
                    editheight.setHint(R.string.creature);
                }
                if(position == 1){
                    editheight.setHint(R.string.height);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        calculate.setOnClickListener(view -> {
            startSystem = spinner_start.getSelectedItem().toString();
            try {
                firstNumber = Integer.parseInt(editRadius.getText().toString().trim());
                secondNumber = Integer.parseInt(editheight.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editRadius.setText(null);
                editheight.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(ConeSquare.this,switch_off.class);
            startActivity(intent);
        });
    }

    private void getAnswer() {
        switch(startSystem){
            case "you have a creature":
                result = Math.PI * firstNumber * secondNumber;
                break;
            case "you haven`t a creature":
                result = Math.PI * firstNumber * Math.sqrt(Math.pow(secondNumber,2)+Math.pow(firstNumber,2));
        }
    }
}