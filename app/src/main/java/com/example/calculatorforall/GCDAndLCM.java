package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class GCDAndLCM extends AppCompatActivity {
//    private String startSystem;
//    public String strResult;
//    private String finishSystem;
//    private int startNumber;
//    public double result;
//    private TextView textFinish;
//    private EditText edit_text_start
    private EditText edit_first;
    private EditText edit_second;
    private TextView gdcText;
    private TextView lcmText;
    public int result;
    private int firstNumber;
    private int secondNumber;
    private int GDC;
    private int LCM;
    private String strGDC;
    private String strLCM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gdc_and_lcm);
        edit_first = findViewById(R.id.first_number);
        edit_second = findViewById(R.id.second_number);
        gdcText = findViewById(R.id.text_gdc);
        lcmText = findViewById(R.id.text_lcm);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button calculate = findViewById(R.id.calculate);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(GCDAndLCM.this, switch_off.class);
            startActivity(intent);
        });

        calculate.setOnClickListener(view -> {
            try {
                firstNumber = Integer.parseInt(edit_first.getText().toString().trim());
                secondNumber = Integer.parseInt(edit_second.getText().toString().trim());
            }catch (Exception e){
                new AlertDialog(this).show();
                edit_first.setText(null);
                edit_second.setText(null);
            }
            GDC = getGDC(firstNumber,secondNumber);
            LCM = getLCM(firstNumber,secondNumber);
            strGDC = String.valueOf(GDC);
            strLCM = String.valueOf(LCM);
            gdcText.setText(strGDC);
            lcmText.setText(strLCM);
        });
//        ImageButton switch_off = findViewById(R.id.switch_off);
//        Button konvert = findViewById(R.id.konvert);
//        edit_text_start = findViewById(R.id.edit_text_start);
//        textFinish = findViewById(R.id.text_finish);
    }

    private int getGDC(int a, int b) {
        while (b > 0)
        {
            long temp = b;
            b = a % b;
            a = (int) temp;
        }
        return a;
    }

    private int getLCM(int a,int b) {
        return a * (b / getGDC(a, b));
    }

//        Spinner spinner_start = findViewById(R.id.system_spinner_start);
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.GCDAndLCM)));
//        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
//        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_start.setAdapter(adapter_start);
//        spinner_start.getSelectedItemId();
//
//
//        Spinner spinner_finish = findViewById(R.id.system_spinner_finish);
//        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
//                R.array.GCDAndLCM, android.R.layout.simple_spinner_item);
//        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner_finish.setAdapter(adapter_finish);
//
//        switch_off.setOnClickListener(view -> {
//            Intent intent = new Intent(GCDAndLCM.this , switch_off.class);
//            startActivity(intent);
//        });
//
//
//        spinner_start.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//                switch(position){
//                    case 0:{
//                        edit_text_start.setKeyListener(DigitsKeyListener.getInstance("01"));
//                        break;
//                    }
//                    case 1:{
//                        edit_text_start.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
//                        break;
//                    }
//                    case 2:{
//                        edit_text_start.setKeyListener(DigitsKeyListener.getInstance("01234567"));
//                        break;
//                    }
//                    case 3:{
//                        edit_text_start.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDE"));
//                        break;
//                    }
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//            }
//        });
//
//        konvert.setOnClickListener(view -> {
//            startSystem = spinner_start.getSelectedItem().toString();
//            finishSystem = spinner_finish.getSelectedItem().toString();
//            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
//            getAnswer();
//            strResult = String.valueOf(result);
//            textFinish.setText(strResult);
//        });
//    }
//
//    private void getAnswer() {
//        switch(startSystem){
//            case "binary":{
////                edit_text_start.setInputType(InputType.TYPE_CLASS_NUMBER);
////                edit_text_start.setKeyListener(DigitsKeyListener.getInstance("01"));
//                switch (finishSystem){
//                    case "binary":{
//                        result = startNumber;
//                        break;
//                    }
//                    case "decimal":{
//                        strResult = Integer.toString(startNumber, 10);
//                        break;
//                    }
//                    case "octal":{
//                        strResult = Integer.toString(startNumber, 8);
//                        break;
//                    }
//                    case "hexadecimal":{
//                        strResult = Integer.toString(startNumber, 16);
//                        break;
//                    }
//                }
//                break;
//            }
//            case "decimal":{
////                edit_text_start.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
////                edit_text_start.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
//                switch (finishSystem){
//                    case "binary":{
//                        strResult = Integer.toBinaryString(startNumber);
//                        break;
//                    }
//                    case "decimal":{
//                        result = startNumber;
//                        break;
//                    }
//                    case "octal":{
//                        strResult = Integer.toString(startNumber, 8);
//                        break;
//                    }
//                    case "hexadecimal":{
//                        strResult = Integer.toString(startNumber, 16);
//                        break;
//                    }
//                }
//                break;
//            }
//            case "octal":{
////                edit_text_start.setInputType(InputType.TYPE_CLASS_NUMBER);
////                edit_text_start.setKeyListener(DigitsKeyListener.getInstance("01234567"));
//                switch (finishSystem){
//                    case "binary":{
//                        strResult = Integer.toString(startNumber, 2);
//                        break;
//                    }
//                    case "decimal":{
//                        strResult = Integer.toString(startNumber, 10);
//                        break;
//                    }
//                    case "octal":{
//                        result = startNumber;
//                        break;
//                    }
//                    case "hexadecimal":{
//                        strResult = Integer.toString(startNumber, 16);
//                        break;
//                    }
//                }
//                break;
//            }
//            case "hexadecimal":{
////                edit_text_start.setInputType(InputType.TYPE_CLASS_NUMBER);
////                edit_text_start.setKeyListener(DigitsKeyListener.getInstance("0123456789ABCDE"));
//                switch (finishSystem){
//                    case "binary":{
//                        strResult = Integer.toString(startNumber, 2);
//                        break;
//                    }
//                    case "decimal":{
//                        strResult = Integer.toString(startNumber, 10);
//                        break;
//                    }
//                    case "octal":{
//                        strResult = Integer.toString(startNumber, 8);
//                        break;
//                    }
//                    case "hexadecimal":{
//                        result = startNumber;
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//
//    }

}