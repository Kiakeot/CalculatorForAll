package com.example.calculatorforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.calculatorforall.models.NbuModel;
import com.example.calculatorforall.retrofit.MyAPI;
import com.example.calculatorforall.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class currency extends AppCompatActivity {

    private Retrofit retrofit;
    private MyAPI myAPI;
    private ArrayList<NbuModel> nbuModels = new ArrayList<>();
    private static final String BASE_URL = "https://bank.gov.ua/";
    private Button convert;
    private String firstCurrency;
    private String secondCurrency;
    private Spinner spinner_start;
    private Spinner spinner_finish;
    private double firstCurrencyUAHValue;
    private double secondCurrencyUAHValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        retrofit = RetrofitClient.getInstance(BASE_URL,this);
        myAPI = retrofit.create(MyAPI.class);

        myAPI.getNbuList().enqueue(new Callback<ArrayList<NbuModel>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<NbuModel>> call, @NonNull Response<ArrayList<NbuModel>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    nbuModels.addAll(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<NbuModel>> call, @NonNull Throwable t) {
                Log.e("CURRENCY",t.getLocalizedMessage());
            }
        });

        setContentView(R.layout.activity_currency);
        ImageButton switch_off = findViewById(R.id.switch_off);


        spinner_start = findViewById(R.id.currency_spinner_start);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.currency)));
        ArrayAdapter<String> adapter_start = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter_start.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_start.setAdapter(adapter_start);
        spinner_start.getSelectedItemId();



        spinner_finish = findViewById(R.id.currency_spinner_finish);
        ArrayAdapter adapter_finish = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter_finish.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_finish.setAdapter(adapter_finish);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(currency.this, switch_off.class);
            startActivity(intent);
        });

        initListeners();
    }

    private void initListeners() {
        convert = findViewById(R.id.konvert);
        convert.setOnClickListener(view -> {
            secondCurrency = spinner_finish.getSelectedItem().toString();
            firstCurrency = spinner_start.getSelectedItem().toString();
            for (int i = 0; i <nbuModels.size() ; i++) {
                if (firstCurrency.equals(nbuModels.get(i).getCc())){
                    firstCurrencyUAHValue = nbuModels.get(i).getRate();
                }
            }

        });
    }
}