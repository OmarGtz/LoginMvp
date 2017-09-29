package com.example.administrador.androidmvp.login;

import com.example.administrador.androidmvp.data.local.PreferencesManager;


public class LoginPresenterImp implements LoginPresenter{


    private final LoginView loginView;
    private final PreferencesManager preferences;
    private final LoginInteractor loginInteractor;

    LoginPresenterImp(LoginView view, PreferencesManager preferences){

        this.loginView = view;
        this.preferences = preferences;
        loginInteractor = new LoginInteractorImpl();

    }

    @Override
    public void onCreate() {

        loginView.initViews();

    }

    @Override
    public void onStart() {

        loginView.onClickListener();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void validateLogin(final String user,final String pass) {
        loginView.showProgress();
        loginInteractor.Login(user, pass, new LoginInteractor.OnLoginListener() {
            @Override
            public void onLoginSuceess() {

                loginView.hideProgress();
                loginView.goToMain();
                preferences.savePreferencesPass(user);
                preferences.savePreferencesUser(pass);
            }

            @Override
            public void onLoginError() {

                loginView.hideProgress();
                loginView.showErrorLogin();
            }

            @Override
            public void onLoginUserEmpty() {
                loginView.setErrorEmptyUser();
            }

            @Override
            public void onLoginUserInvalid() {
                loginView.setErrorInvalidMail();

            }

            @Override
            public void onLoginPassEmpty() {
                loginView.setErrorEmptyPassword();

            }
        });
    }

    @Override
    public void goToRegister() {
        loginView.goToRegister();
    }

    @Override
    public void goToRecovery() {
        loginView.goToRecovery();

    }
}
