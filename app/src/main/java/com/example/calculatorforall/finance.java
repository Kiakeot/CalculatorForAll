package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculatorforall.adapter.ItemAdapter;
import com.example.calculatorforall.adapter.ItemListModel;
import com.example.calculatorforall.adapter.OnClickInterface;

import java.util.ArrayList;

public class finance extends AppCompatActivity implements OnClickInterface {
    private ArrayList<ItemListModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        Button buoff = (Button) findViewById(R.id.buoff);
        RecyclerView recyclerView = findViewById(R.id.recycler_algebra);
        LinearLayoutManager algebraManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(algebraManager);
        arrayList.add(new ItemListModel(0,getString(R.string.currency), getResources().getDrawable(R.drawable.currency_icon)));
        arrayList.add(new ItemListModel(1,getString(R.string.tip), getResources().getDrawable(R.drawable.tips_icon)));
        arrayList.add(new ItemListModel(2,getString(R.string.credit), getResources().getDrawable(R.drawable.credit_icon)));
        arrayList.add(new ItemListModel(3,getString(R.string.deposit), getResources().getDrawable(R.drawable.deposit_icon)));
        arrayList.add(new ItemListModel(4,getString(R.string.tax), getResources().getDrawable(R.drawable.tax_icon)));
        ItemAdapter itemAdapter = new ItemAdapter(getApplicationContext(), this, arrayList);
        recyclerView.setAdapter(itemAdapter);

        buoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(finance.this, switch_off.class);
                startActivity(intent);
            }
        });
    }
        @Override
        public void onItemClick(int position) {
            switch (position){
                case 0:
                    Intent intent = new Intent(finance.this,currency.class);
                    startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(finance.this, tip.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(finance.this, credit.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(finance.this, deposit.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(finance.this, tax.class);
                    startActivity(intent);
                    break;
            }
    }
}