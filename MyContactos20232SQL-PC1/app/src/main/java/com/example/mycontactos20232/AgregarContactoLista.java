package com.example.mycontactos20232;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AgregarContactoLista extends AppCompatActivity {
    EditText txtnombre,txtalias;
    Spinner spntipo;
    Button btnagregarcontacto,btncancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto_lista);
        //MainActivity.con.listarContacto(); ///AGREGADO!!!
        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtalias = (EditText)findViewById(R.id.txtalias);
        spntipo = (Spinner) findViewById(R.id.spntipo);
        btnagregarcontacto = (Button)findViewById(R.id.btnAgregarContacto);
        btncancelar = (Button)findViewById(R.id.btncancelar);
        btnagregarcontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtnombre.getText().toString();
                String alias = txtalias.getText().toString();
                int tipo = spntipo.getSelectedItemPosition();
                int id = MainActivity.contador;
                Contacto c = new Contacto(id,nombre,alias,tipo);
                MainActivity.miscontactos.add(c);
                MainActivity.contador++;
                MainActivity.con.insertarContacto(c);
                String mensaje ="Contacto Agregado";
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                txtnombre.setText("");
                txtalias.setText("");
                spntipo.setSelection(0);
                Intent intent = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent);
            }
        });
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}