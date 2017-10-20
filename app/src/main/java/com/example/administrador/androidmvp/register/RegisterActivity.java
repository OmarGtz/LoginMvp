package com.example.administrador.androidmvp.register;

import android.support.annotation.IdRes;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrador.androidmvp.R;
import com.example.administrador.androidmvp.TermsConditions.TermsFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterView, View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {


    //EditText
    private EditText inputNombre;
    private EditText inputApellidos;
    private Toolbar toolbarRegistro;
    private EditText inputCorreo;
    private EditText inputPassword;
    private EditText inputRememberPassword;
    private AppCompatCheckBox cbPoliticas;
    RadioGroup rgSexo;
    private View v;

    RegisterPresenter presenter;

    private TextView tvPoliticas;
    private TextView tvLegal;
    private String name;
    private String lastName;
    private String mail;
    private String pass;
    private String confirmPass;
    private int genere;
    private boolean terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter = new RegisterPresenterImp(this);
        presenter.onCreate();

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_register,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.register_menu_enviar:
                name = inputNombre.getText().toString().trim();
                lastName = inputApellidos.getText().toString().trim();
                mail = inputCorreo.getText().toString().trim();
                pass = inputPassword.getText().toString().trim();
                confirmPass = inputRememberPassword.getText().toString().trim();
                presenter.registerUser(name, lastName,mail,pass,confirmPass,genere,terms);
                break;

            case android.R.id.home:
                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initViews() {

        //EditText
        inputNombre = (EditText)findViewById(R.id.register_input_name);
        inputApellidos = (EditText)findViewById(R.id.register_input_lastname);
        inputCorreo = (EditText)findViewById(R.id.register_input_mail);
        inputPassword = (EditText)findViewById(R.id.register_input_password);
        inputRememberPassword = (EditText)findViewById(R.id.register_input_confirm_password);
        rgSexo = (RadioGroup)findViewById(R.id.register_rg_sexo);
        cbPoliticas = (AppCompatCheckBox) findViewById(R.id.register_cb_terminos_condiciones);
        tvPoliticas = (TextView)findViewById(R.id.register_tv_privacidad);
        tvLegal = (TextView)findViewById(R.id.register_tv_legal);
        v = (ConstraintLayout)findViewById(R.id.register_content);

        //Button
    }

    @Override
    public void setToolbar() {
        toolbarRegistro = (Toolbar)findViewById(R.id.register_toolbar);
        setSupportActionBar(toolbarRegistro);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle("");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public void setListerners() {
        rgSexo.setOnCheckedChangeListener(this);
        tvPoliticas.setOnClickListener(this);
        tvLegal.setOnClickListener(this);
        cbPoliticas.setOnCheckedChangeListener(this);
    }

    @Override
    public void setErroRegister(String error) {

        Snackbar.make(v,getResources().getString(R.string.register_error_lastname_empty),Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void goToMain() {
        Snackbar.make(v,"Bienvenido",Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void showPoliticas(String text) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.register_content, TermsFragment.newInstance(text))
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void setErrorNameEmpty() {

        Snackbar.make(v,getResources().getString(R.string.register_error_name_empty),Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void setErrorLastname() {

        Snackbar.make(v,getResources().getString(R.string.register_error_lastname_empty),Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void setErrorMailEmpty() {

        Snackbar.make(v,getResources().getString(R.string.register_error_mail_empty),Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void setErrorMailInvalid() {

        Snackbar.make(v,getResources().getString(R.string.register_error_mail_no_valid),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorPassEmpty() {

        Snackbar.make(v,getResources().getString(R.string.register_error_pass_empty),Snackbar.LENGTH_SHORT).show();


    }

    @Override
    public void setErrorPassNoEquals() {
        Snackbar.make(v,getResources().getString(R.string.register_error_confirme_pass),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorGenere() {
        Snackbar.make(v,getResources().getString(R.string.register_error_sex_empty),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setErrorTerms() {
        Snackbar.make(v,getResources().getString(R.string.register_error_terms_no_acept),Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.register_tv_legal:
                presenter.goToPoliticas(getResources().getString(R.string.terms_aviso_de_privacidad));
                break;
            case R.id.register_tv_privacidad:
                presenter.goToPoliticas(getResources().getString(R.string.terms_aviso_de_privacidad));
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            terms = isChecked;
            presenter.goToPoliticas(getResources().getString(R.string.terms_terms_conditions));

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        switch (group.getCheckedRadioButtonId()){

            case R.id.rbGeneroFemenino:
                genere = 2;
                break;
            case R.id.rbGeneroMasculino:
                genere = 1;
                break;
        }
    }
}
