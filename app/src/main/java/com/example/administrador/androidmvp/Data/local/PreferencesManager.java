package com.example.administrador.androidmvp.Data.local;

/**
 * Created by Administrador on 28/09/17.
 */

public interface PreferencesManager {

        void savePreferencesUser(String value);
        void savePreferencesPass(String value);
        void savePreferencesToken(String value);
        void deletePreferencesUser();
        void deletePreferencePass();
        void deletePreferencesToken();
        String getPreferencesUser();
        String getPreferencesPass();
        String getPreferencesToken();

}
