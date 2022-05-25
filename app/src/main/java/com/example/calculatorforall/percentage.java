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

public class percentage extends AppCompatActivity {
    private EditText editSuma;
    private EditText editPercent;
    private TextView textFinish;
    public double result;
    private int allSuma;
    private double percent;
    private String strResult;
    private String changes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage);
        textFinish = findViewById(R.id.text_finish);
        editSuma = findViewById(R.id.edit_suma);
        editPercent = findViewById(R.id.edit_percent);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);

        Spinner spinner_start = findViewById(R.id.percent_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.upOrDown)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(percentage.this,switch_off.class);
            startActivity(intent);
        });

        spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    textFinish.setHint(R.string.Increment);
                }
                if(position == 1){
                    textFinish.setHint(R.string.Decrease);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        calculate.setOnClickListener(view -> {
             changes = spinner_start.getSelectedItem().toString();
             try {
                 allSuma = Integer.parseInt(editSuma.getText().toString().trim());
                 percent = Integer.parseInt(editPercent.getText().toString().trim());
             }catch (Exception e){
                 new AlertDialog(this).show();
                 editSuma.setText(null);
                 editPercent.setText(null);
             }
             getAnswer();
             strResult = String.valueOf(result);
             textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        switch(changes){
            case "Increment":{
                result = allSuma + allSuma*(percent/100);
                break;
            }
            case "Decrease":{
                result = allSuma - allSuma*(percent/100);
                break;
            }
        }
    }
}