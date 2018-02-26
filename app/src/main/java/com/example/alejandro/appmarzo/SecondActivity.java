package com.example.alejandro.appmarzo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Log.v("SECONDACTIVITY", "------Email del usuario: " + DataHolder.instance.fireBaseAdmin.user.getEmail());



    }
}

class SecondActivityEvents implements FireBaseAdminListener{



    @Override
    public void fireBaseAdmin_RamaDescargargada(String rama, DataSnapshot dataSnapshot) {

    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {

    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {

    }
}