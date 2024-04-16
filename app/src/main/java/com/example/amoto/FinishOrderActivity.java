package com.example.amoto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Set;

public class FinishOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);

        // Obtener los productos del carrito de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("Cart", MODE_PRIVATE);
        Set<String> cartSet = sharedPreferences.getStringSet("cartProducts", null);
        ArrayList<String> cartProducts = new ArrayList<>();
        if (cartSet != null) {
            cartProducts.addAll(cartSet);
        }


        showCartProducts(cartProducts);


        Button selectAnotherProductButton = findViewById(R.id.selectAnotherProductButton);
        selectAnotherProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menuIntent = new Intent(FinishOrderActivity.this, MainMenuActivity.class);
                startActivity(menuIntent);
            }
        });


        Button finishOrderButton = findViewById(R.id.finishOrderButton);
        finishOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paymentIntent = new Intent(FinishOrderActivity.this, Pago.class);
                startActivity(paymentIntent);
            }
        });
    }


    private void showCartProducts(ArrayList<String> cartProducts) {

        TextView itemListTextView = findViewById(R.id.itemListTextView);

        if (itemListTextView != null && !cartProducts.isEmpty()) {

            StringBuilder productListText = new StringBuilder();
            for (String product : cartProducts) {
                productListText.append("Producto: ").append(product).append("\n");
            }

            itemListTextView.setText(productListText.toString());
        } else {

            itemListTextView.setText("No hay productos en el carrito");
        }
    }
}


