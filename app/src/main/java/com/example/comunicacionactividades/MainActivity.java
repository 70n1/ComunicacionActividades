package com.example.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bVerificar;
    //private EditText edNombre;
    private int REQUEST_ACEPTAR = 1024;

    boolean validado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bVerificar = (Button)findViewById(R.id.b_verificar);
        bVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar();
            }
        });
    }
    private void verificar(){
        Intent intent =  new Intent(this, AceptarActivity.class);
        EditText et_nombre = (EditText)findViewById(R.id.et_nombre);
        String nombrealumno = et_nombre.getText().toString();
        intent.putExtra("nombrealumno", nombrealumno);

        //startActivity(intent);
        startActivityForResult(intent, REQUEST_ACEPTAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_ACEPTAR==requestCode) {
            if (resultCode==RESULT_OK){
                validado = (boolean)data.getExtras().getBoolean("validado");
                mostrar_resultado();
            }
        }
    }

    private void mostrar_resultado() {
        String texto_validado = "Cancelado";
        if (validado) texto_validado = "Validado";
        ((TextView)findViewById(R.id.tv_resultado)).setText("Resultado: " + texto_validado);
    }
}
