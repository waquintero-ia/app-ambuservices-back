package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class InicioReportero extends AppCompatActivity {

    TextView btnRecuperarContrasenia;
    Button btnVistaPrincipalReportero;
    Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_reportero);

        btnRecuperarContrasenia = (TextView) findViewById(R.id.olvidoContrasenia);

        btnVistaPrincipalReportero = (Button) findViewById(R.id.login);

        btnRegistrarse = (Button) findViewById(R.id.registrarse);

        btnRecuperarContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InicioReportero.this, RecuperarContrasenia.class);
                startActivity(intent);
            }
        });

        btnVistaPrincipalReportero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InicioReportero.this, VistaPrincipalReportero.class);
                startActivity(intent);
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (InicioReportero.this, Registro.class);
                startActivity(intent);
            }
        });
    }
}