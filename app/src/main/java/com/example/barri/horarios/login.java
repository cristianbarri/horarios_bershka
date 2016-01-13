package com.example.barri.horarios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {


    private Button b_resp, b_empl, b_acceder;
    private TextView id_resp, pass_resp, id_empl, pass_empl;
    private EditText edit_resp, edit_pass1, edit_empl, edit_pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b_resp = (Button) findViewById(R.id.button);
        b_empl = (Button) findViewById(R.id.button2);
        b_acceder = (Button) findViewById(R.id.button3);

        id_resp = (TextView) findViewById(R.id.textView3);
        pass_resp = (TextView) findViewById(R.id.textView4);
        id_empl = (TextView) findViewById(R.id.textView5);
        pass_empl = (TextView) findViewById(R.id.textView6);

        edit_resp = (EditText) findViewById(R.id.editText);
        edit_pass1 = (EditText) findViewById(R.id.editText2);
        edit_empl = (EditText) findViewById(R.id.editText3);
        edit_pass2 = (EditText) findViewById(R.id.editText4);

        b_acceder.setVisibility(View.GONE);

        id_resp.setVisibility(View.GONE);
        pass_resp.setVisibility(View.GONE);
        edit_resp.setVisibility(View.GONE);
        edit_pass1.setVisibility(View.GONE);

        id_empl.setVisibility(View.GONE);
        pass_empl.setVisibility(View.GONE);
        edit_empl.setVisibility(View.GONE);
        edit_pass2.setVisibility(View.GONE);

        b_resp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_acceder.setVisibility(View.VISIBLE);

                id_resp.setVisibility(View.VISIBLE);
                pass_resp.setVisibility(View.VISIBLE);
                edit_resp.setVisibility(View.VISIBLE);
                edit_pass1.setVisibility(View.VISIBLE);

                id_empl.setVisibility(View.GONE);
                pass_empl.setVisibility(View.GONE);
                edit_empl.setVisibility(View.GONE);
                edit_pass2.setVisibility(View.GONE);
            }
        });

        b_empl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_acceder.setVisibility(View.VISIBLE);

                id_resp.setVisibility(View.GONE);
                pass_resp.setVisibility(View.GONE);
                edit_resp.setVisibility(View.GONE);
                edit_pass1.setVisibility(View.GONE);

                id_empl.setVisibility(View.VISIBLE);
                pass_empl.setVisibility(View.VISIBLE);
                edit_empl.setVisibility(View.VISIBLE);
                edit_pass2.setVisibility(View.VISIBLE);
            }
        });

        b_acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_resp.getVisibility() == View.VISIBLE) {
                    Intent i = new Intent(v.getContext(), horarios_responsable.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(v.getContext(), horarios_empleado.class);
                    startActivity(i);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
