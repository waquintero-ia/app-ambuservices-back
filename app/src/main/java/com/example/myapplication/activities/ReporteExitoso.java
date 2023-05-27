package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class ReporteExitoso extends AppCompatActivity {

    Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_exitoso);

        btnInicio = (Button) findViewById(R.id.inicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ReporteExitoso.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}