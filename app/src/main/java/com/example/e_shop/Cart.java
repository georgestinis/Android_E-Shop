package com.example.e_shop;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;

@Entity(tableName = "Cart",
        primaryKeys = {"user_username", "product_id"},
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
public class Cart {
    @NonNull
    private String user_username;
    @NonNull
    private int product_id;
    private int quantity;

    @Ignore
    public Cart() {
    }

    public Cart(@NonNull String user_username, int product_id, int quantity) {
        this.user_username = user_username;
        this.product_id = product_id;
        this.quantity = quantity;
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
