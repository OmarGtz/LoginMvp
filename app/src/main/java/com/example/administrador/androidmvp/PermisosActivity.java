package com.example.administrador.androidmvp;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrador.androidmvp.login.LoginActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermisosActivity extends AppCompatActivity implements View.OnClickListener {



    Button btnAceptar;
    public static final int PERMISSION_FINE_LOCATION = 1;
    public static final int PERMISSION_CAMERA = 2;
    public static final int PERMISSION_EXTERNAL_STORAGE = 3;
    public static final int PERMISSION_CALL = 4;
    public static final int MY_PERMISSION = 100;
    SharedPreferences preferencesDrgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);
        btnAceptar = (Button)findViewById(R.id.permission_btn_iniciar);
        preferencesDrgo = getSharedPreferences("preferencesDrgoPaciente", Context.MODE_PRIVATE);
        Log.e("permission",preferencesDrgo.getBoolean("permission",false)+"");


    }

    @Override
    protected void onStart() {
        super.onStart();
        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        checkAndRequestPermissions();

    }


    private boolean checkAndRequestPermissions() {
        int permissionCAMERA = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int permissionLocation = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
        int permissionCall = ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE);
        int permissionStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        if (permissionStorage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (permissionCAMERA != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if(permissionLocation != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(permissionCall != PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.CALL_PHONE);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MY_PERMISSION);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Log.d("permission", "Permission callback called-------");
        switch (requestCode) {

            case MY_PERMISSION:
                Map<String, Integer> perms = new HashMap<>();
                // Fill with actual results from user

                if (grantResults.length > 0) {

                    Log.e("permissions",perms.toString());
                    for (int i = 0;i<permissions.length;i++){
                        perms.put(permissions[i],grantResults[i]);

                        if(perms.get(permissions[i])!=PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"es necesario conceder todos los permisos",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    savePreferencesPermission(true);
                    goToLogin();
                }
                Log.e("permissions",perms.toString());
                break;
        }
        }

        public void savePreferencesPermission(boolean granted){

            preferencesDrgo.edit()
                    .putBoolean("permission",granted)
                    .apply();

        }

        void goToLogin(){

            Intent intenLogin = new Intent(this, LoginActivity.class);
            startActivity(intenLogin);
        }
    }
