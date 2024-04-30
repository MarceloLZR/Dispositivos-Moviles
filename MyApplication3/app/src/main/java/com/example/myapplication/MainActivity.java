package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btncontar;
    TextView lblmostrar;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncontar = findViewById(R.id.btncontar);
        lblmostrar = findViewById(R.id.lblmostrar);
        lblmostrar.setText(String.valueOf(contador));

        btncontar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                lblmostrar.setText(String.valueOf(contador));
                Toast.makeText(getApplicationContext(), String.valueOf(contador), Toast.LENGTH_LONG).show();
            }
        });
    }
}

