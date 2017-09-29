package com.example.administrador.androidmvp.login;

import android.util.Patterns;

/**
 * Created by Administrador on 20/07/17.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void Login(String user, String pass, final OnLoginListener onlogin) {

        if(user.isEmpty()){

            onlogin.onLoginUserEmpty();
        }else if (pass.isEmpty()){
            onlogin.onLoginPassEmpty();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()){
            onlogin.onLoginUserInvalid();
    }else {
            onlogin.onLoginSuceess();
        }


    }

}
