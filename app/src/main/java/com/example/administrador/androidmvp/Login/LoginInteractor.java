package com.example.administrador.androidmvp.Login;

import com.example.administrador.androidmvp.model.responseApi.ResponseLogin;

/**
 * Created by Administrador on 20/07/17.
 */

public interface LoginInteractor {

    public interface OnLoginListener{

        void onLoginSuceess();
        void onLoginError();
        void onLoginUserEmpty();
        void onLoginUserInvalid();
        void onLoginPassEmpty();

    }

    void Login(String user, String pass,OnLoginListener onLoginListener);

}
