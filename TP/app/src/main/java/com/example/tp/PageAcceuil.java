package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageAcceuil extends AppCompatActivity {

    Button englishButton;
    Button frenchButton;
    Button spanishButton;
    Button italianButton;
    Button germanButton;
    Button dutchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        englishButton = (Button) findViewById(R.id.englishButton);
        frenchButton = (Button) findViewById(R.id.frenchButton);
        spanishButton = (Button) findViewById(R.id.spanishButton);
        italianButton = (Button) findViewById(R.id.italianButton);
        germanButton = (Button) findViewById(R.id.germanButton);
        dutchButton = (Button) findViewById(R.id.dutchButton);
        Intent intent = new Intent(this, Main.class);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "en-US");
                startActivity(intent);
            }
        });

        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "es-ES");
                startActivity(intent);
            }
        });
        italianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "it-IT");
                startActivity(intent);
            }
        });
        germanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "de-DE");
                startActivity(intent);
            }
        });
        dutchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "nl-BE");
                startActivity(intent);
            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("language", "fr-FR");
                startActivity(intent);
            }
        });
    }
}