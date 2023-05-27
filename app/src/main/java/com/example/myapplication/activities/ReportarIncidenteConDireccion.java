package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class ReportarIncidenteConDireccion extends AppCompatActivity {

    Button btnReportarIncidente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar_incidente_con_direccion);

        btnReportarIncidente = (Button) findViewById(R.id.reportarIncidenteDir);

        btnReportarIncidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ReportarIncidenteConDireccion.this, CategoriaIncidente.class);
                startActivity(intent);
            }
        });
    }
}