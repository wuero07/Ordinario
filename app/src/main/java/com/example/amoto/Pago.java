package com.example.amoto;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pago extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);


        SharedPreferences sharedPreferences = getSharedPreferences("Cart", MODE_PRIVATE);
        Set<String> cartSet = sharedPreferences.getStringSet("cartProducts", new HashSet<>());
        ArrayList<String> cartProducts = new ArrayList<>(cartSet);


        TextView itemListTextView = findViewById(R.id.itemListTextView);
        TextView totalTextView = findViewById(R.id.totalTextView);
        StringBuilder productListText = new StringBuilder();
        double total = 0.0;

        for (String productName : cartProducts) {

            double price = getPriceForProduct(productName);
            total += price;


            productListText.append(productName).append(" - Precio: $").append(price).append("\n");
        }
        itemListTextView.setText(productListText.toString());


        totalTextView.setText("Total: $" + total);

        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearCart();
            }
        });
    }


    private double getPriceForProduct(String productName) {

        return Product.getPriceForProduct(productName);
    }


    private void clearCart() {
        SharedPreferences sharedPreferences = getSharedPreferences("Cart", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}




