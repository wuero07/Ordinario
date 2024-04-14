package com.example.amoto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button motosButton = findViewById(R.id.motosButton);
        Button cascosButton = findViewById(R.id.cascosButton);
        Button refaccionesButton = findViewById(R.id.refaccionesButton);

        motosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SelectedProductsActivity.class);
                intent.putExtra("category", "motos");
                startActivity(intent);
            }
        });

        cascosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SelectedProductsActivity.class);
                intent.putExtra("category", "cascos");
                startActivity(intent);
            }
        });

        refaccionesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, SelectedProductsActivity.class);
                intent.putExtra("category", "refacciones");
                startActivity(intent);
            }
        });
    }
}


