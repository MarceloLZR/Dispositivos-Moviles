package com.example.mycontactos20232;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListarContacto extends AppCompatActivity {
    ListView lvcontactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contacto);
        //MainActivity.con.listarContacto(); ///AGREGADO!!!
        lvcontactos = (ListView)findViewById(R.id.lvcontactos);
        MyAdaptador myAdaptador = new MyAdaptador(this);
        lvcontactos.setAdapter(myAdaptador);
        lvcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto c = MainActivity.miscontactos.get(i);
                String nombre = c.getNombre();
                String alias = c.getAlias();
                int id = c.getIdcontacto();
                String mensaje = "Nombre:"+nombre+" Alias:"+alias+" id:"+id;
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
            }
        });
    }
}