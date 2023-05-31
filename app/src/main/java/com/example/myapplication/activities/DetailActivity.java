package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.fragments.DeleteFragment;
import com.example.myapplication.model.Empleado;
import com.example.myapplication.sinterface.CrudEmpleadoInterface;
import com.example.myapplication.sinterface.DeleteInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity implements DeleteInterface {

    TextView idText;
    TextView nombreCompletoText;
    TextView emailText;
    TextView celularText;
    TextView contraseniaText;
    TextView confirmacionContraseniaText;

    Button deleteButton;

    Empleado empleado;

    CrudEmpleadoInterface cruempleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        idText = findViewById(R.id.idText);
        nombreCompletoText = findViewById(R.id.nombreCompletoText);
        emailText = findViewById(R.id.emailText);
        celularText = findViewById(R.id.celularText);
        contraseniaText = findViewById(R.id.contraseniaText);
        confirmacionContraseniaText = findViewById(R.id.confirmacionContraseniaText);
        Long id = Long.valueOf(getIntent().getExtras().getInt("id"));
        getOne(id);
        //delete(id);
        deleteButton= findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showDeleteDialog(empleado.getId());
                delete(id);
            }

        });
    }

    private void getOne(Long id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Empleado empleado = null;
        Call<Empleado> call = cruempleado.getOne(id);
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
                idText.setText(String.valueOf(empleado.getId()));
                nombreCompletoText.setText(empleado.getNombreCompleto());
                emailText.setText(empleado.getEmail());
                celularText.setText(empleado.getCelular());
                contraseniaText.setText(empleado.getPassword());
                confirmacionContraseniaText.setText(empleado.getConfirmacionPassword());

            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw error:", t.getMessage());
            }
        });

    }

    @Override
    public void showDeleteDialog(Long id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DeleteFragment deleteFragment = new DeleteFragment("Delete Usuario ", empleado.getId(), this);
        deleteFragment.show(fragmentManager, "Alert");
    }

    @Override
    public void delete(Long id) {
        cruempleado = getCruempleado();
        Call<Empleado> call= cruempleado.delete(id);
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
                empleado=response.body();
                Toast toast = Toast.makeText(getApplicationContext(),empleado.getNombreCompleto() + " deleted!!", Toast.LENGTH_LONG);
                toast.show();
                callMain();
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw error:", t.getMessage());
            }
        });

    }

    private CrudEmpleadoInterface getCruempleado(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        return cruempleado;
    }

    /*private CrudEmpleadoInterface getCruempleado{
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);

        return cruempleado;
    }*/
    private void callMain() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}