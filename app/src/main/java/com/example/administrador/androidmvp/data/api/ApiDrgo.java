package com.example.administrador.androidmvp.data.api;

import com.example.administrador.androidmvp.model.responseApi.ResponseLogin;
import com.example.administrador.androidmvp.model.responseApi.ResponseRegister;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiDrgo {

    // todos los POST deben de ir con @FormUrlEncoded
    @FormUrlEncoded
    @POST("DrGoWebAPI/api/Login")
    Call<ResponseLogin> verificaAceesoApp(@Field("ClaveAplicacion") String claveAplicacion,
                                          @Field("UsuarioAplicacion") String correoElectronico,
                                          @Field("Password") String password,
                                          @Field("DispositivoId") String dispositivoId);

    @FormUrlEncoded
    @POST("DrGoWebAPI/api/RegisterUser")
    Call<ResponseRegister> registroPaciente(@Field("ClaveAplicacion") String claveAplicacion,
                                            @Field("Nombre") String nombre,
                                            @Field("Apellidos") String apellidoPaterno,
                                            @Field("CorreoElectronico") String correoElectronico,
                                            @Field("Password") String password,
                                            @Field("SexoId") int sexoId);

    @FormUrlEncoded
    @POST("DrGoWebAPI/api/RecoveryPassword")
    Call<ResponseBody> envioCorreoElectronico(@Field("ClaveAplicacion") String claveAplicacion,
                                              @Field("CorreoElectronico") String correoElectronico);



}
