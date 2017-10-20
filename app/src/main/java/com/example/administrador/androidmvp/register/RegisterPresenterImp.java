package com.example.administrador.androidmvp.register;

import android.media.MediaCodec;
import android.sax.RootElement;
import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Administrador on 09/10/17.
 */

public class RegisterPresenterImp implements RegisterPresenter{

    RegisterView registerView;

     RegisterPresenterImp(RegisterView registerView){
        this.registerView = registerView;
    }


    @Override
    public void registerUser(String name, String lastName, String mail, String pass, String confirmPass, int genere,boolean terms) {
               if(name.isEmpty()){
                   registerView.setErrorNameEmpty();

        }else if(lastName.isEmpty()){
                   registerView.setErrorLastname();

        }else if(mail.isEmpty()){
                   registerView.setErrorMailEmpty();

        }else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                   registerView.setErrorMailInvalid();

        }else if(pass.isEmpty()){
                   registerView.setErrorPassEmpty();

        }else if(!pass.equals(confirmPass)){
                   registerView.setErrorPassNoEquals();

        }else if (genere==0){
                   registerView.setErrorGenere();
        }else if(!terms){
                   registerView.setErrorTerms();

               }else {
                   registerView.goToMain();
               }
    }

    @Override
    public void onCreate() {
        registerView.initViews();
        registerView.setToolbar();
    }

    @Override
    public void onStart() {
        registerView.setListerners();

    }

    @Override
    public void goToPoliticas(String text) {
        registerView.showPoliticas(text);

    }
}
