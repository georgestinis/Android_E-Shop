package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminCartDeleteFragment extends Fragment {
    private EditText username, pid;
    private Button delete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_cart_delete, container, false);
        username = view.findViewById(R.id.admin_cart_delete_username);
        pid = view.findViewById(R.id.admin_cart_delete_pid);
        delete = view.findViewById(R.id.deleteCart);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Cart cart = new Cart();
                    cart.setUser_username(username.getText().toString());
                    int id = 0;
                    try {
                        id = Integer.parseInt(pid.getText().toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Could not parse");
                    }
                    cart.setProduct_id(id);
                    MainActivity3.myAppDatabase.myDao().deleteCart(cart);
                    Toast.makeText(getActivity(), "Έγινε η διαγραφή", Toast.LENGTH_LONG).show();
                    username.setText("");
                    pid.setText("");
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}