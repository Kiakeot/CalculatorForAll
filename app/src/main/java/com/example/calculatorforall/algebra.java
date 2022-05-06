package com.example.calculatorforall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class algebra extends AppCompatActivity implements OnClickInterface {
    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);
        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button buoff = (Button) findViewById(R.id.buoff);
        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(getString(R.string.percentage),getResources().getDrawable(R.drawable.percent_icon)));
        arrayList.add(new ItemListModel(getString(R.string.average),getResources().getDrawable(R.drawable.average_icon)));
        arrayList.add(new ItemListModel(getString(R.string.proportions),getResources().getDrawable(R.drawable.proportion_icon)));
        arrayList.add(new ItemListModel(getString(R.string.linear_function),getResources().getDrawable(R.drawable.linear_function_icon)));
        arrayList.add(new ItemListModel(getString(R.string.quadratic_equation),getResources().getDrawable(R.drawable.quadratic_equation_icon)));
        arrayList.add(new ItemListModel(getString(R.string.roman),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.numberSystems),getResources().getDrawable(R.drawable.algebra_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        buoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(algebra.this,switch_off.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(algebra.this,percentage.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(algebra.this, average.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(algebra.this, linearFunction.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(algebra.this, quadraticEquation.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(algebra.this, random.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(algebra.this, roman.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(algebra.this, numberSystems.class);
                startActivity(intent);
                break;
        }
    }
}
