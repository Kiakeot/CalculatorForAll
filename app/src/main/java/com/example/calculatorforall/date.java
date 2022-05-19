package com.example.calculatorforall;

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

    private void getFirstDate(Long selection) {
        Calendar firstCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        firstCalendar.setTimeInMillis(selection);
        SimpleDateFormat firstFormat = new SimpleDateFormat("MM.dd.yyyy");
        String firstFormattedDate = firstFormat.format(firstCalendar.getTime());
        firstDateArray = splitString(firstFormattedDate);
        firstDateButton.setText(firstFormattedDate);
    }


    private void getSecondDate(Long selection) {
        Calendar secondCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        secondCalendar.setTimeInMillis(selection);
        SimpleDateFormat secondFormat = new SimpleDateFormat("MM.dd.yyyy");
        String secondFormattedDate = secondFormat.format(secondCalendar.getTime());
        secondDateArray = splitString(secondFormattedDate);
        secondDateButton.setText(secondFormattedDate);
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
        String date = years + " years " + months + " months " + days + " days";
        TextView calculatedText = findViewById(R.id.difference_between_dates_text);
        calculatedText.setText(date);
    }
}
//    private String getMonthFormat(int month) {
//        if(month == 1)
//            return "Січ.";
//        if(month == 2)
//            return "Лют.";
//        if(month == 3)
//            return "Бер.";
//        if(month == 4)
//            return "Кві.";
//        if(month == 5)
//            return "Тра.";
//        if(month == 6)
//            return "Чер.";
//        if(month == 7)
//            return "Лип.";
//        if(month == 8)
//            return "Сер.";
//        if(month == 9)
//            return "Вер.";
//        if(month == 10)
//            return "Жов.";
//        if(month == 11)
//            return "Лис.";
//        if(month == 12)
//            return "Гру.";
//        return "Січ.";
//    } }