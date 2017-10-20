package com.example.administrador.androidmvp.recoveryPass;

import com.example.administrador.androidmvp.data.api.ApiDrgo;

/**
 * Created by Administrador on 09/10/17.
 */

public interface RecoveryInteractor {

    interface OnSendEmailRecovery{
        void onSendEmail();
        void onErrorSendEmail();
        void onErrorConection();

    }

    void onSendEmailRecovery(ApiDrgo api, String email, OnSendEmailRecovery onsendEmail);
}
