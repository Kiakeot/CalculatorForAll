package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Parallelogram extends AppCompatActivity {
    private EditText editSquare;
    private EditText editHeight;
    private TextView textFinish;
    public double result;
    private String strResult;
    public double firstNumber;
    public double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallelogram);

        editSquare = findViewById(R.id.first_number);
        editHeight = findViewById(R.id.second_number);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        textFinish = findViewById(R.id.text_finish);

        calculate.setOnClickListener(view -> {
            try {
                firstNumber = Integer.parseInt(editSquare.getText().toString().trim());
                secondNumber = Integer.parseInt(editHeight.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editSquare.setText(null);
                editHeight.setText(null);
            }
            getAnswer();
            strResult = String.valueOf(result);
            textFinish.setText(strResult);
        });
    }

    private void getAnswer() {
        result = (firstNumber*secondNumber)/2;
    }
}