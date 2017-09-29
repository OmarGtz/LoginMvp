package com.example.administrador.androidmvp.main;

import com.example.administrador.androidmvp.data.local.PreferencesManager;

/**
 * Created by Administrador on 25/07/17.
 */

public class MainInteractorImp implements MainInteractor {

    private PreferencesManager preferencesManager;

    MainInteractorImp(PreferencesManager preferencesManager){

        this.preferencesManager = preferencesManager;

    }


    @Override
    public void onGetPreferencesUser(OnPreferences onPreferences) {
        if(!preferencesManager.getPreferencesUser().isEmpty()){
            onPreferences.onPreferencesSucess(preferencesManager.getPreferencesUser(),preferencesManager.getPreferencesPass());
        }else{
            onPreferences.onPreferencesError();
        }
    }
}
