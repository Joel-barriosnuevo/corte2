package com.example.corte2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class deporte extends AppCompatActivity {

    private static final String TAG = "Cine";
    private TextView mainNombre;
    private TextView mainEdad;
    private TextView mainCategoria;
    public static final String DATA_USER_CACHE = "userData";
    private static final int MODO_PRIVATE = Context.MODE_PRIVATE;
    private String nombre;
    private String edad;
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cine);

        mainNombre = findViewById(R.id.mainNombre);
        mainEdad = findViewById(R.id.mainEdad);
        mainCategoria = findViewById(R.id.mainCategoria);

        SharedPreferences sharedPreferences = null;
        try {
            sharedPreferences = getApplicationContext().getSharedPreferences(DATA_USER_CACHE, MODO_PRIVATE);
        } catch (NullPointerException e){
            Log.e(TAG, "Error getting Shared Preferences: ", e);
        }

        if(sharedPreferences!=null){
            nombre = sharedPreferences.getString("nombre", "");
            edad = sharedPreferences.getString("edad", "");
            categoria = sharedPreferences.getString("categoria", "");
        } else{
            nombre = "";
            edad = "";
            categoria = "";
        }


        if (mainNombre != null) {
            mainNombre.setText(nombre);
        } else {
            Log.e(TAG, "mainNombre is null");
        }

        if (mainEdad != null) {
            mainEdad.setText(edad);
        } else {
            Log.e(TAG, "mainEdad is null");
        }

        if (mainCategoria != null) {
            mainCategoria.setText(categoria);
        } else {
            Log.e(TAG, "mainCategoria is null");
        }
    }
}