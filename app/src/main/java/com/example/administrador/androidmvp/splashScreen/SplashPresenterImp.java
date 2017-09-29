package com.example.administrador.androidmvp.splashScreen;

import com.example.administrador.androidmvp.data.local.PreferencesManager;

/**
 * Created by Administrador on 28/09/17.
 */

public class SplashPresenterImp implements SplashPresenter, SplashInteractor.OnNavigation {
    private final SplashView view;
    private final SplashInteractor interactor;
    PreferencesManager preferencesManager;


    SplashPresenterImp(SplashView view, PreferencesManager preferencesManager){
        this.view = view;
        this.interactor = new SplashInteractorImp();
        this.preferencesManager = preferencesManager;
    }


    @Override
    public void onCreate() {
        interactor.onPreferencesSave(preferencesManager,this);
    }

    @Override
    public void onLoginNoSave() {
        if(view!=null){

            view.goToLogin();
        }

    }

    @Override
    public void onLoginSave() {

        view.goToMain();
    }
}
