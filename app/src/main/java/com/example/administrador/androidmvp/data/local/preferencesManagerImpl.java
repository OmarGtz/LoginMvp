package com.example.administrador.androidmvp.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrador on 28/09/17.
 */

public class preferencesManagerImpl implements  PreferencesManager{
    private final SharedPreferences preferencesDrgo;


    public static final String PREFERENCES_KEY_USER = "user";
    public static final String PREFERENCES_KEY_PASS = "pass";
    public static final String PREFERENCES_KEY_TOKEN = "token";
    public static final String PREFERENCES_KEY_PREFERENCES_DRGO = "preferencesDrgoPaciente";

    public preferencesManagerImpl(Context context){

        preferencesDrgo = context.getSharedPreferences(PREFERENCES_KEY_PREFERENCES_DRGO,Context.MODE_PRIVATE);

    }

    @Override
    public void savePreferencesUser(String value) {
        preferencesDrgo.edit()
                .putString(PREFERENCES_KEY_USER,value)
                .apply();
    }

    @Override
    public void savePreferencesPass(String value) {

        preferencesDrgo.edit()
                .putString(PREFERENCES_KEY_PASS,value)
                .apply();

    }

    @Override
    public void savePreferencesToken(String value) {
        preferencesDrgo
                .edit()
                .putString(PREFERENCES_KEY_TOKEN, value)
                .apply();

    }

    @Override
    public void deletePreferencesUser() {

        preferencesDrgo.edit()
                .remove(PREFERENCES_KEY_USER)
                .apply();

    }

    @Override
    public void deletePreferencePass() {

        preferencesDrgo.edit()
                .remove(PREFERENCES_KEY_PASS)
                .apply();
    }

    @Override
    public void deletePreferencesToken() {

        preferencesDrgo.edit()
                .remove(PREFERENCES_KEY_TOKEN)
                .apply();

    }

    @Override
    public String getPreferencesUser() {

        return preferencesDrgo.getString(PREFERENCES_KEY_USER,"");
    }

    @Override
    public String getPreferencesPass() {

        return  preferencesDrgo.getString(PREFERENCES_KEY_PASS,"");
    }

    @Override
    public String getPreferencesToken() {

        return preferencesDrgo.getString(PREFERENCES_KEY_TOKEN,"");
    }
}
