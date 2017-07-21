package com.example.administrador.androidmvp.Login;

/**
 * Created by Administrador on 20/07/17.
 */

public interface LoginInteractor {

    public interface onLoginLister{
        void onErrorUserLogin();
        void onSucessLogin();
        void onErrorPassLogin();

    }


    void Login(String user,String pass,onLoginLister lister);



}
