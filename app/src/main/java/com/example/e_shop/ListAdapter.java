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

public class ListAdapter extends ArrayAdapter<Product> {
    List<Product> products = new ArrayList<>();
    Context context;
    public ListAdapter(Context context, List<Product> products){
        super(context, R.layout.element_layout, products);
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.element_layout, parent, false);
        TextView p_id = row.findViewById(R.id.p_id);
        TextView p_name = row.findViewById(R.id.p_name);
        TextView p_price = row.findViewById(R.id.p_price);
        Product product = products.get(position);
        p_id.setText(product.getId()+"");
        p_name.setText(product.getName());
        p_price.setText(product.getPrice()+"");
        return row;
    }
}
