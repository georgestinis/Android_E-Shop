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

public class LoginFragment extends Fragment {
    private Button go_to_signup, login;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        go_to_signup = view.findViewById(R.id.signup_btn);
        login = view.findViewById(R.id.login_btn);
        go_to_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SignUpFragment()).commit();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), MainActivity2.class);
                Intent i = new Intent(getActivity(), MainActivity3.class);
//                Einai gia na katharizei to proigoymeno activity

//                TODO - Na metafero antikeimeno toy user
//                Bundle bundle = new Bundle();
//                bundle.putInt("result", res);
//                i.putExtras(bundle);
                startActivity(i);
            }
        });
        return view;
    }


}