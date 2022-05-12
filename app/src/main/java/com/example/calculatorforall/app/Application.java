package com.example.calculatorforall.app;

import com.example.calculatorforall.retrofit.RetrofitClient;

public class Application extends android.app.Application {

    public static final String BASE_URL = "https://bank.gov.ua/";

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient.getInstance(BASE_URL,getApplicationContext());
    }
}
