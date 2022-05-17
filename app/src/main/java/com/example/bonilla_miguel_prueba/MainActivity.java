package com.example.bonilla_miguel_prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_ACTIVITY_2 = 1;
    String nombre = "", apellido, base, exponente, numero;
    private Button button_mostrar_resultados;
    private TextView text_view_nombre;
    private TextView text_view_apellido;
    private TextView text_view_base;
    private TextView text_view_exponente;
    private TextView text_view_factorial;
    private TextView text_view_potencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_mostrar_resultados = findViewById(R.id.button_mostrar_activity1);
        text_view_nombre = findViewById(R.id.textView_nombre_activity1);
        text_view_apellido = findViewById(R.id.textView_apellido_activity1);
        text_view_base = findViewById(R.id.textView_base_activity1);
        text_view_exponente = findViewById(R.id.textView_exponente_activity1);
        text_view_factorial = findViewById(R.id.textView_factorial_activity1);
        text_view_potencia = findViewById(R.id.textView_potencia_activity1);

        if(nombre.equals(""))
            button_mostrar_resultados.setEnabled(false);

    }

    public void AbrirActivityDos(View view){
        Intent intent = new Intent(this, ActivityDos.class);
        startActivityForResult(intent, REQUEST_ACTIVITY_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ACTIVITY_2){
            if(resultCode == Activity.RESULT_OK){
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                text_view_nombre.setText(nombre);
                text_view_apellido.setText(apellido);
                text_view_base.setText(base);
                text_view_exponente.setText(exponente);

                if(!nombre.equals(""))
                    button_mostrar_resultados.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

    public void MostrarResultados(View view){
        text_view_factorial.setText(String.valueOf(Factorial(Integer.parseInt(numero))));
        text_view_potencia.setText(String.valueOf(Potencia(Integer.parseInt(base), Integer.parseInt(exponente))));
    }

    public int Factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return (int)(numero * Factorial(numero-1));
    }

    public static int Potencia(int x, int z) {
        int potencia = 1;
        for (int i = 1; i <= z; i++) {
            potencia = potencia * x;
        }
        return potencia;
    }
}