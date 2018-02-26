package com.example.milib.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by alejandro on 26/2/18.
 */

public class HttpAsyncTask extends AsyncTask<String, Integer, Void> {

    public HttpAsyncTask(){

    }

    @Override
    protected void onPreExecute() {
        Log.v("HttpAsyncTask", "DEFINIMOS LAS VARIABLES PREVIAS");

        super.onPreExecute();
    }



    @Override
    protected Void doInBackground(String... strings) {
        this.publishProgress(10);
        Log.v("HttpAsyncTask", "FASE 1"+strings[0]);

        this.publishProgress(20);
        Log.v("HttpAsyncTask", "FASE 2"+strings[0]);

        this.publishProgress(60);
        Log.v("HttpAsyncTask", "FASE 3"+strings[0]);

        this.publishProgress(100);
        Log.v("HttpAsyncTask", "FASE 4"+strings[0]);
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        Log.v("HttpAsyncTask", "PORCENTAJE DE PROGRESO: "+values[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.v("HttpAsyncTask", "SE TERMINO LA TAREA");

        super.onPostExecute(aVoid);
    }
}
