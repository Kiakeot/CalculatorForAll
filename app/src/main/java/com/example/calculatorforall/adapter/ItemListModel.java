package com.example.calculatorforall.adapter;

import android.graphics.drawable.Drawable;

public class ItemListModel {
    private String itemTitle;
    private Drawable itemImage;

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Drawable getItemImage() {
        return itemImage;
    }

    public void setItemImage(Drawable itemImage) {
        this.itemImage = itemImage;
    }

    public ItemListModel(String itemTitle, Drawable itemImage) {
        this.itemTitle = itemTitle;
        this.itemImage = itemImage;
    }
}
