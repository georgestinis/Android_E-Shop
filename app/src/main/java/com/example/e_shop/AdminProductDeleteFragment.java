package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminProductDeleteFragment extends Fragment {
    private EditText id;
    private Button delete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_product_delete, container, false);
        id = view.findViewById(R.id.admin_product_delete_id);
        delete = view.findViewById(R.id.deleteProduct);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_id = 0;
                try {
                    var_id = Integer.parseInt(id.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                try {
                    Product product = new Product();
                    product.setId(var_id);
                    MainActivity3.myAppDatabase.myDao().deleteProduct(product);
                    Toast.makeText(getActivity(), "Έγινε η διαγραφή", Toast.LENGTH_LONG).show();
                    id.setText("");
                } catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}