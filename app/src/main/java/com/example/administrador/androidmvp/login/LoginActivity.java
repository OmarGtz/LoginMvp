package com.example.administrador.androidmvp.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrador.androidmvp.data.local.PreferencesManager;
import com.example.administrador.androidmvp.data.local.preferencesManagerImpl;
import com.example.administrador.androidmvp.main.MainActivity;
import com.example.administrador.androidmvp.R;
import com.example.administrador.androidmvp.register.RegisterActivity;
import com.example.administrador.androidmvp.recoveryPass.RecoveryActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    //views
    private Button btnIniciar;
    private EditText inputUsuario;
    private EditText inputPass;
    private TextView tvRegistrarse;
    private TextInputLayout inputLayoutCorreo;
    private TextInputLayout inputLayoutPass;
    private ProgressDialog progressDialog;
    AppCompatCheckBox cb;

    //variables
    private String user;
    private String pass;
    private PreferencesManager preferencesManager;
    private TextView tvRecovery;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferencesManager = new preferencesManagerImpl(this);
        presenter = new LoginPresenterImp(this,preferencesManager);
        presenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void goToMain() {

        Intent intentMain = new Intent(this,MainActivity.class);
        intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intentMain);

    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.login_text_progres_bar_text));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void showErrorLogin() {

        Toast.makeText(this,"Correo o contraseña invalidos",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void initViews() {
        inputLayoutCorreo = (TextInputLayout)findViewById(R.id.login_input_layout_correo);
        inputLayoutPass = (TextInputLayout)findViewById(R.id.login_input_layout_pas);
        btnIniciar = (Button)findViewById(R.id.login_btn_iniciar);
        tvRegistrarse = (TextView)findViewById(R.id.login_tv_registrarse);
        tvRecovery = (TextView)findViewById(R.id.login_tv_recovery);
        inputUsuario = (EditText)findViewById(R.id.login_input_user);
        inputPass = (EditText)findViewById(R.id.login_input_pass);

    }

    @Override
    public void goToRegister() {

        Intent intentRegister = new Intent(this,RegisterActivity.class);
        startActivity(intentRegister);

    }

    @Override
    public void goToRecovery() {
        Intent intentRecovery = new Intent(this,RecoveryActivity.class);
        startActivity(intentRecovery);
    }

    @Override
    public void setErrorEmptyUser() {

        inputLayoutCorreo.setError(getResources().getString(R.string.login_text_mail_empty));

    }

    @Override
    public void noErrorPass() {

        //si no es vacio y es un correo valido error es null
        inputLayoutPass.setError(null);
    }

    @Override
    public void onClickListener() {
        btnIniciar.setOnClickListener(this);
        tvRegistrarse.setOnClickListener(this);
        tvRecovery.setOnClickListener(this);

    }

    @Override
    public void noErrorMail() {
        //si no es vacio y es un correo valido error es null
        inputLayoutCorreo.setError(null);
    }

    @Override
    public void setErrorEmptyPassword() {

        inputLayoutPass.setError(getResources().getString(R.string.login_text_pass_empty));

    }

    @Override
    public void setErrorInvalidMail() {
        inputLayoutCorreo.setError(getResources().getString(R.string.login_text_mail_invalid));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           // si se presiona iniciar sesion
           case R.id.login_btn_iniciar:
               presenter.validateLogin(inputUsuario.getText().toString(),inputPass.getText().toString());
                break;

            //si se presiona registrarse
            case R.id.login_tv_registrarse:
                presenter.goToRegister();
                break;

            case R.id.login_tv_recovery:
                presenter.goToRecovery();
                break;
        }
    }
}
