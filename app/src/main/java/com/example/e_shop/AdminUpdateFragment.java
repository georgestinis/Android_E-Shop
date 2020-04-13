package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AdminUpdateFragment extends Fragment implements View.OnClickListener {
    Button user, product, cart, sale;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_update, container, false);
        user = view.findViewById(R.id.admin_user_update);
        product = view.findViewById(R.id.admin_product_update);
        cart = view.findViewById(R.id.admin_cart_update);
        sale = view.findViewById(R.id.admin_sale_update);
        user.setOnClickListener(this);
        product.setOnClickListener(this);
        cart.setOnClickListener(this);
        sale.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin_user_update:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminUserUpdateFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_product_update:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminProductUpdateFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_cart_update:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminCartUpdateFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_sale_update:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminSaleUpdateFragment()).addToBackStack(null).commit();
                break;
        }
    }
}