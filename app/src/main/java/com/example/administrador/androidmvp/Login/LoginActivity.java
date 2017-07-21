package com.example.administrador.androidmvp.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.androidmvp.Main.MainActivity;
import com.example.administrador.androidmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    EditText inputUser;
    EditText inpurPass;
    Button btnIniciar;
    TextView tvRegister;
    TextView tvRecoveryPass;
    LoginPresenter presenter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUser = (EditText)findViewById(R.id.login_input_user);
        inpurPass = (EditText)findViewById(R.id.login_input_pass);
        btnIniciar = (Button)findViewById(R.id.login_btn_iniciar);
        tvRegister = (TextView)findViewById(R.id.login_tv_registrarse);
        tvRecoveryPass = (TextView)findViewById(R.id.login_tv_recovery);

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

        Toast.makeText(this,"error user name",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void setPasswordError() {


        Toast.makeText(this,"Error pass",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToRegister() {

        Toast.makeText(this,"RegisterActivity",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToRecoveryPassword() {

        Toast.makeText(this,"RecoveryPassword",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClickBtnLogin() {

    }


    @Override
    public void onClick(View v) {
        presenter.ValidCredentials(inputUser.getText().toString(),inpurPass.getText().toString());

    }
}
