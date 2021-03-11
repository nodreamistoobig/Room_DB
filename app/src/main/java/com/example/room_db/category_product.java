package com.example.room_db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_products")
public class category_product {
    @PrimaryKey
    int _id;
    @NonNull
    int product_id, category_id;

    public void category_product(int product_id, int category_id){
        this.category_id = category_id;
        this.product_id = product_id;
    }
}
