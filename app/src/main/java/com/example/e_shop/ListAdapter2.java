package com.example.e_shop;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter2 extends ArrayAdapter<Cart> {
    List<Cart> carts = new ArrayList<>();
    Context context;

    public ListAdapter2(Context context, List<Cart> carts){
        super(context, R.layout.element_layout, carts);
        this.context = context;
        this.carts = carts;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.element_layout2, parent, false);
        TextView c_pid = row.findViewById(R.id.c_pid);
        TextView c_quantity = row.findViewById(R.id.c_quantity);
        TextView c_price = row.findViewById(R.id.c_price);
        Cart cart = carts.get(position);
        c_pid.setText(cart.getProduct_id()+"");
        c_quantity.setText(cart.getQuantity()+"");
        float price = MainActivity2.myAppDatabase.myDao().getProduct(cart.getProduct_id()).getPrice();
        c_price.setText((price*cart.getQuantity())+"");
        return row;
    }

}
