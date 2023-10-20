package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private EditText eti1, eti2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eti1 = findViewById(R.id.editTextNumber1);
        eti2 = findViewById(R.id.editTextNumber2);
        tv1 = findViewById(R.id.textViewRes);
        spinner1 = findViewById(R.id.spinner);

        String[] opciones = {"sumar", "restar", "multiplicar", "dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }

    public void calcular(View vista) {
        String valor1_String = eti1.getText().toString();
        String valor2_String = eti2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        String seleccion = spinner1.getSelectedItem().toString();
        if (seleccion.equals("sumar")) {
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if (seleccion.equals("restar")) {
            int restar = valor1_int - valor2_int;
            String resultado = String.valueOf(restar);
            tv1.setText(resultado);
        } else if (seleccion.equals("multiplicar")) {
            int multiplicar = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);
        } else if (seleccion.equals("dividir")) {
            if (valor2_int != 0) {
                double dividir = (double) valor1_int / valor2_int;
                String resultado = String.valueOf(dividir);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
            }
        }
    }
}