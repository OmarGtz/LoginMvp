package com.example.administrador.androidmvp.data.local;

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
        void  savePreferencesPermissions(boolean permissionGranted);
        boolean getPreferencesPermission();


}
