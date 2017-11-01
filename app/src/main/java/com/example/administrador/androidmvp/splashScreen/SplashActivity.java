package com.example.administrador.androidmvp.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrador.androidmvp.PermisosActivity;
import com.example.administrador.androidmvp.data.local.PreferencesManager;
import com.example.administrador.androidmvp.data.local.preferencesManagerImpl;
import com.example.administrador.androidmvp.login.LoginActivity;
import com.example.administrador.androidmvp.main.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashView{

    SplashPresenter presenter;
    private PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferencesManager = new preferencesManagerImpl(this);
        presenter = new SplashPresenterImp(this,preferencesManager);
        presenter.onCreate();
    }

    @Override
    public void goToMain() {
        Intent intenMain = new Intent(this, MainActivity.class);
        startActivity(intenMain);
    }

    @Override
    public void goToLogin() {
        Intent intentLogin = new Intent(this,LoginActivity.class);
        startActivity(intentLogin);
    }

    @Override
    public void goToPermissionManager() {
        Intent intentPermission = new Intent(this, PermisosActivity.class);
        startActivity(intentPermission);
    }
}