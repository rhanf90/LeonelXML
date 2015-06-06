package com.app.rhanfe006.leonelxml;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class vista_individual extends Activity {

    static final String KEY_REGISTRO = "registro"; // parent node
    static final String KEY_ID = "id_persona";
    static final String KEY_NOMBRE = "nombre";
    static final String KEY_APELLIDOS = "apellidos";
    static final String KEY_ACTIVIDAD = "actividad";
    static final String KEY_NIVEL = "nivel";
    static final String KEY_MODULO = "modulo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_individual);

        Intent in =getIntent();

        // Get XML values from previous intent
        String id_persona = in.getStringExtra(KEY_ID);
        String nombre = in.getStringExtra(KEY_NOMBRE);
        String apellidos = in.getStringExtra(KEY_APELLIDOS);
        String actividad = in.getStringExtra(KEY_ACTIVIDAD);
        String nivel = in.getStringExtra(KEY_NIVEL);
        String modulo = in.getStringExtra(KEY_MODULO);

        // Displaying all values on the screen
        TextView lblid = (TextView) findViewById(R.id.txt_idpersona);
        TextView lblnombre = (TextView) findViewById(R.id.txt_nombre);
        TextView lblapellidos = (TextView) findViewById(R.id.txt_apellidos);
        TextView lblactividad = (TextView) findViewById(R.id.txt_actividad);
        TextView lblnivel = (TextView) findViewById(R.id.txt_nivel);
        TextView lblmodulo = (TextView) findViewById(R.id.txt_modulo);

        lblid.setText(id_persona);
        lblnombre.setText(nombre);
        lblapellidos.setText(apellidos);
        lblactividad.setText(actividad);
        lblnivel.setText(nivel);
        lblmodulo.setText(modulo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vista_individual, menu);
        return true;
    }



}
