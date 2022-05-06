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

public class physik extends AppCompatActivity implements OnClickInterface {
    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physik);
        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button buoff = (Button) findViewById(R.id.buoff);
        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(getString(R.string.angel),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.power),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.temperature),getResources().getDrawable(R.drawable.physik_icon)));
        arrayList.add(new ItemListModel(getString(R.string.acceleration),getResources().getDrawable(R.drawable.acceleration_icon)));
        arrayList.add(new ItemListModel(getString(R.string.speed),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.pressure),getResources().getDrawable(R.drawable.algebra_icon)));
        arrayList.add(new ItemListModel(getString(R.string.weight),getResources().getDrawable(R.drawable.algebra_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);
        buoff.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(physik.this,switch_off.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onItemClick(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(physik.this, angel.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(physik.this, power.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(physik.this, temperature.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(physik.this, acceleration.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(physik.this, speed.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(physik.this, pressure.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(physik.this, weight.class);
                startActivity(intent);
                break;
        }
    }
}