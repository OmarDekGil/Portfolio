package com.example.registroactividadesfisicas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MiAdaptador extends BaseAdapter {
    ArrayList<Lugares> sitios; //Replica de los datos
    Context dondePinto; //En que activity voy a pintar

    public MiAdaptador(ArrayList<Lugares> chimpos, Context dondePinto) {
        this.sitios = chimpos;
        this.dondePinto = dondePinto;
    }

    public int getCount() {
        return sitios.size();
    }


    public Lugares getItem(int position) {
        return sitios.get(position);
    }


    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View viewInflado = LayoutInflater.from(dondePinto).inflate(R.layout.descripcion,null);
        Lugares  pokeAux = getItem(position);
        ImageView imgS = viewInflado.findViewById(R.id.imgSitio);
        TextView txtName =  viewInflado.findViewById(R.id.txtKm);
        TextView txtKm =  viewInflado.findViewById(R.id.txtNombre);
        imgS.setImageResource(pokeAux.getTipoLugar());
        txtName.setText(pokeAux.getNombre());
        txtKm.setText(pokeAux.getKm());

        return viewInflado;
    }

    public void eliminarItem(int position) {
        if (position >= 0 && position < sitios.size()) {
            sitios.remove(position); // Elimina el elemento en la posición indicada

            // Notifica al adaptador que los datos han cambiado
            notifyDataSetChanged();
        }
    }
}
