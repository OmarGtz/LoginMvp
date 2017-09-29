package com.example.administrador.androidmvp.Data.api;

import com.example.administrador.androidmvp.Data.api.ApiDrgo;
import com.example.administrador.androidmvp.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by administrador on 21/03/17.
 */

public class ServiceGeneratorDrGo {
    // se crean instancias estaticas de RETROFIT para las clases que necesiten dichos recursos

    // estados
    private static Retrofit retrofit;
    private static Gson gson = new GsonBuilder().create();

    // configuracion básica Retrofit.
    // Gson, es un convertir de JSON a objetos java
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constants.URL_API)
            .addConverterFactory(GsonConverterFactory.create(gson));

    // si no existe intancia de Retrofit, se crea y se regresa. Si existe, se regresa
    public static ApiDrgo createService(){
        if(retrofit == null){
            retrofit = builder.build();
        }
        return retrofit.create(ApiDrgo.class);
    }
}


