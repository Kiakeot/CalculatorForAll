package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class quadraticEquation extends AppCompatActivity {
    private EditText edit_first;
    private EditText edit_second;
    private EditText edit_third;
    private TextView textFirstResult;
    private TextView textSecondResult;
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;
    public double firstResult;
    public double secondResult;
    private double discriminante;
    private String strSecondResult;
    private String strFirstResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equation);
        edit_first = findViewById(R.id.edit_first);
        edit_second = findViewById(R.id.edit_second);
        edit_third = findViewById(R.id.edit_third);
        textFirstResult = findViewById(R.id.textFirstResult);
        textSecondResult = findViewById(R.id.textSecondResult);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(quadraticEquation.this,switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            try {
                firstNumber = Integer.parseInt(edit_first.getText().toString().trim());
                secondNumber = Integer.parseInt(edit_second.getText().toString().trim());
                thirdNumber = Integer.parseInt(edit_third.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                edit_third.setText(null);
                edit_second.setText(null);
                edit_first.setText(null);
            }
            getAnswers();
            strFirstResult = String.valueOf(firstResult);
            strSecondResult = String.valueOf(secondResult);
            textFirstResult.setText(strFirstResult);
            textSecondResult.setText(strSecondResult);
        });
    }

    private void getAnswers() {
        getDiscriminante();
        firstResult = ((-1) * secondNumber + Math.sqrt(discriminante))/(2 * firstNumber);
        secondResult = ((-1) * secondNumber - Math.sqrt(discriminante))/(2 * firstNumber);
    }

    private void getDiscriminante() {
        discriminante = Math.pow(secondNumber,2) - 4 * firstNumber * thirdNumber;
    }
}