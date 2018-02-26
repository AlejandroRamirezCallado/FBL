package com.example.alejandro.appmarzo.FBObject;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;

/**
 * Created by alejandro on 26/2/18.
 */

@IgnoreExtraProperties
public class Mensajes {
    public HashMap<String, Mensaje> msgs;

    public Mensajes(){

    }

    public Mensajes(HashMap<String, Mensaje> msgs){
        this.msgs=msgs;
    }
}
