package com.example.corte2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.bumptech.glide.Glide;

public class splash extends AppCompatActivity {
    public static final String dataUserCache = "userData";
    private static final int modo_private = Context.MODE_PRIVATE;
    String nombre, edad, categoria;
    ImageView gif_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        gif_img = findViewById(R.id.gif_img);
        Glide.with(this).load(R.drawable.fondogif).into(gif_img);


        validarLogin();

        }

    private void validarLogin() {
        nombre = getApplicationContext().getSharedPreferences(dataUserCache, modo_private).getString("nombre", "");
        edad = getApplicationContext().getSharedPreferences(dataUserCache, modo_private).getString("edad", "");
        categoria = getApplicationContext().getSharedPreferences(dataUserCache, modo_private).getString("categoria", "");

        new Handler().postDelayed(() -> {
            if (!nombre.isEmpty() && !edad.isEmpty() && !categoria.isEmpty()) {
                Intent i = new Intent(splash.this, Login.class);
                startActivity(i);
            } else {
                Intent i = new Intent(splash.this, Login.class);
                startActivity(i);
            }
            finish();
        }, 2000);
    }

}
