package com.example.alejandro.appmarzo.FBObject;

/**
 * Created by alejandro on 26/2/18.
 */

public class FBCoche {

    public int Fabricado;
    public String Marca;
    public String Nombre;
    public double lat;
    public double lon;

    public FBCoche(){

    }

    public FBCoche(int Fabricado,String Marca,String Nombre,double lat,double lon){
        this.Fabricado=Fabricado;
        this.Marca=Marca;
        this.Nombre=Nombre;
        this.lat=lat;
        this.lon=lon;

    }
}
