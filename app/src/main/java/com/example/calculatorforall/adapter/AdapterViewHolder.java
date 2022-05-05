package com.example.calculatorforall.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatorforall.R;

public class AdapterViewHolder extends RecyclerView.ViewHolder {
    TextView textView1;
    ImageView image1;
    View divider;
    public AdapterViewHolder(@NonNull View itemView,OnClickInterface onClickInterface) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.TextView1);
        image1 = itemView.findViewById(R.id.image1);
        divider = itemView.findViewById(R.id.divider);
        itemView.setOnClickListener(view -> {
            if(onClickInterface != null){
             int position = getAdapterPosition();
             onClickInterface.onItemClick(position);
            }
        });
    }
}
