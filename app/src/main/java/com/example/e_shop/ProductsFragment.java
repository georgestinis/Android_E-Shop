package com.example.e_shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {
    ListView listView;
    ListAdapter listAdapter;
    List<Product> products = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        getProducts();
        listView = view.findViewById(R.id.my_list_view);
        listAdapter = new ListAdapter(getActivity(), products);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listView.getItemAtPosition(position) instanceof Product) {
                    Product product = (Product) (listView.getItemAtPosition(position));
                    MainActivity2.fragmentManager.beginTransaction().replace(R.id.fragment_container2, new ProductPageFragment(product)).addToBackStack(null).commit();
                }
            }
        });
        return view;
    }

    private void getProducts() {
        products = MainActivity2.myAppDatabase.myDao().getProducts();
    }
}
