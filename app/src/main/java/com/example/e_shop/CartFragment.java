package com.example.e_shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    ListView listView;
    ListAdapter2 listAdapter;
    List<Cart> carts = new ArrayList<>();
    TextView total_price;
    Button checkout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        getCarts();
        total_price = view.findViewById(R.id.total_price);
        listView = view.findViewById(R.id.my_list_view_cart);
        listAdapter = new ListAdapter2(getActivity(), carts);
        listView.setAdapter(listAdapter);
        float price = 0;
        for (Cart cart : carts) {
            Product product = MainActivity2.myAppDatabase.myDao().getProduct(cart.getProduct_id());
            price += product.getPrice() * cart.getQuantity();
            product.setQuantity(product.getQuantity() - cart.getQuantity());
            MainActivity2.myAppDatabase.myDao().updateProduct(product);
        }
        total_price.setText("Total Price: " + price + "€");
        checkout = view.findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carts.isEmpty()) {
                    return;
                }
                for (Cart cart : carts) {
                    try {
                        Sale sale = new Sale(cart.getUser_username(), cart.getProduct_id(), cart.getQuantity());
                        MainActivity2.myAppDatabase.myDao().addSale(sale);
                        MainActivity2.myAppDatabase.myDao().deleteCart(cart);
                        MainActivity2.fragmentManager.beginTransaction().replace(R.id.fragment_container2,
                                new CartFragment()).commit();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
                Toast.makeText(getActivity(), "Η αγορά ολοκληρώθηκε", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private void getCarts() {
        carts = MainActivity2.myAppDatabase.myDao().getCart();
    }
}
