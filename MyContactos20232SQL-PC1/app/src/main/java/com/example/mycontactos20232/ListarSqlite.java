package com.example.mycontactos20232;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListarSqlite extends AppCompatActivity {
    ListView lvcontactossqlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sqlite);
        MainActivity.con.listarContacto();
        lvcontactossqlite = (ListView)findViewById(R.id.lvlistarcontactosqlite);
        MyAdaptador myAdaptador = new MyAdaptador(this);
        lvcontactossqlite.setAdapter(myAdaptador);
        lvcontactossqlite.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto c = MainActivity.miscontactos.get(i);
                String nombre = c.getNombre();
                String alias = c.getAlias();
                int id = c.getIdcontacto();
                String mensaje = "Nombre:"+nombre+" Alias:"+alias+" id:"+id;
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                Log.d("MyContacto20232",mensaje);
            }
        });
    }
}