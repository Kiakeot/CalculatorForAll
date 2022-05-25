package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button switch_off = findViewById(R.id.switch_off);
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
                filter(s.trim());
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
        } else {
            itemAdapter.setItemList(new ArrayList<>());
        }
        listForItemClick = sortedList;
    }


    private void createAllList() {
        arrayList.add(new ItemListModel(getString(R.string.square), ResourcesCompat.getDrawable(getResources(),R.drawable.square_icon,getTheme())));
        arrayList.add(new ItemListModel(getString(R.string.value), getResources().getDrawable(R.drawable.value_icon)));
        arrayList.add(new ItemListModel(getString(R.string.trigonometry), getResources().getDrawable(R.drawable.trigonometry_icon)));
        arrayList.add(new ItemListModel(getString(R.string.squareConvertor), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(getString(R.string.valueConvertor), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(getString(R.string.percentage), getResources().getDrawable(R.drawable.percent_icon)));
        arrayList.add(new ItemListModel(getString(R.string.average), getResources().getDrawable(R.drawable.average_icon)));
        arrayList.add(new ItemListModel(getString(R.string.linear_function), getResources().getDrawable(R.drawable.linear_function_icon)));
        arrayList.add(new ItemListModel(getString(R.string.quadratic_equation), getResources().getDrawable(R.drawable.quadratic_equation_icon)));
        arrayList.add(new ItemListModel(getString(R.string.random), getResources().getDrawable(R.drawable.random_icon)));
        arrayList.add(new ItemListModel(getString(R.string.GCDandLCM), getResources().getDrawable(R.drawable.no_icon)));
        arrayList.add(new ItemListModel(getString(R.string.currency), getResources().getDrawable(R.drawable.currency_icon)));
        arrayList.add(new ItemListModel(getString(R.string.tip), getResources().getDrawable(R.drawable.tips_icon)));
        arrayList.add(new ItemListModel(getString(R.string.credit), getResources().getDrawable(R.drawable.credit_icon)));
        arrayList.add(new ItemListModel(getString(R.string.deposit), getResources().getDrawable(R.drawable.deposit_icon)));
        arrayList.add(new ItemListModel(getString(R.string.tax), getResources().getDrawable(R.drawable.tax_icon)));
        arrayList.add(new ItemListModel(getString(R.string.data), getResources().getDrawable(R.drawable.data_icon)));
        arrayList.add(new ItemListModel(getString(R.string.BMI), getResources().getDrawable(R.drawable.bmi_icon)));
        arrayList.add(new ItemListModel(getString(R.string.fuel), getResources().getDrawable(R.drawable.fuel_icon)));
        arrayList.add(new ItemListModel(getString(R.string.dataStorage), getResources().getDrawable(R.drawable.data_storage_icon)));
        arrayList.add(new ItemListModel(getString(R.string.dataRate), getResources().getDrawable(R.drawable.data_rate_icon)));
        arrayList.add(new ItemListModel(getString(R.string.angel), getResources().getDrawable(R.drawable.angel_icon)));
        arrayList.add(new ItemListModel(getString(R.string.power), getResources().getDrawable(R.drawable.power_icon)));
        arrayList.add(new ItemListModel(getString(R.string.temperature), getResources().getDrawable(R.drawable.temperature_icon)));
        arrayList.add(new ItemListModel(getString(R.string.acceleration), getResources().getDrawable(R.drawable.acceleration_icon)));
        arrayList.add(new ItemListModel(getString(R.string.speed), getResources().getDrawable(R.drawable.speed_icon)));
        arrayList.add(new ItemListModel(getString(R.string.pressure), getResources().getDrawable(R.drawable.pressure_icon)));
        arrayList.add(new ItemListModel(getString(R.string.weight), getResources().getDrawable(R.drawable.weight_icon)));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent;
        switch (position){

        }
    }
}

