package com.example.bonilla_miguel_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDos extends AppCompatActivity {

    private int REQUEST_ACTIVITY_3 = 1;

    private Button button_cerrar_activity_dos;
    private TextView text_view_nombre;
    private TextView text_view_base;

    String nombre = "", apellido, base,  exponente, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        button_cerrar_activity_dos = findViewById(R.id.button_cerrar_Activity2);
        text_view_nombre = findViewById(R.id.textView_nombre_activity2);
        text_view_base = findViewById(R.id.textView_base_activity2);


        if(nombre.equals(""))
            button_cerrar_activity_dos.setEnabled(false);

    }

    public void AbrirActivityTres(View view){
        Intent intent = new Intent(this, ActivityTres.class);
        startActivityForResult(intent, REQUEST_ACTIVITY_3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ACTIVITY_3){
            if(resultCode == Activity.RESULT_OK) {
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                text_view_nombre.setText(nombre);
                text_view_base.setText(base);

                if(!nombre.equals(""))
                    button_cerrar_activity_dos.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

    public void CerrarActivityDos(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);

        this.finish();;
    }
}