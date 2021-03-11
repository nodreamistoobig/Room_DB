package com.example.room_db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, Category.class, category_product.class}, version = 1)
public abstract class DB extends RoomDatabase {
    abstract ManagerDB manager();
    private static final String DB_NAME="products.db";
    private static DB INSTANCE=null;


    synchronized static DB get(Context cntx){
        if (INSTANCE==null) {
            INSTANCE=create(cntx, false);
        }
        return(INSTANCE);
    }

    static DB create(Context cntx, boolean memoryOnly){
        RoomDatabase.Builder<DB> b;
        if (memoryOnly) {
            b = Room.inMemoryDatabaseBuilder(cntx.getApplicationContext(),DB.class);
        }
        else {
            b=Room.databaseBuilder(cntx.getApplicationContext(), DB.class, DB_NAME);
        }
        return(b.build());
    }
}
