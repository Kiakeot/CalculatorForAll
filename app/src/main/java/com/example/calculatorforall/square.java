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
import java.util.concurrent.locks.ReentrantLock;

public class square extends AppCompatActivity implements OnClickInterface {
    private final ArrayList<ItemListModel> arrayList = new ArrayList<>();

    @SuppressLint("UseCompatLoadingForDrawables")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        Button switch_off = findViewById(R.id.switch_off);

        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(0, getString(R.string.Triangel), getResources().getDrawable(R.drawable.triangel_icon)));
        arrayList.add(new ItemListModel(1, getString(R.string.Parallelogram), getResources().getDrawable(R.drawable.paralelogram_icon)));
        arrayList.add(new ItemListModel(2, getString(R.string.Rhombus), getResources().getDrawable(R.drawable.romb_icon)));
        arrayList.add(new ItemListModel(3, getString(R.string.Rectangle), getResources().getDrawable(R.drawable.rectangel_icon)));
        arrayList.add(new ItemListModel(4, getString(R.string.Trapeze), getResources().getDrawable(R.drawable.trapez_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), (OnClickInterface) this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        switch_off.setOnClickListener(v -> {
            Intent intent = new Intent(square.this, switch_off.class);
            startActivity(intent);
        });
    }

    public void onItemClick(int position) {
        switch (position) {
            case 0:
                Intent intent = new Intent(square.this, Triangel.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(square.this, Parallelogram.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(square.this, Rhombus.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(square.this, Rectangel.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(square.this, Trapez.class);
                startActivity(intent);
                break;
        }
    }
}