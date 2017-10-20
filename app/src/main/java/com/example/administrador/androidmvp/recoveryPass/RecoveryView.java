package com.example.administrador.androidmvp.recoveryPass;

/**
 * Created by Administrador on 09/10/17.
 */

public interface RecoveryView {


    void initViews();
    void setToolbar();
    void showErrorConection();
    void showErrorMailEmpty();
    void showErrorEmailInvalid();
    void showErrorEmailNoFound();
    void showEmailSend();
    void showMailValid();
}
