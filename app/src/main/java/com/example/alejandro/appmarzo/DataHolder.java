package com.example.alejandro.appmarzo;

/**
 * Created by alejandro on 25/2/18.
 */

public class DataHolder {

    public static DataHolder instance= new DataHolder();

    public FireBaseAdmin fireBaseAdmin;

    public DataHolder(){
        fireBaseAdmin = new FireBaseAdmin();
    }
}
