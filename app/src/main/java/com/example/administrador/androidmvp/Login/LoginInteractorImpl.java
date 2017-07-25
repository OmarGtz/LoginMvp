package com.example.administrador.androidmvp.Login;

import android.content.Intent;

/**
 * Created by Administrador on 20/07/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void Login(String user, String pass, onLoginLister lister) {

        boolean error = false;
        if(user.isEmpty()){
            lister.onErrorUserLogin();

        }else if (pass.isEmpty()){
            lister.onErrorPassLogin();

        }else {
            lister.onSucessLogin();
        }

    }

    @Override
    public void goToRecovery() {

    }

    @Override
    public void gotoRegister() {

    }
}
