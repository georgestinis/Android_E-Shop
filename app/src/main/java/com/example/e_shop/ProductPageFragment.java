package com.example.e_shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductPageFragment extends Fragment {
    Product product;
    Button add_to_cart;
    TextView description, price, quantity, name;
    EditText wanted_quantity;

    public ProductPageFragment(Product product) {
        this.product = product;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_page, container, false);
        name = view.findViewById(R.id.p_page_name);
        add_to_cart = view.findViewById(R.id.add_to_cart_btn);
        description = view.findViewById(R.id.p_page_description);
        price = view.findViewById(R.id.p_page_price);
        quantity = view.findViewById(R.id.p_page_quantity);
        wanted_quantity = view.findViewById(R.id.p_page_quantity_wanted);
        name.setText(product.getName());
        description.setText(product.getDescription());
        price.setText(product.getPrice() + "");
        quantity.setText("/" + product.getQuantity());
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q = 0;
                try {
                    q = Integer.parseInt(wanted_quantity.getText().toString());
                } catch (NumberFormatException ex) {
                    Toast.makeText(getActivity(), "Ζητείται αριθμός στην ποσότητα", Toast.LENGTH_LONG).show();
                }
                if (q > product.getQuantity() || q < 1) {
                    Toast.makeText(getActivity(), "Ζητείται αριθμός στην ποσότητα μικρότερος από το απόθεμα και μεγαλύτερος από το 0", Toast.LENGTH_LONG).show();
                } else {

                    try {
                        Cart cart = new Cart(MainActivity2.user.getUsername(), product.getId(), q);
                        MainActivity2.myAppDatabase.myDao().addCart(cart);
                        Toast.makeText(getActivity(), "Προσθέθηκε στο καλάθι", Toast.LENGTH_LONG).show();
                        wanted_quantity.setText("1");
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return view;
    }
}