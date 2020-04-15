package com.example.e_shop;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sales",
        foreignKeys = {
                @ForeignKey(entity = User.class, parentColumns = "username",
                        childColumns = "user_username",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = Product.class, parentColumns = "id",
                        childColumns = "product_id",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        },
        indices = {@Index("user_username"), @Index("product_id")})
public class Sale {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String user_username;
    private int product_id;
    private int quantity;

    @Ignore
    public Sale() {
    }

    @Ignore
    public Sale(int id, String user_username, int product_id, int quantity) {
        this.id = id;
        this.user_username = user_username;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public Sale(String user_username, int product_id, int quantity) {
        this.user_username = user_username;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
