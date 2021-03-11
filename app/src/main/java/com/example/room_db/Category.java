package com.example.room_db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categories")
public class Category {
    @PrimaryKey
    @NonNull
    int _id;
    @NonNull
    String name;

    public Category(int _id, @NonNull String name) {
        this._id = _id;
        this.name = name;
    }
}
