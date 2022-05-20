package com.example.calculatorforall;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.TimeZone;

public class date extends AppCompatActivity {
    private Button firstDateButton;
    private Button secondDateButton;
    private MaterialDatePicker<Long> firstMaterialDatePicker;
    private MaterialDatePicker<Long> secondMaterialDatePicker;
    private String[] firstDateArray;
    private String[] secondDateArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT A DATE");
        firstMaterialDatePicker = materialDateBuilder.build();
        secondMaterialDatePicker = materialDateBuilder.build();
        ImageButton switch_off = findViewById(R.id.switch_off);
        firstDateButton = findViewById(R.id.firstDatePickerButton);
        secondDateButton = findViewById(R.id.secondDatePickerButton);
        Button calculate = findViewById(R.id.calculate);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(date.this, switch_off.class);
            startActivity(intent);
        });

        firstDateButton.setOnClickListener(view -> {
            firstMaterialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            firstMaterialDatePicker.addOnPositiveButtonClickListener(this::getFirstDate);
        });

        secondDateButton.setOnClickListener(view -> {
            secondMaterialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
            secondMaterialDatePicker.addOnPositiveButtonClickListener(this::getSecondDate);
        });

        calculate.setOnClickListener(v -> differenceBetweenTwoTimes(firstDateArray, secondDateArray));
    }

    @SuppressLint("SetTextI18n")
    private void getFirstDate(Long selection) {
        Calendar firstCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        firstCalendar.setTimeInMillis(selection);
        SimpleDateFormat firstFormat = new SimpleDateFormat("MM.dd.yyyy");
        String firstFormattedDate = firstFormat.format(firstCalendar.getTime());
        firstDateArray = splitString(firstFormattedDate);
        firstDateButton.setText(Integer.parseInt(firstDateArray[1]) + " "  + getMonthFormat(Integer.parseInt(firstDateArray[0]))  + " " + Integer.parseInt(firstDateArray[2]));
    }


    @SuppressLint("SetTextI18n")
    private void getSecondDate(Long selection) {
        Calendar secondCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        secondCalendar.setTimeInMillis(selection);
        SimpleDateFormat secondFormat = new SimpleDateFormat("MM.dd.yyyy");
        String secondFormattedDate = secondFormat.format(secondCalendar.getTime());
        secondDateArray = splitString(secondFormattedDate);
        secondDateButton.setText(Integer.parseInt(secondDateArray[1]) + " "  + getMonthFormat(Integer.parseInt(secondDateArray[0]))  + " " + Integer.parseInt(secondDateArray[2]));
    }

    public static String[] splitString(String s) {
        int count = 0;
        char[] c = s.toCharArray();

        for (char value : c) {
            if (value == '.') {
                count++;
            }
        }
        String temp = "";
        int k = 0;
        String[] rev = new String[count + 1];
        for (char value : c) {
            if (value == '.') {
                rev[k++] = temp;
                temp = "";
            } else
                temp = temp + value;
        }
        rev[k] = temp;
        return rev;
    }


    public void differenceBetweenTwoTimes(String[] firstDateArray, String[] secondDateArray) {
        int monthFirst = Integer.parseInt(firstDateArray[0]);
        int dayFirst = Integer.parseInt(firstDateArray[1]);
        int yearFirst = Integer.parseInt(firstDateArray[2]);
        int monthSecond = Integer.parseInt(secondDateArray[0]);
        int daySecond = Integer.parseInt(secondDateArray[1]);
        int yearSecond = Integer.parseInt(secondDateArray[2]);
        LocalDate firstDate = LocalDate.of(yearFirst, monthFirst, dayFirst);
        LocalDate secondDate = LocalDate.of(yearSecond,monthSecond, daySecond);
        Period period = Period.between(firstDate, secondDate);
        int years = Math.abs(period.getYears());
        int months = Math.abs(period.getMonths());
        int days = Math.abs(period.getDays());
        String date = years + " year(s) " + months + " month(s) " + days + " day(s)";
        TextView calculatedText = findViewById(R.id.difference_between_dates_text);
        if(years == 0 && months == 0 && days !=0){
            date = days + " day(s)";
        }
        if(years == 0 && months != 0 && days != 0){
            date = months + " month(s) " + days + " day(s)";
        }
        if(years == 0 && months != 0 && days == 0){
            date = months + " month(s)";
        }
        if(years != 0 && months == 0 && days == 0){
            date = years + " year(s)";
        }
        if(years != 0 && months != 0 && days == 0){
            date = years + " year(s) " + months + " month(s)";
        }
        if(years != 0 && months == 0 && days != 0){
            date = years + " year(s) " + days + " day(s)";
        }
        if(years != 0 && months != 0 && days != 0){
            date = years + " year(s) " + months + " month(s) " + days + " day(s)";
        }
        calculatedText.setText(date);
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return getString(R.string.January);
        if(month == 2)
            return getString(R.string.February);
        if(month == 3)
            return getString(R.string.March);
        if(month == 4)
            return getString(R.string.April);
        if(month == 5)
            return getString(R.string.May);
        if(month == 6)
            return getString(R.string.June);
        if(month == 7)
            return getString(R.string.July);
        if(month == 8)
            return getString(R.string.August);
        if(month == 9)
            return getString(R.string.September);
        if(month == 10)
            return getString(R.string.October);
        if(month == 11)
            return getString(R.string.November);
        if(month == 12)
            return getString(R.string.December);
        return getString(R.string.January);
    }
}