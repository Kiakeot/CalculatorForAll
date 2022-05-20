package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class search extends AppCompatActivity {
//    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
//    private EditText edit_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
//        edit_list = findViewById(R.id.edit_text);
//        Button switch_off = findViewById(R.id.switch_off);
//        createAllList();
//
//        edit_list.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                filter()
//            }
//        });
//
//
//
//
//        switch_off.setOnClickListener(view -> {
//            Intent intent = new Intent(search.this, switch_off.class);
//            startActivity(intent);
//        });
//    }
//
//    private void createAllList(){
//        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
//        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(algebraManager);
//        arrayList.add(new ItemListModel(getString(R.string.square),getResources().getDrawable(R.drawable.square_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.value),getResources().getDrawable(R.drawable.value_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.trigonometry),getResources().getDrawable(R.drawable.trigonometry_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.squareConvertor),getResources().getDrawable(R.drawable.no_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.valueConvertor),getResources().getDrawable(R.drawable.no_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.percentage),getResources().getDrawable(R.drawable.percent_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.average),getResources().getDrawable(R.drawable.average_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.linear_function),getResources().getDrawable(R.drawable.linear_function_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.quadratic_equation),getResources().getDrawable(R.drawable.quadratic_equation_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.random),getResources().getDrawable(R.drawable.random_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.GCDandLCM),getResources().getDrawable(R.drawable.no_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.currency), getResources().getDrawable(R.drawable.currency_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.tip), getResources().getDrawable(R.drawable.tips_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.credit), getResources().getDrawable(R.drawable.credit_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.deposit), getResources().getDrawable(R.drawable.deposit_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.tax), getResources().getDrawable(R.drawable.tax_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.date),getResources().getDrawable(R.drawable.data_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.BMI),getResources().getDrawable(R.drawable.bmi_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.fuel),getResources().getDrawable(R.drawable.fuel_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.dataStorage),getResources().getDrawable(R.drawable.data_storage_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.dataRate),getResources().getDrawable(R.drawable.data_rate_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.angel),getResources().getDrawable(R.drawable.angel_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.power),getResources().getDrawable(R.drawable.power_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.temperature),getResources().getDrawable(R.drawable.temperature_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.acceleration),getResources().getDrawable(R.drawable.acceleration_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.speed),getResources().getDrawable(R.drawable.speed_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.pressure),getResources().getDrawable(R.drawable.pressure_icon)));
//        arrayList.add(new ItemListModel(getString(R.string.weight),getResources().getDrawable(R.drawable.weight_icon)));
//        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), (OnClickInterface) this, arrayList);
//        recyclerView.setAdapter(itemAdapter);
//    }
