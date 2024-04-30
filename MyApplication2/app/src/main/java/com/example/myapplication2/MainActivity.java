package com.example.myapplication2;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnmostrar;
    Spinner cbopaises;
    ListView lvpaises;
    ImageButton imgbtmostrar;
    ImageView imgmipais;
    CheckBox chkpositivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmostrar = findViewById(R.id.btnmostrar);
        cbopaises = findViewById(R.id.cbopaises);
        lvpaises = findViewById(R.id.lvpaises);
        imgbtmostrar = findViewById(R.id.imgbtmostrar);
        imgmipais = findViewById(R.id.imgmipais);
        chkpositivo = findViewById(R.id.chkpositivo);

        imgbtmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pais = cbopaises.getSelectedItem().toString();
                int posicion = cbopaises.getSelectedItemPosition();
                String mensaje = "Usted ha seleccionado el país: " + pais;
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
                if (chkpositivo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Seleccionado", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "NO Seleccionado", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pais = cbopaises.getSelectedItem().toString();
                int position = cbopaises.getSelectedItemPosition();
                String mensaje = "Usted ha seleccionado el país: " + pais;
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
        lvpaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Resources res = getResources();
                String[] paises = res.getStringArray(R.array.paises);
                String pais = paises[position];
                String mensaje = position + "Ud ha seleccionado el pais" + pais;
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
                switch (position) {
                    case 0:
                        imgmipais.setImageResource(R.drawable.peru);
                        break;
                    case 1:
                        imgmipais.setImageResource(R.drawable.chile);
                        break;
                    case 2:
                        imgmipais.setImageResource(R.drawable.brasil);
                        break; // Añadir un break aquí
                }
            }
        });

        lvpaises.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Resources res = getResources();
                String[] paises = res.getStringArray(R.array.paises);
                String pais = paises[position];
                String mensaje = position + "Ud ha seleccionado prolongado el pais" + pais;
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();

                return false;
            }
        });
    }
}
