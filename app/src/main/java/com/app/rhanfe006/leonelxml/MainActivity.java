package com.app.rhanfe006.leonelxml;


import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends ListActivity {

    // se declaran las variables estaticas
    static final String URL = "http://eulisesrdz.260mb.net/ranfe/bbdd.xml";
    // XML node keys
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
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element
        NodeList nl = doc.getElementsByTagName(KEY_REGISTRO);
        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_ID, "ID PERSONA:"+" " + parser.getValue(e, KEY_ID));
            map.put(KEY_NOMBRE, "NOMBRE:"+ " " + parser.getValue(e, KEY_NOMBRE));
            map.put(KEY_APELLIDOS, "APELLIDOS:"+" "+ parser.getValue(e, KEY_APELLIDOS));
            map.put(KEY_ACTIVIDAD, "ACTIVIDAD:"+" "+ parser.getValue(e, KEY_ACTIVIDAD));
            map.put(KEY_NIVEL, "NIVEL:"+ " " + parser.getValue(e, KEY_NIVEL));
            map.put(KEY_MODULO, "MODULO" +" " + parser.getValue(e, KEY_MODULO));

            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.lista_contactos,
                new String[] { KEY_ID, KEY_NOMBRE, KEY_APELLIDOS, KEY_ACTIVIDAD, KEY_NIVEL, KEY_MODULO}, new int[] {
                R.id.txt_l_idpersona, R.id.txt_l_nombre, R.id.txt_l_apellidos,R.id.txt_l_actividad, R.id.txt_l_nivel, R.id.txt_l_modulo});

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String id_persona = ((TextView) view.findViewById(R.id.txt_l_idpersona)).getText().toString();
                String nombre = ((TextView) view.findViewById(R.id.txt_l_nombre)).getText().toString();
                String apellidos = ((TextView) view.findViewById(R.id.txt_l_apellidos)).getText().toString();
                String actividad = ((TextView) view.findViewById(R.id.txt_l_actividad)).getText().toString();
                String nivel = ((TextView) view.findViewById(R.id.txt_l_nivel)).getText().toString();
                String modulo = ((TextView) view.findViewById(R.id.txt_l_modulo)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), vista_individual.class);
                in.putExtra(KEY_ID, id_persona);
                in.putExtra(KEY_NOMBRE, nombre);
                in.putExtra(KEY_APELLIDOS,apellidos);
                in.putExtra(KEY_ACTIVIDAD,actividad);
                in.putExtra(KEY_NIVEL,nivel);
                in.putExtra(KEY_MODULO,modulo);
                startActivity(in);

            }
        });
    }

}

