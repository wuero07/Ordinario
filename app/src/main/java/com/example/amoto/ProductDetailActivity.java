package com.example.amoto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashSet;
import java.util.Set;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("product")) {
            final Product product = (Product) intent.getSerializableExtra("product");

            if (product != null) {
                TextView productNameTextView = findViewById(R.id.productName);
                TextView productDescriptionTextView = findViewById(R.id.productDescription);
                ImageView productImageView = findViewById(R.id.productImage);
                final EditText quantityEditText = findViewById(R.id.quantity);

                productNameTextView.setText(product.getName());
                productDescriptionTextView.setText(product.getDescription());
                productImageView.setImageResource(product.getImageResource());

                Button addToCartButton = findViewById(R.id.addToCartButton);
                addToCartButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            int newQuantity = Integer.parseInt(quantityEditText.getText().toString());
                            product.setQuantity(product.getQuantity() + newQuantity);

                            // Guardar el producto en el carrito usando SharedPreferences
                            SharedPreferences sharedPreferences = getSharedPreferences("Cart", MODE_PRIVATE);
                            Set<String> cartSet = sharedPreferences.getStringSet("cartProducts", new HashSet<String>());
                            cartSet.add(product.getName());
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putStringSet("cartProducts", cartSet);
                            editor.apply();

                            // Ir a la actividad de finalización de pedido
                            Intent finishOrderIntent = new Intent(ProductDetailActivity.this, FinishOrderActivity.class);
                            startActivity(finishOrderIntent);
                        } catch (NumberFormatException e) {
                            // Manejar la excepción, por ejemplo, mostrando un mensaje al usuario
                            Toast.makeText(ProductDetailActivity.this, "Por favor, ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }
}




