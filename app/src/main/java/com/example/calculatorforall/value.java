package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class value extends AppCompatActivity implements OnClickInterface {
    private final ArrayList<ItemListModel> arrayList = new ArrayList<>();

    @SuppressLint("UseCompatLoadingForDrawables")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);

        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button switch_off = findViewById(R.id.switch_off);

        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(0, getString(R.string.prism), getResources().getDrawable(R.drawable.prism_icon)));
        arrayList.add(new ItemListModel(1, getString(R.string.pyramid), getResources().getDrawable(R.drawable.pyramid_icon)));
        arrayList.add(new ItemListModel(2, getString(R.string.Cylinder), getResources().getDrawable(R.drawable.cylinder_icon)));
        arrayList.add(new ItemListModel(3, getString(R.string.Cone), getResources().getDrawable(R.drawable.cone_icon)));
        arrayList.add(new ItemListModel(4, getString(R.string.Sphere), getResources().getDrawable(R.drawable.sphere_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(value.this, switch_off.class);
            startActivity(intent);
        });
    }

    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(value.this, Prizma.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(value.this, Pyramid.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(value.this, Cylinder.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(value.this, Cone.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(value.this, Sphere.class);
                startActivity(intent);
                break;
        }
    }
}