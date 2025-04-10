package com.example.corte2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText edt_nombre, edt_edad;
    Button btn_login;
    Spinner categorias_spinner;
    public static final String dataUserCache = "userData";
    private static final int modo_private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


        edt_nombre = findViewById(R.id.edt_nombre);
        edt_edad = findViewById(R.id.edt_edad);
        btn_login = findViewById(R.id.btn_login);
        categorias_spinner = findViewById(R.id.categorias_spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias_spinner.setAdapter(adapter);


        sharedPreferences = getSharedPreferences(dataUserCache, modo_private);
        editor = sharedPreferences.edit();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categorias_spinner == null || categorias_spinner.getSelectedItem() == null) {
                    Toast.makeText(Login.this, "Select a category", Toast.LENGTH_SHORT).show();
                    return;
                }

                String categorias = categorias_spinner.getSelectedItem().toString().trim();

                if (!edt_nombre.getText().toString().isEmpty() && !edt_edad.getText().toString().isEmpty() ) {
                    editor.putString("nombre", edt_nombre.getText().toString());
                    editor.putString("edad", edt_edad.getText().toString());
                    editor.putString("categoria", categorias);
                    editor.commit();

                    switch (categorias) {
                        case "musica":
                            Intent i = new Intent(Login.this, Musica.class);
                            startActivity(i);
                            break;
                        case "deporte":
                            Intent a = new Intent(Login.this, deporte.class);
                            startActivity(a);
                            break;
                        case "cine":
                            Intent b = new Intent(Login.this, cine.class);
                            startActivity(b);
                            break;
                        default:

                            break;
                    }
                }else{
                    Toast.makeText(Login.this, "Los campos son obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}