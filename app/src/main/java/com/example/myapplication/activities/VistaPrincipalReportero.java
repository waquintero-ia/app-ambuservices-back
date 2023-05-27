package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class VistaPrincipalReportero extends AppCompatActivity {

    Button btnReportarIncidente;

    private RadioButton reportarIncidenteUbicacion;
    private RadioButton reportarIncidenteMapa;

    private RadioButton reportarIncidenteDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_principal_reportero);

        btnReportarIncidente = (Button) findViewById(R.id.reportarIncidente);

        reportarIncidenteUbicacion=findViewById(R.id.accidenteTransito);

        reportarIncidenteMapa=findViewById(R.id.transporteSanitarioUrgente);

        reportarIncidenteDireccion=findViewById(R.id.transporteNoSanitarioUrgente);

        btnReportarIncidente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (reportarIncidenteUbicacion.isChecked()){
                    Intent intent = new Intent (VistaPrincipalReportero.this, CategoriaIncidente.class);
                    startActivity(intent);
                } else if (reportarIncidenteMapa.isChecked()) {
                    Intent intent = new Intent (VistaPrincipalReportero.this, CategoriaIncidente.class);
                    startActivity(intent);
                } else if (reportarIncidenteDireccion.isChecked()) {
                    Intent intent = new Intent (VistaPrincipalReportero.this, ReportarIncidenteConDireccion.class);
                    startActivity(intent);
                } else if(reportarIncidenteUbicacion.isChecked()==false || reportarIncidenteMapa.isChecked()==false || reportarIncidenteDireccion.isChecked()==false) {
                    Toast notificacion= Toast.makeText(VistaPrincipalReportero.this,"Debe seleccionar una opción",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        });
    }
}