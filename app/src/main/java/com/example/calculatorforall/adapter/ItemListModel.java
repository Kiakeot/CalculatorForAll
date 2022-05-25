package com.example.calculatorforall.adapter;

import android.graphics.drawable.Drawable;

public class ItemListModel {
    private String itemTitle;
    private Drawable itemImage;
    private int id;

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

//    public ItemListModel(String itemTitle, Drawable itemImage) {
//        this.itemTitle = itemTitle;
//        this.itemImage = itemImage;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemListModel(int id , String itemTitle, Drawable itemImage) {
        this.itemTitle = itemTitle;
        this.itemImage = itemImage;
        this.id = id;
    }
}
