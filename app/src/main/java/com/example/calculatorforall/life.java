package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class life extends AppCompatActivity implements OnClickInterface {
    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button buoff = (Button) findViewById(R.id.buoff);
        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(getString(R.string.date),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.BMI),getResources().getDrawable(R.drawable.bmi_icon)));
        arrayList.add(new ItemListModel(getString(R.string.fuel),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.dataStorage),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.dataRate),getResources().getDrawable(R.drawable.algebra_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        buoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(life.this,switch_off.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(life.this,date.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(life.this, BMI.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(life.this, fuel.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(life.this, dataStorage.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(life.this, dataRate.class);
                startActivity(intent);
                break;
        }
    }
}