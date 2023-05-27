package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class BitacoraIncidenteActual extends AppCompatActivity {

    Button btnGuardarIncidente;

    Button btnCompartirBitacora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitacora_incidente_actual);

        btnGuardarIncidente = (Button) findViewById(R.id.guardarBitacora);

        btnCompartirBitacora = (Button) findViewById(R.id.compartir);

        btnGuardarIncidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BitacoraIncidenteActual.this, VistaPrincipalAmbulancia.class);
                startActivity(intent);
                Toast notificacion= Toast.makeText(BitacoraIncidenteActual.this,"Bitacora guardada con exito",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });

        btnCompartirBitacora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (BitacoraIncidenteActual.this, CompartirBitacora.class);
                startActivity(intent);
            }
        });
    }
}