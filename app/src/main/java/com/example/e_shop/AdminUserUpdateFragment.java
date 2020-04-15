package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUserUpdateFragment extends Fragment {
    private EditText username, password, name, surname, type, address;
    private Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_user_update, container, false);
        username = view.findViewById(R.id.admin_user_update_username);
        password = view.findViewById(R.id.admin_user_update_password);
        name = view.findViewById(R.id.admin_user_update_name);
        surname = view.findViewById(R.id.admin_user_update_surname);
        type = view.findViewById(R.id.admin_user_update_type);
        address = view.findViewById(R.id.admin_user_update_address);
        submit = view.findViewById(R.id.submitUserUpdate);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User user = new User(username.getText().toString(), password.getText().toString(),
                            name.getText().toString(), surname.getText().toString(),
                            address.getText().toString(), type.getText().toString());
                    MainActivity3.myAppDatabase.myDao().updateUser(user);
                    Toast.makeText(getActivity(), "Η ενημέρωση έγινε", Toast.LENGTH_LONG).show();
                    username.setText("");
                    password.setText("");
                    name.setText("");
                    surname.setText("");
                    address.setText("");
                    type.setText("");
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}