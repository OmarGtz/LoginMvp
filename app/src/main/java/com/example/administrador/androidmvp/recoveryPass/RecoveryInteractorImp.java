package com.example.administrador.androidmvp.recoveryPass;

import com.example.administrador.androidmvp.data.api.ApiDrgo;
import com.example.administrador.androidmvp.data.api.ServiceGeneratorDrGo;
import com.example.administrador.androidmvp.utils.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrador on 09/10/17.
 */

public class RecoveryInteractorImp implements RecoveryInteractor{


    @Override
    public void onSendEmailRecovery(ApiDrgo api, String email, final OnSendEmailRecovery onsendEmail) {

        api = ServiceGeneratorDrGo.createService();
        api.envioCorreoElectronico(Constants.CLAVE_APP,email).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                onsendEmail.onSendEmail();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                onsendEmail.onErrorConection();
            }
        });
    }
}
