package com.example.e_shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private Button go_to_signup, login;
    private EditText username, password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        go_to_signup = view.findViewById(R.id.signup_btn);
        login = view.findViewById(R.id.login_btn);
        username = view.findViewById(R.id.login_name);
        password = view.findViewById(R.id.login_pwd);
        go_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SignUpFragment()).commit();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User user = MainActivity.myAppDatabase.myDao().getUser(username.getText().toString(), password.getText().toString());
                    if (user.getType().equals("Customer")) {
                        Intent i = new Intent(getActivity(), MainActivity2.class);
                        i.putExtra("userobject", user);
                        startActivity(i);
                    } else if (user.getType().equals("Admin")) {
                        Intent i = new Intent(getActivity(), MainActivity3.class);
                        startActivity(i);
                    }
                    username.setText("");
                    password.setText("");
                } catch (NullPointerException ex) {
                    Toast.makeText(getActivity(), "Λάθος κωδικός ή username", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });
        return view;
    }


}