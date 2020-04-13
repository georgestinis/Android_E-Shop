package com.example.e_shop;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addUser(User user);

    @Insert
    public void addProduct(Product product);

    @Insert
    public void addCart(Cart cart);

    @Insert
    public void addSale(Sale sale);

    @Delete
    public void deleteUser(User user);

    @Delete
    public void deleteProduct(Product product);

    @Delete
    public void deleteCart(Cart cart);

    @Delete
    public void deleteSale(Sale sale);

    @Update
    public void updateUser(User user);

    @Update
    public void updateProduct(Product product);

    @Update
    public void updateCart(Cart cart);

    @Update
    public void updateSale(Sale sale);

    @Query("SELECT name as field1, quantity as field2 FROM Products")
    public List<ResultStringInt> getQuantity();

    @Query("SELECT COUNT(*) FROM Sales")
    public int getCountSales();

    @Query("SELECT product_id as field1, COUNT(*) as field2 FROM Sales GROUP BY product_id")
    public List<ResultTwoInts> getSalesPerProduct();

    @Query("SELECT * FROM Products")
    public List<Product> getProducts();

    @Query("SELECT * FROM Users")
    public List<User> getUsers();

    @Query("SELECT * FROM Sales")
    public List<Sale> getSales();

    @Query("SELECT * FROM Cart")
    public List<Cart> getCart();

}
