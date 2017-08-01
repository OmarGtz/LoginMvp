package com.example.administrador.androidmvp.Login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.androidmvp.Main.MainActivity;
import com.example.administrador.androidmvp.R;
import com.example.administrador.androidmvp.Register.RegisterActivity;
import com.example.administrador.androidmvp.recoveryPass.RecoveryActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    EditText inputUser;
    EditText inpurPass;
    Button btnIniciar;
    TextView tvRegister;
    TextView tvRecoveryPass;
    LoginPresenter presenter;
    TextInputLayout inputLayoutMail;
    TextInputLayout inputLayoutPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUser = (EditText)findViewById(R.id.login_input_user);
        inpurPass = (EditText)findViewById(R.id.login_input_pass);
        btnIniciar = (Button)findViewById(R.id.login_btn_iniciar);
        tvRegister = (TextView)findViewById(R.id.login_tv_registrarse);
        tvRecoveryPass = (TextView)findViewById(R.id.login_tv_recovery);
        inputLayoutMail = (TextInputLayout)findViewById(R.id.input_layout_correo);
        inputLayoutPass = (TextInputLayout)findViewById(R.id.input_layout_pas);

        btnIniciar.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvRecoveryPass.setOnClickListener(this);
        presenter = new LoginPresenterImp(this);
    }

    @Override
    public void goToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void setUserNameError() {

        inputLayoutMail.setError("correo invalido");

    }

    @Override
    public void setPasswordError() {


        inputLayoutPass.setError("contraseña invalida");
    }

    @Override
    public void goToRegister() {

        startActivity(new Intent(this, RegisterActivity.class));
        Toast.makeText(this,"RegisterActivity",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToRecoveryPassword() {

        startActivity(new Intent(this, RecoveryActivity.class));
        Toast.makeText(this,"RecoveryPassword",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClickBtnLogin() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_tv_registrarse:
                presenter.goToRegister();
                break;

            case R.id.login_tv_recovery:
                presenter.goToRecovery();
                break;

            case R.id.login_btn_iniciar:
                presenter.ValidCredentials(inputUser.getText().toString(),inpurPass.getText().toString());
                break;
        }

    }
}
