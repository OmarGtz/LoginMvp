package com.example.administrador.androidmvp.splashScreen;


import com.example.administrador.androidmvp.data.local.PreferencesManager;

/**
 * Created by Administrador on 28/09/17.
 */

public class SplashInteractorImp implements  SplashInteractor {
    @Override
    public void onPreferencesSave(PreferencesManager preferencesDrgo, OnNavigation onNavigation) {

        String user = preferencesDrgo.getPreferencesUser();
        String pass = preferencesDrgo.getPreferencesPass();

        if(user.isEmpty()&&pass.isEmpty()){

            onNavigation.onLoginNoSave();
        }
        else {

            onNavigation.onLoginSave();
        }

    }
}
