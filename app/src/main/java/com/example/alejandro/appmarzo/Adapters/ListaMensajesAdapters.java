package com.example.alejandro.appmarzo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alejandro.appmarzo.FBObject.Mensaje;
import com.example.alejandro.appmarzo.R;

import java.util.ArrayList;

/**
 * Created by alejandro on 25/2/18.
 */


public class ListaMensajesAdapters extends RecyclerView.Adapter<MensajeViewHolder> {

    private ArrayList<Mensaje> mensajes;

    public ListaMensajesAdapters(ArrayList<Mensaje> mensajes){
        this.mensajes=mensajes;

    }


    @Override
    public MensajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_mensaje_layout, null);
        MensajeViewHolder mensajeViewHolder = new MensajeViewHolder(view);
        return mensajeViewHolder;
    }

    @Override
    public void onBindViewHolder(MensajeViewHolder holder, int position) {
        holder.textomensaje.setText(mensajes.get(position).original);

    }

    @Override
    public int getItemCount() {
        return mensajes.size();
    }
}
class MensajeViewHolder extends RecyclerView.ViewHolder{

    public TextView textomensaje;


    public MensajeViewHolder(View itemView) {
        super(itemView);
        textomensaje=itemView.findViewById(R.id.textomensaje);
    }
}