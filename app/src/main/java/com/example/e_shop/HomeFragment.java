package com.example.e_shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    EditText username, name, surname, address;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        username = view.findViewById(R.id.customer_username);
        name = view.findViewById(R.id.customer_name);
        surname = view.findViewById(R.id.customer_surname);
        address = view.findViewById(R.id.customer_address);
        username.setText(MainActivity2.user.getUsername());
        username.setEnabled(false);
        name.setText(MainActivity2.user.getName());
        name.setEnabled(false);
        surname.setText(MainActivity2.user.getSurname());
        surname.setEnabled(false);
        address.setText(MainActivity2.user.getAddress());
        address.setEnabled(false);
        return view;
    }
}
