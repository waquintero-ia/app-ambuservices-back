package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.activities.DetailActivity;
import com.example.myapplication.model.Empleado;

import java.util.List;

public class EmpleadosAdapter extends BaseAdapter {

    List<Empleado> empleados;

    Context context;
    TextView nameText;
    Button viewButton;

    public EmpleadosAdapter(List<Empleado> empleados, Context context) {
        this.empleados = empleados;
        this.context = context;
    }

    @Override
    public int getCount() {
        return empleados.size();
    }

    @Override
    public Object getItem(int i) {
        return empleados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return empleados.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.activity_lista_usuarios,viewGroup,false);
        }
        nameText=view.findViewById(R.id.nameText);
        nameText.setText(empleados.get(position).getNombreCompleto());
        viewButton=view.findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetail((int) empleados.get(position).getId());
            }
        });
        return view;
    }

    private void callDetail(int id){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("id",id);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
