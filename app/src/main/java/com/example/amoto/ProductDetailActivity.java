
package com.example.amoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.Serializable;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {


    private List<Product> cartProducts = new ArrayList<>();

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

                        int newQuantity = Integer.parseInt(quantityEditText.getText().toString());
                        product.setQuantity(product.getQuantity() + newQuantity);


                        cartProducts.add(product);


                        Intent finishOrderIntent = new Intent(ProductDetailActivity.this, FinishOrderActivity.class);
                        finishOrderIntent.putExtra("cartProducts", (Serializable) cartProducts);
                        startActivity(finishOrderIntent);
                    }
                });
            }
        }

        // Configura el botón de regresar
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}

