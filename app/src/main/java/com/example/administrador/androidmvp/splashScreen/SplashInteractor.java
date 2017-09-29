package com.example.administrador.androidmvp.splashScreen;


import com.example.administrador.androidmvp.data.local.PreferencesManager;

/**
 * Created by Administrador on 28/09/17.
 */

public interface SplashInteractor {

    public interface OnNavigation{
        void onLoginSave();
        void onLoginNoSave();

    }


    void onPreferencesSave(PreferencesManager preferencesDrgo, OnNavigation onNavigation);


}
