package com.example.calculatorforall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorforall.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<AdapterViewHolder> {
private final Context context;
private final OnClickInterface onClickInterface;
private final ArrayList<ItemListModel> itemList;
    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.algebra_list,parent,false);
        return new AdapterViewHolder(itemView,onClickInterface);
    }

    public ItemAdapter(Context context, OnClickInterface onClickInterface, ArrayList<ItemListModel> itemList) {
        this.context = context;
        this.onClickInterface = onClickInterface;
        this.itemList = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.textView1.setText(itemList.get(position).getItemTitle());
        holder.image1.setImageDrawable(itemList.get(position).getItemImage());
        if (position == itemList.size()-1) {
            holder.divider.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
