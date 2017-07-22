package com.example.administrador.androidmvp.Login;

/**
 * Created by Administrador on 20/07/17.
 */

public class LoginPresenterImp implements LoginPresenter, LoginInteractor.onLoginLister{

    LoginView loginView;
    LoginInteractor loginInteractor;

    LoginPresenterImp(LoginView view){
        this.loginView = view;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void ValidCredentials(String mail, String pass) {

        loginInteractor.Login(mail,pass,this);

    }

    @Override
    public void onErrorUserLogin() {
        loginView.setUserNameError();
    }

    @Override
    public void onSucessLogin() {
        loginView.goToMain();
    }

    @Override
    public void onErrorPassLogin() {
        loginView.setPasswordError();

    }
}
