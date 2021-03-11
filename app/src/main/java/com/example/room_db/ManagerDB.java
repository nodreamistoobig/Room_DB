package com.example.room_db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
interface ManagerDB {
    @Query("SELECT _id FROM products ORDER BY _id DESC")
    int selectLastIndex();

    @Query("SELECT * FROM products ORDER BY _id")
    List<Product> selectAllProd();

    @Query("SELECT * FROM categories ORDER BY _id")
    List<Category> selectAllCat();

    @Query("SELECT * FROM products as p, category_products as cp WHERE  p._id = cp.product_id AND cp.category_id = :index")
    List<Product> selectByCategory(int index);

    @Query("SELECT _id, name, author, price FROM products WHERE _id = :id")
    Product selectById(int id);

    @Insert
    void insert(Product... products);

    @Delete
    void delete(Product... products);

    @Update
    void update(Product... products);
}