package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class BMI extends AppCompatActivity {
    private EditText editVaga;
    private EditText editSrist;
    private TextView textFinish;
    public double result;
    public int Vaga;
    public int SmSrist;
    public double MSrist;
    private String strResult;
    public String strVisnovok;
    private TextView visnovok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);
        editVaga = findViewById(R.id.edit_vaga);
        editSrist = findViewById(R.id.edit_srist);
        textFinish = findViewById(R.id.text_finish);
        visnovok = findViewById(R.id.visnovok);


        calculate.setOnClickListener(view -> {
            try {
                Vaga = Integer.parseInt(editVaga.getText().toString().trim());
                SmSrist = Integer.parseInt(editSrist.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                editVaga.setText(null);
                editSrist.setText(null);
            }
            getAnswer();
            strResult = String.format(Locale.UK, "%.2f ", result);
            textFinish.setText(strResult);
            getVisnovok();
            visnovok.setText(strVisnovok);
        });


        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(BMI.this, switch_off.class);
            startActivity(intent);
        });
    }

    private void getAnswer() {
        MSrist = 0.01 * SmSrist;
        result = Vaga/(Math.pow(MSrist,2));
    }


    private void getVisnovok() {
        getAnswer();
            if (result <= 16) {
                strVisnovok = "??????????????";
            }
            if (16 < result && result <= 18.5) {
                strVisnovok = "??????????????????????";
            }
            if (18.5 < result && result < 25) {
                strVisnovok = "??????????";
            }
            if (25 < result && result <= 30) {
                strVisnovok = "??????????????????????????";
            }
            if (30 < result && result <= 35) {
                strVisnovok = "???????????????? 1 ????.";
            }
            if (35 < result && result < 40) {
                strVisnovok = "???????????????? 2 ????.";
            }
            if (40 < result) {
                strVisnovok = "???????????????? 3 ????.";
            }
        }
}