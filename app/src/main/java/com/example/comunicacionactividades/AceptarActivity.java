package com.example.comunicacionactividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by AMARTIN on 28/09/2016.
 */

public class AceptarActivity extends AppCompatActivity {
    private String nombre ="";
    private Button b_aceptar;
    private Button b_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptar);

        nombre = getIntent().getExtras().getString("nombrealumno");

        ((TextView) findViewById(R.id.tv_condiciones)).setText("Hola " + nombre + ", ¿Aceptas la condiciones?");

        b_aceptar = (Button)findViewById(R.id.b_aceptar);
        b_aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsado_aceptar();
            }
        });

        b_cancelar = (Button)findViewById(R.id.b_cancelar);
        b_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pulsado_cancelar();
            }
        });
    }

    private void pulsado_cancelar() {
        Intent intent = new Intent();
        intent.putExtra("validado", false);
        setResult(RESULT_OK,intent);
        finish();
    }

    private void pulsado_aceptar() {
        Intent intent = new Intent();
        intent.putExtra("validado", true);
        setResult(RESULT_OK,intent);
        finish();

    }
}
