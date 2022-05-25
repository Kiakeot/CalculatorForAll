package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;
import java.util.Locale;

public class search extends AppCompatActivity implements OnClickInterface {
    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
    private SearchView searchView;
    private ItemAdapter itemAdapter;
    private ArrayList<ItemListModel> listForItemClick;
    private LottieAnimationView animation;
    private TextView textError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button switch_off = findViewById(R.id.switch_off);
        animation = findViewById(R.id.animationView);
        textError = findViewById(R.id.text_error);
        createAllList();
        itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(itemAdapter);

        switch_off.setOnClickListener(view -> {
            Intent intent = new Intent(search.this, switch_off.class);
            startActivity(intent);
        });

        searchView = findViewById(R.id.edit_text);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s.trim().toLowerCase(Locale.ROOT));
                return false;
            }
        });
    }

    private void filter(String trim) {
        ArrayList<ItemListModel> sortedList = new ArrayList<>();
        ItemListModel itemListModel;
        String data;
        for (int i = 0; i < arrayList.size(); i++) {
            itemListModel = arrayList.get(i);
            data = itemListModel.getItemTitle().toLowerCase(Locale.ROOT).trim();
            if ( data.contains(trim)) {
                sortedList.add(itemListModel);
            }
        }
        if (!sortedList.isEmpty()) {
            itemAdapter.setItemList(sortedList);
            animation.setVisibility(View.GONE);
            textError.setVisibility(View.GONE);
        } else {
            itemAdapter.setItemList(new ArrayList<>());
            animation.setVisibility(View.VISIBLE);
            textError.setVisibility(View.VISIBLE);
        }
        listForItemClick = sortedList;
    }


    private void createAllList() {
        arrayList.add(new ItemListModel(0,getString(R.string.square), ResourcesCompat.getDrawable(getResources(),R.drawable.square_icon,getTheme())));
        arrayList.add(new ItemListModel(1,getString(R.string.value), getResources().getDrawable(R.drawable.value_icon)));
        arrayList.add(new ItemListModel(2,getString(R.string.trigonometry), getResources().getDrawable(R.drawable.trigonometry_icon)));
        arrayList.add(new ItemListModel(3,getString(R.string.squareConvertor), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(4,getString(R.string.valueConvertor), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(5,getString(R.string.percentage), getResources().getDrawable(R.drawable.percent_icon)));
        arrayList.add(new ItemListModel(6,getString(R.string.average), getResources().getDrawable(R.drawable.average_icon)));
        arrayList.add(new ItemListModel(7,getString(R.string.linear_function), getResources().getDrawable(R.drawable.linear_function_icon)));
        arrayList.add(new ItemListModel(8,getString(R.string.quadratic_equation), getResources().getDrawable(R.drawable.quadratic_equation_icon)));
        arrayList.add(new ItemListModel(9,getString(R.string.random), getResources().getDrawable(R.drawable.random_icon)));
        arrayList.add(new ItemListModel(10,getString(R.string.GCDandLCM), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(11,getString(R.string.currency), getResources().getDrawable(R.drawable.currency_icon)));
        arrayList.add(new ItemListModel(12,getString(R.string.tip), getResources().getDrawable(R.drawable.tips_icon)));
        arrayList.add(new ItemListModel(13,getString(R.string.credit), getResources().getDrawable(R.drawable.credit_icon)));
        arrayList.add(new ItemListModel(14,getString(R.string.deposit), getResources().getDrawable(R.drawable.deposit_icon)));
        arrayList.add(new ItemListModel(15,getString(R.string.tax), getResources().getDrawable(R.drawable.tax_icon)));
        arrayList.add(new ItemListModel(16,getString(R.string.data), getResources().getDrawable(R.drawable.data_icon)));
        arrayList.add(new ItemListModel(17,getString(R.string.BMI), getResources().getDrawable(R.drawable.bmi_icon)));
        arrayList.add(new ItemListModel(18,getString(R.string.fuel), getResources().getDrawable(R.drawable.fuel_icon)));
        arrayList.add(new ItemListModel(19,getString(R.string.dataStorage), getResources().getDrawable(R.drawable.data_storage_icon)));
        arrayList.add(new ItemListModel(20,getString(R.string.dataRate), getResources().getDrawable(R.drawable.data_rate_icon)));
        arrayList.add(new ItemListModel(21,getString(R.string.angel), getResources().getDrawable(R.drawable.angel_icon)));
        arrayList.add(new ItemListModel(22,getString(R.string.power), getResources().getDrawable(R.drawable.power_icon)));
        arrayList.add(new ItemListModel(23,getString(R.string.temperature), getResources().getDrawable(R.drawable.temperature_icon)));
        arrayList.add(new ItemListModel(24,getString(R.string.acceleration), getResources().getDrawable(R.drawable.acceleration_icon)));
        arrayList.add(new ItemListModel(25,getString(R.string.speed), getResources().getDrawable(R.drawable.speed_icon)));
        arrayList.add(new ItemListModel(26,getString(R.string.pressure), getResources().getDrawable(R.drawable.pressure_icon)));
        arrayList.add(new ItemListModel(27,getString(R.string.weight), getResources().getDrawable(R.drawable.weight_icon)));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(search.this,square.class);
                break;
            case 1:
                intent = new Intent(search.this, value.class);
                break;
            case 2:
                intent = new Intent(search.this,trigonometry.class);
                break;
            case 3:
                intent = new Intent(search.this,SquareConvertor.class);
                break;
            case 4:
                intent = new Intent(search.this,ValueConvertor.class);
                break;
            case 5:
                intent = new Intent(search.this, percentage.class);
                break;
            case 6:
                intent = new Intent(search.this,average.class);
                break;
            case 7:
                intent = new Intent(search.this, linearFunction.class);
                break;
            case 8:
                intent = new Intent(search.this,quadraticEquation.class);
                break;
            case 9:
                intent = new Intent(search.this, random.class);
                break;
            case 10:
                intent = new Intent(search.this,GCDAndLCM.class);
                break;
            case 11:
                intent = new Intent(search.this,currency.class);
                break;
            case 12:
                intent = new Intent(search.this,tip.class);
                break;
            case 13:
                intent = new Intent(search.this, credit.class);
                break;
            case 14:
                intent = new Intent(search.this,deposit.class);
                break;
            case 15:
                intent = new Intent(search.this, tax.class);
                break;
            case 16:
                intent = new Intent(search.this,date.class);
                break;
            case 17:
                intent = new Intent(search.this, BMI.class);
                break;
            case 18:
                intent = new Intent(search.this,fuel.class);
                break;
            case 19:
                intent = new Intent(search.this,dataStorage.class);
                break;
            case 20:
                intent = new Intent(search.this,dataRate.class);
                break;
            case 21:
                intent = new Intent(search.this, angel.class);
                break;
            case 22:
                intent = new Intent(search.this,power.class);
                break;
            case 23:
                intent = new Intent(search.this, temperature.class);
                break;
            case 24:
                intent = new Intent(search.this,acceleration.class);
                break;
            case 25:
                intent = new Intent(search.this, speed.class);
                break;
            case 26:
                intent = new Intent(search.this,pressure.class);
                break;
            case 27:
                intent = new Intent(search.this, weight.class);
                break;
        }
        startActivity(intent);
    }
}

