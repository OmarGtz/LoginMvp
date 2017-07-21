package com.example.administrador.androidmvp.Login;

/**
 * Created by Administrador on 20/07/17.
 */

public interface LoginView {

    void goToMain();
    void showProgress();
    void setUserName();
    void setPasswordError();
    void goToRegister();
    void goToRecoveryPassword();


}
