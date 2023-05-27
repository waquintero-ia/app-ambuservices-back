package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class Menu extends AppCompatActivity {

    Button btnMisViajes;

    Button btnBitacoras;

    Button btnBitacorasIncidenteActual;

    Button btnSolicitarOtraAmbulancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMisViajes = (Button) findViewById(R.id.misViajes);

        btnBitacoras = (Button) findViewById(R.id.bitacoras);

        btnBitacorasIncidenteActual = (Button) findViewById(R.id.bitacoraIncidenteActual);

        btnSolicitarOtraAmbulancia = (Button) findViewById(R.id.solicitarOtraAmbulancia);

        btnMisViajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, MisViajes.class);
                startActivity(intent);
            }
        });

        btnBitacoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, Bitacoras.class);
                startActivity(intent);
            }
        });

        btnBitacorasIncidenteActual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, BitacoraIncidenteActual.class);
                startActivity(intent);
            }
        });

        btnSolicitarOtraAmbulancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Menu.this, VistaPrincipalAmbulancia.class);
                startActivity(intent);
                Toast notificacion= Toast.makeText(Menu.this,"Ambulancia solicitada con exito",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });
    }
}