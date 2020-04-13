package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AdminHomeFragment extends Fragment implements View.OnClickListener {
    Button insert, delete, update, query;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adminhome, container, false);
        insert = view.findViewById(R.id.admin_insert);
        delete = view.findViewById(R.id.admin_delete);
        update = view.findViewById(R.id.admin_update);
        query = view.findViewById(R.id.admin_query);
        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        query.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.admin_insert:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminInsertFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_delete:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminDeleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_update:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new AdminUpdateFragment()).addToBackStack(null).commit();
                break;
            case R.id.admin_query:
                MainActivity3.fragmentManager.beginTransaction().replace(R.id.fragment_container3, new QueryFragment()).addToBackStack(null).commit();
                break;
        }
    }
}