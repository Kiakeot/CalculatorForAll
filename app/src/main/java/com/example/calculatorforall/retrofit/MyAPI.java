package com.example.calculatorforall.retrofit;

import com.example.calculatorforall.models.NbuModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    @GET("NBUStatService/v1/statdirectory/exchange?json")
    Call<ArrayList<NbuModel>> getNbuList();
}
