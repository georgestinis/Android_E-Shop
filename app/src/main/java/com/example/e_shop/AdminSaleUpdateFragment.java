package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminSaleUpdateFragment extends Fragment {
    private EditText id, username, p_id, quantity;
    private Button submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_sale_update, container, false);
        id = view.findViewById(R.id.admin_sale_update_id);
        username = view.findViewById(R.id.admin_sale_update_username);
        p_id = view.findViewById(R.id.admin_sale_update_product_id);
        quantity = view.findViewById(R.id.admin_sale_update_quantity);
        submit = view.findViewById(R.id.submitSaleUpdate);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_id = 0;
                try {
                    var_id = Integer.parseInt(id.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                int var_pid = 0;
                try {
                    var_pid = Integer.parseInt(p_id.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                int var_quantity = 0;
                try {
                    var_quantity = Integer.parseInt(quantity.getText().toString());
                } catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                try {
                    Sale sale = new Sale(var_id, username.getText().toString(), var_pid, var_quantity);
                    MainActivity3.myAppDatabase.myDao().updateSale(sale);
                    Toast.makeText(getActivity(), "Η ενημέρωση έγινε", Toast.LENGTH_LONG).show();
                    username.setText("");
                    id.setText("");
                    p_id.setText("");
                    quantity.setText("");
                } catch (Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}