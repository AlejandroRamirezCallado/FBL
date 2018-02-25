package com.example.alejandro.appmarzo;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.transition.Transition;
import android.util.Log;
import android.widget.Toast;

import com.example.milib.LoginFragment;
import com.example.milib.LoginFragmentListener;
import com.example.milib.RegisterFragment;
import com.example.milib.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {

    LoginFragment loginFragment;
    RegisterFragment registerFragment;
   // FireBaseAdmin fireBaseAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        registerFragment=(RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegister);
        MainActivityEvents mainActivityEvents=new MainActivityEvents(this);

        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.show(loginFragment);
        transaction.hide(registerFragment);
        transaction.commit();

       // fireBaseAdmin = new FireBaseAdmin();
        DataHolder.instance.fireBaseAdmin.setListener(mainActivityEvents);


        DataHolder.instance.fireBaseAdmin.loginConEmailYPassword("hola@hola.com", "1234567890", this);
    }
}


class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener{
    MainActivity mainActivity;
    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Override
    public void loginFragmentLoginButtonClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.loginConEmailYPassword(sUser, sPass, mainActivity);

    }

    @Override
    public void loginFragmentRegisterButtonClicked() {

        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.hide(mainActivity.loginFragment);
        transaction.show(mainActivity.registerFragment);
        transaction.commit();

    }

    @Override
    public void registerFragmentBtnAceptarClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.registerConEmailYPassword(sUser, sPass, mainActivity);

    }

    @Override
    public void registerFragmentBtnCancelarClicked() {

        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.show(mainActivity.loginFragment);
        transaction.hide(mainActivity.registerFragment);
        transaction.commit();

    }

    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS", "RESULTADO DE REGISTER" + blOK);
        if(blOK){
            Intent intent = new Intent(mainActivity, SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
    }

    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS", "RESULTADO DE REGISTER" + blOK);
        if(blOK){
            Intent intent = new Intent(mainActivity, SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();

        }
        else {

        }
    }
}