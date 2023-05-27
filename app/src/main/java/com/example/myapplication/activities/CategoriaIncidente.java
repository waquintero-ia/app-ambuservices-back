package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class CategoriaIncidente extends AppCompatActivity {

    Button btnReportar;

    private RadioButton accidenteTransito;
    private RadioButton transporteSanitarioUrgente;
    private RadioButton transporteNoSanitarioUrgente;
    private RadioButton transporteGranCapacidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_incidente);

        btnReportar = (Button) findViewById(R.id.reportarIncidente3);

        accidenteTransito=findViewById(R.id.accidenteTransito);

        transporteSanitarioUrgente=findViewById(R.id.transporteSanitarioUrgente);

        transporteNoSanitarioUrgente=findViewById(R.id.transporteNoSanitarioUrgente);

        transporteGranCapacidad=findViewById(R.id.transporteGranCapacidad);

        btnReportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (accidenteTransito.isChecked()){
                    Intent intent = new Intent (CategoriaIncidente.this, ReporteExitoso.class);
                    startActivity(intent);
                    Toast notificacion= Toast.makeText(CategoriaIncidente.this,"El accidente de transito fue reportado con exito",Toast.LENGTH_LONG);
                    notificacion.show();
                } else if (transporteSanitarioUrgente.isChecked()) {
                    Intent intent = new Intent (CategoriaIncidente.this, ReporteExitoso.class);
                    startActivity(intent);
                    Toast notificacion= Toast.makeText(CategoriaIncidente.this,"El transporte sanitario fue reportado con exito",Toast.LENGTH_LONG);
                    notificacion.show();
                } else if (transporteNoSanitarioUrgente.isChecked()) {
                    Intent intent = new Intent(CategoriaIncidente.this, ReporteExitoso.class);
                    startActivity(intent);
                    Toast notificacion = Toast.makeText(CategoriaIncidente.this, "El transporte NO sanitario fue reportado con exito", Toast.LENGTH_LONG);
                    notificacion.show();
                } else if (transporteGranCapacidad.isChecked()) {
                    Intent intent = new Intent (CategoriaIncidente.this, ReporteExitoso.class);
                    startActivity(intent);
                    Toast notificacion= Toast.makeText(CategoriaIncidente.this,"El transporte de gran capacidad fue reportado con exito",Toast.LENGTH_LONG);
                    notificacion.show();
                } else if (accidenteTransito.isChecked()==false || transporteSanitarioUrgente.isChecked()==false || transporteNoSanitarioUrgente.isChecked()==false || transporteGranCapacidad.isChecked()==false) {
                    Toast notificacion= Toast.makeText(CategoriaIncidente.this,"Debe seleccionar una opción",Toast.LENGTH_LONG);
                    notificacion.show();
                }
            }
        });
    }
}