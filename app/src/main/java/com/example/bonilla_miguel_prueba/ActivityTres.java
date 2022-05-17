package com.example.bonilla_miguel_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityTres extends AppCompatActivity {

    private EditText editText_nombre;
    private EditText editText_apellido;
    private EditText editText_base;
    private EditText editText_exponente;
    private EditText editText_numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        editText_nombre = findViewById(R.id.editText_nombre_activity3);
        editText_apellido = findViewById(R.id.editText_apellido_activity3);
        editText_base = findViewById(R.id.editText_base_activity3);
        editText_exponente = findViewById(R.id.editText_exponente_activity3);
        editText_numero = findViewById(R.id.editText_numero_activity3);
    }

    public void CerrarActivityTres(View view){
        String nombre, apellido, base, exponente, numero;

        nombre = editText_nombre.getText().toString();
        apellido = editText_apellido.getText().toString();
        base = editText_base.getText().toString();
        exponente = editText_exponente.getText().toString();
        numero = editText_numero.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);
        this.finish();
    }
}