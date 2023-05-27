package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Empleado;
import com.example.myapplication.sinterface.CrudEmpleadoInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateActivity extends AppCompatActivity {

    EditText nombreCompletoText;
    EditText emailText;
    EditText celularText;
    EditText contraseniaText;
    EditText confirmacionContraseniaText;
    Button createButton;

    CrudEmpleadoInterface cruempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        nombreCompletoText = findViewById(R.id.nombreCompletoText);
        emailText=findViewById(R.id.emailText);
        celularText=findViewById(R.id.celularText);
        contraseniaText=findViewById(R.id.contraseniaText);
        confirmacionContraseniaText=findViewById(R.id.confirmacionContraseniaText);
        createButton=findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleado empleado = new Empleado(nombreCompletoText.getText().toString(), contraseniaText.getText().toString(), emailText.getText().toString(), celularText.getText().toString(), confirmacionContraseniaText.getText().toString());
                create(empleado);
            }
        });
    }

    private void create(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.create(empleado);
        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(),response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
                Empleado empleado = response.body();
                Toast toast = Toast.makeText(getApplicationContext(),empleado.getNombreCompleto() + " Created!!", Toast.LENGTH_LONG);
                toast.show();
                callMain();
            }



            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                //System.out.println(t.getMessage());
                Log.e("Throw error:", t.getMessage());
            }
        });
    }

    private void callMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}