package com.example.mycontactos20232;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditarContacto extends AppCompatActivity {
    EditText txtnombre,txtalias;
    Spinner spntipo;
    Button btnagregarcontacto,btncancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);
        //MainActivity.con.listarContacto(); ///AGREGADO!!!
        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtalias = (EditText)findViewById(R.id.txtalias);
        spntipo = (Spinner) findViewById(R.id.spntipo);
        String nombre = getIntent().getStringExtra("nombreX");
        txtnombre.setText(nombre);
        int position = getIntent().getIntExtra("positionX",-1);
        String alias = getIntent().getStringExtra("aliasX");
        txtalias.setText(alias);
        spntipo.setSelection(getIntent().getIntExtra("tipoX",-1));
        btnagregarcontacto = (Button)findViewById(R.id.btnAgregarContacto);
        btncancelar = (Button)findViewById(R.id.btncancelar);
        btnagregarcontacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtnombre.getText().toString();
                String alias = txtalias.getText().toString();
                int tipo = spntipo.getSelectedItemPosition();
                Contacto c = MainActivity.miscontactos.get(position);
                c.setNombre(nombre);
                c.setAlias(alias);
                c.setTipo(tipo);
                MainActivity.con.editarContacto(c,nombre,alias,tipo);
                Toast.makeText(getApplicationContext(),"Contacto Editado",Toast.LENGTH_LONG).show();
                txtnombre.setText("");
                txtalias.setText("");
                Intent intent = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent);
            }
        });
        btncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent);
            }
        });
    }
}