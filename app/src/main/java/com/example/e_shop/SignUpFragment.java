package com.example.e_shop;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpFragment extends Fragment {
    private Button bck_to_login, signup_btn;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;
    private EditText username, pass, name, surname, address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.user_type, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner = view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        bck_to_login = view.findViewById(R.id.bck_to_login_btn);
        signup_btn = view.findViewById(R.id.register_btn);
        username = view.findViewById(R.id.signup_username);
        pass = view.findViewById(R.id.signup_password);
        name = view.findViewById(R.id.signup_name);
        surname = view.findViewById(R.id.signup_surname);
        address = view.findViewById(R.id.signup_address);
        bck_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
            }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.myAppDatabase.myDao().addUser(new User(username.getText().toString(), pass.getText().toString(), name.getText().toString(),
                            surname.getText().toString(), address.getText().toString(), spinner.getSelectedItem().toString()));
                    username.setText("");
                    pass.setText("");
                    name.setText("");
                    surname.setText("");
                    address.setText("");
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

}