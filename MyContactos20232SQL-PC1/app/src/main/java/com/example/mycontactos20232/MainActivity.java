package com.example.mycontactos20232;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Contacto> miscontactos = new ArrayList<Contacto>();
    public static int contador = 0;
    public static ConexionSqlite con = null;
    Button btniragregar,btnirlistar,btnirlistasqlite;
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mimenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnuiragregarcontactolista:
                Intent intent1 = new Intent(getApplicationContext(),AgregarContactoLista.class);
                startActivity(intent1);
            break;
            case R.id.mnuirListarContacto:
                Intent intent = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent);
                break;
            case R.id.mnuirListarContactoSQlite:
                Intent intent2 = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        con = new ConexionSqlite(this);
        MainActivity.con.listarContacto(); ///AGREGADO!!!
        btniragregar = (Button) findViewById(R.id.btnirAgregar);
        btniragregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AgregarContactoLista.class);
                startActivity(intent);
            }
        });
        btnirlistar = (Button) findViewById(R.id.btnirListar);
        btnirlistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListarContacto.class);
                startActivity(intent);
            }
        });
        btnirlistasqlite = (Button) findViewById(R.id.btnirlistasqlite);
        btnirlistasqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListarSqlite.class);
                startActivity(intent);
            }
        });
    }
}