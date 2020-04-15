package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUserDeleteFragment extends Fragment {
    private EditText username;
    private Button delete;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_admin_user_delete, container, false);
        username = view.findViewById(R.id.admin_user_delete_username);
        delete = view.findViewById(R.id.deleteUser);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    User user = new User();
                    user.setUsername(username.getText().toString());
                    MainActivity3.myAppDatabase.myDao().deleteUser(user);
                    Toast.makeText(getActivity(), "Έγινε η διαγραφή", Toast.LENGTH_LONG).show();
                    username.setText("");
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}