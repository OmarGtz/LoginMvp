package com.example.administrador.androidmvp.recoveryPass;

import android.util.Patterns;

/**
 * Created by Administrador on 09/10/17.
 */

public class RecoveryPresenterImp implements RecoveryPresenter {

    RecoveryView recoveryView;

    RecoveryPresenterImp(RecoveryView recoveryView){
        this.recoveryView = recoveryView;
    }

    @Override
    public void onCreate() {
        recoveryView.initViews();
        recoveryView.setToolbar();
    }

    @Override
    public void sendEmailRecovery(String email) {
        if(email.isEmpty()){

            recoveryView.showErrorMailEmpty();
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            recoveryView.showErrorEmailInvalid();
        }else {
            recoveryView.showMailValid();
            recoveryView.showEmailSend();
        }

    }
}
