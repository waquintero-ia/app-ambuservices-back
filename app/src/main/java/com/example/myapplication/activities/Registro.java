package com.example.myapplication.activities;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Registro extends AppCompatActivity {

    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGuardar = (Button) findViewById(R.id.guardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Registro.this, MainActivity.class);
                startActivity(intent);
                Toast notificacion= Toast.makeText(Registro.this,"Usuario creado exitosamente",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });
    }
}
