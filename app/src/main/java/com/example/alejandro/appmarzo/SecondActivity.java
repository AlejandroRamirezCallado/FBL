package com.example.alejandro.appmarzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.milib.ListaMensajesFragment;
import com.google.firebase.database.DataSnapshot;

public class SecondActivity extends AppCompatActivity {

    ListaMensajesFragment listaMensajesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        listaMensajesFragment=(ListaMensajesFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentListaMensajes);

        DataHolder.instance.fireBaseAdmin.descargarYObservarRama("messages/KSAKAS");

        //Log.v("SECONDACTIVITY", "------Email del usuario: " + DataHolder.instance.fireBaseAdmin.user.getEmail());



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


    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}