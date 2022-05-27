package com.example.calculatorforall.app;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.calculatorforall.retrofit.RetrofitClient;

public class Application extends android.app.Application {

    public static final String BASE_URL = "https://bank.gov.ua/";


    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.getInstance(BASE_URL,getApplicationContext());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }
}
