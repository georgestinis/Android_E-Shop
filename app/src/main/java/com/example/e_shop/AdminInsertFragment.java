package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AdminInsertFragment extends Fragment implements View.OnClickListener {
    Button user, product, cart, sale;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_insert, container, false);
        user = view.findViewById(R.id.admin_user_insert);
        product = view.findViewById(R.id.admin_product_insert);
        cart = view.findViewById(R.id.admin_cart_insert);
        sale = view.findViewById(R.id.admin_sale_insert);
        user.setOnClickListener(this);
        product.setOnClickListener(this);
        cart.setOnClickListener(this);
        sale.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin_user_insert:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminUserInsertFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_product_insert:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminProductInsertFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_cart_insert:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminCartInsertFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_sale_insert:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminSaleInsertFragment()).addToBackStack(null).commit();
                break;
        }
    }
}