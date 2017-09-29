package com.example.administrador.androidmvp.login;

/**
 * Created by Administrador on 20/07/17.
 */

public interface LoginView {
    void goToMain();
    void showProgress();
    void showErrorLogin();
    void hideProgress();
    void initViews();
    void goToRegister();
    void goToRecovery();
    void setErrorEmptyUser();
    void noErrorPass();
    void onClickListener();
    void noErrorMail();
    void setErrorEmptyPassword();
    void setErrorInvalidMail();

}
