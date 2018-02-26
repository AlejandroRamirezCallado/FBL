package com.example.alejandro.appmarzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alejandro.appmarzo.Adapters.ListaCochesAdapter;
import com.example.alejandro.appmarzo.Adapters.ListaMensajesAdapters;
import com.example.alejandro.appmarzo.FBObject.FBCoche;
import com.example.alejandro.appmarzo.FBObject.Mensaje;
import com.example.milib.ListaFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    ListaFragment listaFragmentMensajes, listaFragmentCoches;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaFragmentMensajes =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);
        listaFragmentCoches =(ListaFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaCoches);

        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("messages");
        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("Coches");



    }
}

class SecondActivityEvents implements FireBaseAdminListener{

    SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity){
        this.secondActivity=secondActivity;
    }


    @Override
    public void fireBaseAdmin_RamaDescargargada(String rama, DataSnapshot dataSnapshot) {
        Log.v("SecondActivity", rama + "----" + dataSnapshot);
        if(rama.equals("messages")){
            GenericTypeIndicator<Map<String, Mensaje>> indicator = new GenericTypeIndicator<Map<String, Mensaje>>(){};
            Map<String, Mensaje> msgs = dataSnapshot.getValue(indicator);


            Log.v("SecondActivity", "MENSAJES CONTIENE: " + msgs.values());
            ListaMensajesAdapters listaMensajesAdapters = new ListaMensajesAdapters(new ArrayList<Mensaje>(msgs.values()));
            secondActivity.listaFragmentMensajes.recyclerView.setAdapter(listaMensajesAdapters);

        }
        else if(rama.equals("Coches")){
            GenericTypeIndicator<ArrayList<FBCoche>> indicator = new GenericTypeIndicator<ArrayList<FBCoche>>(){};
            ArrayList<FBCoche> coches = dataSnapshot.getValue(indicator);


            Log.v("SecondActivity", "COCHES CONTIENE: "+coches);
            ListaCochesAdapter listaCochesAdapter = new ListaCochesAdapter(coches);
            secondActivity.listaFragmentCoches.recyclerView.setAdapter(listaCochesAdapter);

        }
       // Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);



    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}