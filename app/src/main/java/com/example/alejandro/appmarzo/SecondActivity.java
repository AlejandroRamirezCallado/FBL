package com.example.alejandro.appmarzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.alejandro.appmarzo.Adapters.ListaMensajesAdapters;
import com.example.alejandro.appmarzo.FBObject.Mensaje;
import com.example.alejandro.appmarzo.FBObject.Mensajes;
import com.example.milib.ListaMensajesFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    ListaMensajesFragment listaMensajesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaMensajesFragment=(ListaMensajesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);

        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("messages");

        //Log.v("SECONDACTIVITY", "------Email del usuario: " + DataHolder.instance.fireBaseAdmin.user.getEmail());

       /* ArrayList<String> mdatos = new ArrayList<>();
        mdatos.add("Mensaje 1");
        mdatos.add("Mensaje 2");
        mdatos.add("Mensaje 3");
        mdatos.add("Mensaje 4");


        ListaMensajesAdapters listaMensajesAdapters = new ListaMensajesAdapters(mdatos);

        listaMensajesFragment.recyclerView.setAdapter(listaMensajesAdapters);
        */

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
       // Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
        GenericTypeIndicator<Map<String, Mensaje>> indicator = new GenericTypeIndicator<Map<String, Mensaje>>(){};
        Map<String, Mensaje> msgs = dataSnapshot.getValue(indicator);


        Log.v("SecondActivity", "MENSAJES CONTIENE: " + msgs.values());
        ListaMensajesAdapters listaMensajesAdapters = new ListaMensajesAdapters(new ArrayList<Mensaje>(msgs.values()));
        secondActivity.listaMensajesFragment.recyclerView.setAdapter(listaMensajesAdapters);


    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}