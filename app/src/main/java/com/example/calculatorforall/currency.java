package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorforall.models.NbuModel;
import com.example.calculatorforall.retrofit.MyAPI;
import com.example.calculatorforall.retrofit.RetrofitClient;
import com.google.android.gms.common.api.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class currency extends AppCompatActivity {

    private Retrofit retrofit;
    private MyAPI myAPI;
    private ArrayList<NbuModel> nbuModels = new ArrayList<>();
    private static final String BASE_URL = "https://bank.gov.ua/";
    private String firstCurrency;
    private String secondCurrency;
    private Spinner spinner_start;
    private Spinner spinner_finish;
    public double firstCurrencyUAHValue;
    public double secondCurrencyUAHValue;
    public double result;
    private String strResult;
    private TextView textFinish;
    private EditText edit_text_start;
    private int startNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        textFinish = findViewById(R.id.text_finish);
        edit_text_start = findViewById(R.id.edit_text_start);
        ImageButton switch_off = findViewById(R.id.switch_off);
        Button convert = findViewById(R.id.konvert);

        retrofit = RetrofitClient.getInstance(BASE_URL,this);
        myAPI = retrofit.create(MyAPI.class);

        myAPI.getNbuList().enqueue(new Callback<ArrayList<NbuModel>>() {
//            @Override
//            public void onResponse(@NonNull Call<ArrayList<NbuModel>> call, @NonNull Response<ArrayList<NbuModel>> response) {
//                if (response.isSuccessful() && response.body()!=null){
//                    nbuModels.addAll(response.body());
//                }
//            }

            @Override
            public void onResponse(Call<ArrayList<NbuModel>> call, retrofit2.Response<ArrayList<NbuModel>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    nbuModels.addAll(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<NbuModel>> call, @NonNull Throwable t) {
                Log.e("CURRENCY",t.getLocalizedMessage());
            }
        });


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

        convert.setOnClickListener(view -> {
            firstCurrency = spinner_start.getSelectedItem().toString();
            secondCurrency = spinner_finish.getSelectedItem().toString();
            startNumber = Integer.parseInt(edit_text_start.getText().toString().trim());
            getAnswer();
            strResult = String.format(Locale.UK, "%.3f ", result);
            textFinish.setText(strResult);
        });

    }

    private void getFirstCurrency() {
        for (int i = 0; i <nbuModels.size() ; i++) {
            if (firstCurrency.equals(nbuModels.get(i).getCc())){
                firstCurrencyUAHValue = nbuModels.get(i).getRate();
            }
        }
    }

    private void getSecondCurrency() {
        for (int i = 0; i <nbuModels.size() ; i++) {
            if (secondCurrency.equals(nbuModels.get(i).getCc())){
                secondCurrencyUAHValue = nbuModels.get(i).getRate();
            }
        }
    }

    private void getAnswer() {
        getFirstCurrency();
        getSecondCurrency();
        if (firstCurrency.contains("UAH") && secondCurrency.contains("UAH")) {
            result = startNumber;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("CZK")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("USD")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("BYN")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("EUR")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("XAU")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("XAG")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("XPT")) {
            result = startNumber/secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("UAH") && secondCurrency.contains("XPD")) {
            result = startNumber/secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("CZK") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("CZK")) {
            result = startNumber;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("CZK") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("USD") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber) ;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("USD")) {
            result = startNumber;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("USD") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("BYN") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("BYN")) {
            result = startNumber;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("BYN") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("EUR") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("EUR")) {
            result = startNumber;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("EUR") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("XAU") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("XAU")) {
            result = startNumber;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAU") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("XAG") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("XAG")) {
            result = startNumber;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XAG") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("XPT") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("XPT")) {
            result = startNumber;
        }
        if (firstCurrency.contains("XPT") && secondCurrency.contains("XPD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }


        if (firstCurrency.contains("XPD") && secondCurrency.contains("UAH")) {
            result = (firstCurrencyUAHValue * startNumber);
        }
        if (firstCurrency.contains("XPD") && secondCurrency.contains("CZK")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPD") && secondCurrency.contains("USD")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPD") && secondCurrency.contains("BYN")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPD") && secondCurrency.contains("EUR")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.contains("XPD") && secondCurrency.contains("XAU")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.equals("XPD") && secondCurrency.equals("XAG")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.equals("XPD") && secondCurrency.equals("XPT")) {
            result = (firstCurrencyUAHValue * startNumber) / secondCurrencyUAHValue;
        }
        if (firstCurrency.equals("XPD") && secondCurrency.equals("XPD")) {
            result = startNumber;
        }
    }


}