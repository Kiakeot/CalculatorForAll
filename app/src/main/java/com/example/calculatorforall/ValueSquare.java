package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class ValueSquare extends AppCompatActivity implements OnClickInterface {
    private final ArrayList<ItemListModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_square);

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
            Intent intent = new Intent(ValueSquare.this, switch_off.class);
            startActivity(intent);
        });
    }

    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(ValueSquare.this, PrizmaSquare.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(ValueSquare.this, PyramidSquare.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(ValueSquare.this, CylinderSquare.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(ValueSquare.this, ConeSquare.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(ValueSquare.this, SphereSquare.class);
                startActivity(intent);
                break;
        }
    }
}