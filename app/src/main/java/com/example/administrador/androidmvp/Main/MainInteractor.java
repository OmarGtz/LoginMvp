package com.example.administrador.androidmvp.Main;

/**
 * Created by Administrador on 25/07/17.
 */

public interface MainInteractor {


    interface OnPreferences{
        void onPreferencesSucess(String user,String pass);
        void onPreferencesError();

    }

    void onGetPreferencesUser(OnPreferences onPreferences);


}
