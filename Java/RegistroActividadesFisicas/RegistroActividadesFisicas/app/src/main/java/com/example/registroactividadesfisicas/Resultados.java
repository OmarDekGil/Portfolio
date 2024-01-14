package com.example.registroactividadesfisicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Resultados extends AppCompatActivity {
    ListView lista;
    Gson gson;
    SharedPreferences shared;
    String km, nombre;
    int lugar;
    MiAdaptador adapter;
    ArrayList <Lugares> sitios = new ArrayList<Lugares>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        lista = findViewById(R.id.lista);
        // Inicializar SharedPreferences
        shared = getSharedPreferences("MiPrefs", Context.MODE_PRIVATE);

        // Inicializar Gson
        gson = new Gson();

        Iniciar();
    }
    void Iniciar(){
        recuperarListaDesdeSharedPreferences();
        Intent i = getIntent();
        km =i.getStringExtra("km");
        nombre = i.getStringExtra("nombre");
       lugar = i.getIntExtra("tipoLugar",0);

        Log.d("Resultados", "Valor de km: " + km);
        Log.d("Resultados", "Valor de nombre: " + nombre);
        Log.d("Resultados", "Valor de lugar: " + lugar);
        if (lugar == 1) {
            sitios.add(new Lugares(km, nombre,R.drawable.playa));
        } else if (lugar==3) {
            sitios.add(new Lugares(km, nombre,R.drawable.montana));
        } else if (lugar==2) {
            sitios.add(new Lugares(km, nombre,R.drawable.urbano));
        }

        adapter = new MiAdaptador(sitios, this);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chimpos);

        lista.setAdapter(adapter);
        // Llamar al método para guardar la lista en SharedPreferences
        guardarListaEnSharedPreferences();
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Llama al método eliminarItem del adaptador
                adapter.eliminarItem(position);

                // Actualiza las SharedPreferences después de la eliminación si es necesario
                guardarListaEnSharedPreferences();
            }
        });

    }
    private void guardarListaEnSharedPreferences() {
        String listaJson = gson.toJson(sitios);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("listaSitios", listaJson);
        editor.apply();
    }
    private void recuperarListaDesdeSharedPreferences() {
        String listaJson = shared.getString("listaSitios", "");

        if (!listaJson.isEmpty()) {
            Type listaType = new TypeToken<ArrayList<Lugares>>() {}.getType();
            sitios = gson.fromJson(listaJson, listaType);
        }
}

}