package com.example.administrador.androidmvp.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.administrador.androidmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    @Override
    public void goToMain() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void setUserName() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void goToRegister() {

    }

    @Override
    public void goToRecoveryPassword() {

    }
}
