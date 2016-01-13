package com.example.barri.horarios;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridLayout;

public class pantalla_horario extends AppCompatActivity {

    private GridLayout horario;

    int num_filas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_horario);

        Bundle bundle = getIntent().getExtras();
        num_filas = bundle.getInt("num_filas");

        horario = (GridLayout) findViewById(R.id.horario);
        horario.setColumnCount(8);
        horario.setRowCount(num_filas);
    }

}
