package com.example.administrador.androidmvp.recoveryPass;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.androidmvp.R;
import com.example.administrador.androidmvp.register.RegisterPresenter;
import com.example.administrador.androidmvp.register.RegisterView;

public class RecoveryActivity extends AppCompatActivity implements RecoveryView{


    private EditText inputMail;
    private TextInputLayout inputLayoutMail;
    private Toolbar toolbar;
    RecoveryPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);
        presenter = new RecoveryPresenterImp(this);
        presenter.onCreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_recovery,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.recovery_menu_enviar:
                presenter.sendEmailRecovery(inputMail.getText().toString().trim());
                break;

            case android.R.id.home:
                onBackPressed();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initViews() {
        inputMail = (EditText)findViewById(R.id.recovery_input_user);
        inputLayoutMail = (TextInputLayout)findViewById(R.id.recovery_input_layout_correo);
    }

    @Override
    public void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.recovery_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){

            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("");

        }
    }

    @Override
    public void showErrorConection() {

        Toast.makeText(this,getResources().getString(R.string.recovery_error_envio),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showErrorMailEmpty() {

        inputLayoutMail.setError(getResources().getString(R.string.recovery_correo_vacio));
    }

    @Override
    public void showErrorEmailInvalid() {
        inputLayoutMail.setError(getResources().getString(R.string.recovery_correo_invalido));
    }

    @Override
    public void showErrorEmailNoFound() {
        Toast.makeText(this,getResources().getString(R.string.recovery_correo_no_registrado),Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showEmailSend() {

        Toast.makeText(this,getResources().getString(R.string.recovery_correo_enviado),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showMailValid() {

        inputLayoutMail.setError(null);

    }
}
