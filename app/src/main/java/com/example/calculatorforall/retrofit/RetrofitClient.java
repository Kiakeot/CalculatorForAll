package com.example.calculatorforall.retrofit;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;

    public static Retrofit getInstance(String baseUrl, Context context) {
        if (instance == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ChuckerInterceptor.Builder(context).build())
                    .build();

            instance = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    private RetrofitClient() { }

}
