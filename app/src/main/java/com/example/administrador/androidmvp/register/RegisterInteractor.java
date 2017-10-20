package com.example.administrador.androidmvp.register;

import com.example.administrador.androidmvp.data.api.ApiDrgo;

/**
 * Created by Administrador on 09/10/17.
 */

public interface RegisterInteractor {

    void OnRegister(ApiDrgo api, String name, String lastname, String mail, String pass, int genere);


}
