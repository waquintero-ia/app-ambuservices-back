package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.activities.Ambulancia;
import com.example.myapplication.activities.CreateActivity;
import com.example.myapplication.activities.InicioReportero;
import com.example.myapplication.adapters.EmpleadosAdapter;
import com.example.myapplication.model.Empleado;
import com.example.myapplication.sinterface.CrudEmpleadoInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    CrudEmpleadoInterface cruempleado;
    List<Empleado> listEmpleado;

    //Button btnInicioReportero;

    //Button btnInicioAmbulancia;

    ListView listView;

    FloatingActionButton createButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        listView=findViewById(R.id.listView);

        createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callCreate();
            }
        });

        getAll();
        //Empleado empleado = null;
        //create(empleado);
        //delete();
        //callEdit(empleado);

        //btnInicioReportero = (Button)findViewById(R.id.btnRerportero);

     //   btnInicioAmbulancia = (Button)findViewById(R.id.btnAmbulancia);

      /*  btnInicioReportero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, InicioReportero.class);
                startActivity(intent);
            }
        });*/

      /*  btnInicioAmbulancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Ambulancia.class);
                startActivity(intent);
            }
        });*/
    }

    private void getAll() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();


        call.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, retrofit2.Response<List<Empleado>> response) {
                if (!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(),response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
                listEmpleado = response.body();
                EmpleadosAdapter empleadosAdapter = new EmpleadosAdapter(listEmpleado,getApplicationContext());
                listView.setAdapter(empleadosAdapter);
                //listEmpleado.forEach(p-> System.out.println(p.toString()));
                listEmpleado.forEach(p -> Log.i("Empleados: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                //System.out.println(t.getMessage());
                Log.e("Throw error:", t.getMessage());
            }

        });
    }

   /* private void create(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        empleado = new Empleado("Pepita Perez", "504", "aaa@gmail.com" ,"3206675139","504");
        Call<Empleado> call = cruempleado.create(empleado);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }*/

    /*private void delete(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.delete(3L);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }*/

    /*private void callEdit(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        empleado = new Empleado("Pepito", "666", "zz@gmail.com","3206675139","666");
        Call<Empleado> call = cruempleado.callEdit(10L,empleado);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }*/

    private void callCreate(){
        Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(intent);
    }
}