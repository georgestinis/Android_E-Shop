package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class QueryFragment extends Fragment {
    TextView queryTextView, querytextresult;
    Button bnqueryrun;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    int test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        queryTextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinnerquery);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queryTextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytextresult.setText("test" + test);
                String result = "";
                switch (test) {
                    case 1:
                        List<ResultStringInt> quantities = MainActivity3.myAppDatabase.myDao().getQuantity();
                        for (ResultStringInt i : quantities) {
                            String product = i.getField1();
                            int quantity = i.getField2();
                            result = result + "\n Product Name: " + product + "\n Quantity: " + quantity;
                        }
                        querytextresult.setText(result);
                        break;
                    case 2:
                        int sales = MainActivity3.myAppDatabase.myDao().getCountSales();
                        result = result + "Sales: " + sales;
                        querytextresult.setText(result);
                        break;
                    case 3:
                        List<ResultTwoInts> salesPerProduct = MainActivity3.myAppDatabase.myDao().getSalesPerProduct();
                        for (ResultTwoInts i : salesPerProduct) {
                            int product = i.getField1();
                            int sale = i.getField2();
                            result = result + "\n Product Id: " + product + "\n Sales: " + sale;
                        }
                        querytextresult.setText(result);
                        break;
                    case 4:
                        List<Product> products = MainActivity3.myAppDatabase.myDao().getProducts();
                        for (Product i : products) {
                            int p_id = i.getId();
                            String p_name = i.getName();
                            float price = i.getPrice();
                            int p_quantity = i.getQuantity();
                            String p_description = i.getDescription();
                            result = result + "\n Product Id: " + p_id + "\n Product Name: " + p_name + "\n Price: " + price + "\n Quantity: " + p_quantity + "\n Description: " + p_description;
                        }
                        querytextresult.setText(result);
                        break;
                    case 5:
                        List<User> users = MainActivity3.myAppDatabase.myDao().getUsers();
                        for (User i : users) {
                            String username = i.getUsername();
                            String password = i.getPassword();
                            String u_name = i.getName();
                            String surname = i.getSurname();
                            String address = i.getAddress();
                            String type = i.getType();
                            result = result + "\n Username: " + username + "\n Password: " + password + "\n Name: " + u_name + "\n Surname: " + surname + "\n Address: " + address + "\n Type: " + type;
                        }
                        querytextresult.setText(result);
                        break;
                    case 6:
                        List<Sale> sales1 = MainActivity3.myAppDatabase.myDao().getSales();
                        for (Sale i : sales1) {
                            int s_id = i.getId();
                            String u_username = i.getUser_username();
                            int p_id = i.getProduct_id();
                            int p_quantity = i.getQuantity();
                            result = result + "\n Id: " + s_id + "\n Username: " + u_username + "\n Product Id: " + p_id + "\n Product Quantity: " + p_quantity;
                        }
                        querytextresult.setText(result);
                        break;
                    case 7:
                        List<Cart> cart = MainActivity3.myAppDatabase.myDao().getCart();
                        for (Cart i : cart) {
                            String u_username = i.getUser_username();
                            int p_id = i.getProduct_id();
                            int p_quantity = i.getQuantity();
                            result = result + "\n Username: " + u_username + "\n Product Id: " + p_id + "\n Product Quantity: " + p_quantity;
                        }
                        querytextresult.setText(result);
                        break;
                }
            }
        });
        return view;
    }
}