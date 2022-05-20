package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class geometry extends AppCompatActivity implements OnClickInterface {
    private final ArrayList<ItemListModel> arrayList = new ArrayList<>();
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometry);
        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button buoff = (Button) findViewById(R.id.buoff);
        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(getString(R.string.square),getResources().getDrawable(R.drawable.square_icon)));
        arrayList.add(new ItemListModel(getString(R.string.squareConvertor),getResources().getDrawable(R.drawable.squareconvertor_icon)));
        arrayList.add(new ItemListModel(getString(R.string.value),getResources().getDrawable(R.drawable.value_icon)));
        arrayList.add(new ItemListModel(getString(R.string.valueConvertor),getResources().getDrawable(R.drawable.valueconvertor_icon)));
        arrayList.add(new ItemListModel(getString(R.string.trigonometry),getResources().getDrawable(R.drawable.trigonometry_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        buoff.setOnClickListener(v -> {
            Intent intent = new Intent(geometry.this,switch_off.class);
            startActivity(intent);
        });
    }

    @Override
    public void onItemClick(int position) {
        switch (position){
            case 0:
                Intent intent = new Intent(geometry.this,square.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(geometry.this, SquareConvertor.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(geometry.this, value.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(geometry.this, ValueConvertor.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(geometry.this, trigonometry.class);
                startActivity(intent);
                break;
        }
    }
}