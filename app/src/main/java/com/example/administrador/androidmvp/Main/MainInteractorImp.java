package com.example.administrador.androidmvp.Main;

import com.example.administrador.androidmvp.Data.local.PreferencesManager;
import com.example.administrador.androidmvp.Data.local.preferencesManagerImpl;

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
