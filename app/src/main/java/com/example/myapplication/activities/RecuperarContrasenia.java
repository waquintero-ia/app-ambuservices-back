package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class RecuperarContrasenia extends AppCompatActivity {

    Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasenia);

        btnRecuperar = (Button) findViewById(R.id.recuperar);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (RecuperarContrasenia.this, MainActivity.class);
                startActivity(intent);
                Toast notificacion= Toast.makeText(RecuperarContrasenia.this,"Revisar link enviado al correo electronico",Toast.LENGTH_LONG);
                notificacion.show();
            }
        });
    }
}