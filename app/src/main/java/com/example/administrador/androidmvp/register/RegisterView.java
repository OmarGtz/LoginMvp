package com.example.administrador.androidmvp.register;

/**
 * Created by Administrador on 09/10/17.
 */

public interface RegisterView {

    public void initViews();
        void setToolbar();
        void setListerners();
        void setErroRegister(String error);
        void goToMain();
        void showPoliticas(String text);
        void setErrorNameEmpty();
        void setErrorLastname();
        void setErrorMailEmpty();
        void setErrorMailInvalid();
        void setErrorPassEmpty();
        void setErrorPassNoEquals();
        void setErrorGenere();
        void setErrorTerms();
}
