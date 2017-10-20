package com.example.administrador.androidmvp.register;

/**
 * Created by Administrador on 09/10/17.
 */

public interface RegisterPresenter {

    void registerUser(String name,String lastName, String mail, String pass,String confirmPass, int genere,boolean terms);
    void onCreate();
    void onStart();
    void goToPoliticas(String text);

}
