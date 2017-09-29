package com.example.administrador.androidmvp.main;

import com.example.administrador.androidmvp.data.local.PreferencesManager;

/**
 * Created by Administrador on 29/09/17.
 */

public class MainPresenterImpl implements MainPresenter{

    MainView mainView;
    PreferencesManager preferencesManager;
    MainInteractor mainInteractor;

    MainPresenterImpl(MainView mainView, PreferencesManager preferencesManager){
        this.mainView = mainView;
        this.preferencesManager = preferencesManager;
        mainInteractor = new MainInteractorImp(preferencesManager);
    }


    @Override
    public void getPreferencesUser() {
        mainInteractor.onGetPreferencesUser(new MainInteractor.OnPreferences() {
            @Override
            public void onPreferencesSucess(String user, String pass) {
                mainView.showUser(user);
                mainView.showPass(pass);
            }

            @Override
            public void onPreferencesError() {

            }
        });
    }
}
