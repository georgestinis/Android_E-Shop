package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AdminDeleteFragment extends Fragment implements View.OnClickListener {
    Button user, product, cart, sale;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_delete, container, false);
        user = view.findViewById(R.id.admin_user_delete);
        product = view.findViewById(R.id.admin_product_delete);
        cart = view.findViewById(R.id.admin_cart_delete);
        sale = view.findViewById(R.id.admin_sale_delete);
        user.setOnClickListener(this);
        product.setOnClickListener(this);
        cart.setOnClickListener(this);
        sale.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.admin_user_delete:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminUserDeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_product_delete:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminProductDeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_cart_delete:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminCartDeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_sale_delete:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminSaleDeleteFragment()).addToBackStack(null).commit();
                break;
        }
    }
}