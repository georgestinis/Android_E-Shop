package com.example.e_shop;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Product.class, Cart.class, Sale.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
