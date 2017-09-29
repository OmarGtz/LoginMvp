package com.example.administrador.androidmvp.Login;

/**
 * Created by Administrador on 20/07/17.
 */

public interface LoginPresenter {

    void onCreate();
    void onStart();
    void onPause();
    void onStop();
    void validateLogin(String user,String pass);
    void goToRegister();
    void goToRecovery();


}
