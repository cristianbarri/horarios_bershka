package com.example.barri.horarios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class horarios_responsable extends AppCompatActivity {
    private Button b_plantilla, b_eliminar, b_anadir, b_crear, b_crear1, b_ver;
    private Spinner s_nombres, s_horarios;
    private EditText e_nombre, e_horario;

    int num_filas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_responsable);

        b_plantilla = (Button) findViewById(R.id.b_plantilla);
        b_eliminar = (Button) findViewById(R.id.b_eliminar);
        b_anadir = (Button) findViewById(R.id.b_anadir);
        b_crear = (Button) findViewById(R.id.b_crear);
        b_crear1 = (Button) findViewById(R.id.b_crear1);
        b_ver = (Button) findViewById(R.id.b_ver);


        //SPINNERS
        s_nombres = (Spinner) findViewById(R.id.spinner);
        final List<String> list = new ArrayList<String>();
        list.add("Sebas");
        list.add("Judith");
        list.add("Marco");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_nombres.setAdapter(dataAdapter);

        b_anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e_nombre.getText().toString().trim().length() != 0) {
                    //Añadir personal
                    list.add(e_nombre.getText().toString());
                    dataAdapter.notifyDataSetChanged();
                    e_nombre.setText("");
                    Toast.makeText(getApplicationContext(), "Añadido correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Eliminar personal
                list.remove(s_nombres.getSelectedItem().toString());
                dataAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        s_horarios = (Spinner) findViewById(R.id.spinner2);
        final List<String> list1 = new ArrayList<String>();
        list1.add("SEMANA - 28/12 al 03/01");
        list1.add("SEMANA - 04/01 al 10/01");
        list1.add("SEMANA - 11/01 al 17/01");
        final ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_horarios.setAdapter(dataAdapter1);

        b_crear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Añadir horario al spinner
                list1.add(e_horario.getText().toString());
                dataAdapter1.notifyDataSetChanged();
                e_horario.setText("");
                num_filas = list.size();
                Toast.makeText(getApplicationContext(), "Añadido correctamente", Toast.LENGTH_SHORT).show();

                //Crear tabla en la base de datos, desde la cual cogeremos los valores para la GridLayout


            }
        });

        //VISIBILIDAD
        e_nombre = (EditText) findViewById(R.id.editText5);
        e_horario= (EditText) findViewById(R.id.editText6);

        s_nombres.setVisibility(View.GONE);
        b_eliminar.setVisibility(View.GONE);
        e_nombre.setVisibility(View.GONE);
        b_anadir.setVisibility(View.GONE);

        e_horario.setVisibility(View.GONE);
        b_crear1.setVisibility(View.GONE);

        //BOTONES PRINCIPALES
        b_plantilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_nombres.getVisibility() == View.GONE) {
                    s_nombres.setVisibility(View.VISIBLE);
                    b_eliminar.setVisibility(View.VISIBLE);
                    e_nombre.setVisibility(View.VISIBLE);
                    b_anadir.setVisibility(View.VISIBLE);
                } else {
                    s_nombres.setVisibility(View.GONE);
                    b_eliminar.setVisibility(View.GONE);
                    e_nombre.setVisibility(View.GONE);
                    b_anadir.setVisibility(View.GONE);
                }
            }
        });

        b_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e_horario.getVisibility() == View.GONE) {
                    e_horario.setVisibility(View.VISIBLE);
                    b_crear1.setVisibility(View.VISIBLE);
                }
                else {
                    e_horario.setVisibility(View.GONE);
                    b_crear1.setVisibility(View.GONE);
                }
            }
        });

        b_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), pantalla_horario.class);
                i.putExtra("num_filas", num_filas);
                startActivity(i);
            }
        });
    }

}
