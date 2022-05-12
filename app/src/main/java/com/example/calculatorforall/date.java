package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;

import java.util.Calendar;

public class date extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    private Button firstDateButton;
    private Button secondDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        ImageButton switch_off = findViewById(R.id.switch_off);
        initDatePicker();
        firstDateButton = findViewById(R.id.firstDatePickerButton);
        secondDateButton = findViewById(R.id.secondDatePickerButton);
        firstDateButton.setText(getTodaysDate());

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(date.this,switch_off.class);
            startActivity(intent);
        });

    }



    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day,month,year);
                    firstDateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }

    private String makeDateString(int day, int month, int year) {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "Січ.";
        if(month == 2)
            return "Лют.";
        if(month == 3)
            return "Бер.";
        if(month == 4)
            return "Кві.";
        if(month == 5)
            return "Тра.";
        if(month == 6)
            return "Чер.";
        if(month == 7)
            return "Лип.";
        if(month == 8)
            return "Сер.";
        if(month == 9)
            return "Вер.";
        if(month == 10)
            return "Жов.";
        if(month == 11)
            return "Лис.";
        if(month == 12)
            return "Гру.";
        return "Січ.";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

}

class innerFirstDate implements DatePickerDialog.OnDateSetListener{
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }

}

class innerSecondDate implements DatePickerDialog.OnDateSetListener{
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


    }

}