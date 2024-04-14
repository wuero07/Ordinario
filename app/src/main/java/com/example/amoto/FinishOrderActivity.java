package com.example.amoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.List;

public class FinishOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);

        // Recibe la lista de productos del intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("cartProducts")) {
            List<Product> cartProducts = (List<Product>) intent.getSerializableExtra("cartProducts");

            // Muestra los detalles de los productos y el total
            showCartProducts(cartProducts);
        }


        Button finishOrderButton = findViewById(R.id.finishOrderButton);
        finishOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button selectAnotherProductButton = findViewById(R.id.selectAnotherProductButton);
        selectAnotherProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(FinishOrderActivity.this, SelectedProductsActivity.class);
                startActivity(menuIntent);
            }
        });
    }

    // mostrar los productos en el carrito y calcular el total
    private void showCartProducts(List<Product> cartProducts) {
        double total = 0;
        StringBuilder productsText = new StringBuilder();
        for (Product product : cartProducts) {
            productsText.append("Product: ").append(product.getName()).append(", Quantity: ").append(product.getQuantity()).append("\n");
            total += product.getPrice() * product.getQuantity();
        }
        TextView cartTextView = findViewById(R.id.cartTextView);
        cartTextView.setText(productsText.toString());

        // Muestra el total
        TextView totalPriceTextView = findViewById(R.id.totalPrice);
        totalPriceTextView.setText("Total: $" + total);
    }
}


