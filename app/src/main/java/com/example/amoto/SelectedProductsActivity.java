package com.example.amoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SelectedProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_products);


        String category = getIntent().getStringExtra("category");


        final List<Product> products = loadProductsForCategory(category);


        showProducts(products);


        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Product selectedProduct = products.get(position);


                Intent intent = new Intent(SelectedProductsActivity.this, ProductDetailActivity.class);
                intent.putExtra("product", selectedProduct);
                startActivity(intent);
            }
        });


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private List<Product> loadProductsForCategory(String category) {
        List<Product> products = new ArrayList<>();
        if (category.equals("motos")) {
            products.add(new Product("Motocicleta 1", 1000.0, "velocidad 150 km/h " +
                    "color rojo" ,R.drawable.moto1));
            products.add(new Product("Motocicleta 2", 1500.0, "velocidad 200 km/h" +
                    "color verde" , R.drawable.moto2));
            products.add(new Product("Motocicleta 3", 2000.0, "velocidad 300 km/h" +
                    "color negro" , R.drawable.moto3));
        } else if (category.equals("cascos")) {
            products.add(new Product("Casco 1", 50.0, "certificado dot " + "acolchado " + "talla s " , R.drawable.casco1));
            products.add(new Product("Casco 2", 75.0, "certificado dot " + "ventilacion " + "talla m " , R.drawable.casco2));
            products.add(new Product("Casco 3", 100.0, "certificado dot " + "talla l " + "abatible " , R.drawable.casco3));
        } else if (category.equals("refacciones")) {
            products.add(new Product("neumatico", 25.0, "Descripción de la Refacción " , R.drawable.refraccion1));
            products.add(new Product("cadena", 50.0, "cadena dorada resistente " ,R.drawable.refraccion2));
            products.add(new Product("escape", 75.0, "escape racing " + "fibra de carbono ", R.drawable.refraccion3));
        }
        return products;
    }

    private void showProducts(List<Product> products) {

        ListView listView = findViewById(R.id.listView);
        List<String> productDetails = new ArrayList<>();
        for (Product product : products) {
            String productDetail = product.getName() + " - Precio: $" + product.getPrice();
            productDetails.add(productDetail);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productDetails);
        listView.setAdapter(adapter);
    }
}


