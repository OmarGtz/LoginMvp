package com.example.administrador.androidmvp.model.responseApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by administrador on 22/03/17.
 */

public class ResponseRegister {

    @SerializedName("Respuesta")
    private boolean Respuesta;

    public ResponseRegister(boolean respuesta) {
        Respuesta = respuesta;
    }

    public boolean isRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        Respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "ResponseRegister{" +
                "Respuesta=" + Respuesta +
                '}';
    }
}
