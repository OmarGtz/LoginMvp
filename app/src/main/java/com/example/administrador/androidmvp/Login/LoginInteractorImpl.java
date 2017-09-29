package com.example.administrador.androidmvp.Login;

import android.util.Patterns;

import com.example.administrador.androidmvp.Data.api.ApiDrgo;
import com.example.administrador.androidmvp.Data.api.ServiceGeneratorDrGo;
import com.example.administrador.androidmvp.model.responseApi.ResponseLogin;
import com.example.administrador.androidmvp.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
