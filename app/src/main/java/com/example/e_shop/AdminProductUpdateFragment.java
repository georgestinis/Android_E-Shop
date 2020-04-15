package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminProductUpdateFragment extends Fragment {
    private EditText id, name, price, quantity, description;
    private Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_product_update, container, false);
        id = view.findViewById(R.id.admin_product_update_id);
        name = view.findViewById(R.id.admin_product_update_name);
        price = view.findViewById(R.id.admin_product_update_price);
        quantity = view.findViewById(R.id.admin_product_update_quantity);
        description = view.findViewById(R.id.admin_product_update_description);
        submit = view.findViewById(R.id.submitProductUpdate);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_id = 0;
                try {
                    var_id = Integer.parseInt(id.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                float var_price = 0;
                try {
                    var_price = Float.parseFloat(price.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int var_quantity = 0;
                try {
                    var_quantity = Integer.parseInt(quantity.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                try {
                    Product product = new Product(var_id, name.getText().toString(), var_price, var_quantity, description.getText().toString());
                    MainActivity3.myAppDatabase.myDao().updateProduct(product);
                    Toast.makeText(getActivity(), "Η ενημέρωση έγινε", Toast.LENGTH_LONG).show();
                    id.setText("");
                    name.setText("");
                    price.setText("");
                    quantity.setText("");
                    description.setText("");
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}