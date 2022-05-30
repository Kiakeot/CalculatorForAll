package com.example.calculatorforall.adapter;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorforall.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<AdapterViewHolder> {
private final Context context;
private final OnClickInterface onClickInterface;
private  ArrayList<ItemListModel> itemList;
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

    public void setItemList(ArrayList<ItemListModel> itemList){
        if (this.itemList == null){
            this.itemList = itemList;
        }else{
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return ItemAdapter.this.itemList.size();
                }

                @Override
                public int getNewListSize() {
                    return itemList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return ItemAdapter.this.itemList.get(oldItemPosition).getItemTitle().equals(itemList.get(newItemPosition).getItemTitle());
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ItemListModel newItems = ItemAdapter.this.itemList.get(oldItemPosition);

                    ItemListModel oldItems = itemList.get(newItemPosition);

                    return oldItems.getItemTitle().equals(newItems.getItemTitle());
                }
            });
            this.itemList = itemList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.textView1.setText(itemList.get(position).getItemTitle());
        holder.image1.setImageDrawable(itemList.get(position).getItemImage());
//        holder.textView1.setMovementMethod(new ScrollingMovementMethod());
        holder.textView1.setSelected(true);
        if (position == itemList.size()-1) {
            holder.divider.setVisibility(View.GONE);
        }
        holder.rootContainer.setOnClickListener(view -> {
            onClickInterface.onItemClick(itemList.get(position).getId());
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
