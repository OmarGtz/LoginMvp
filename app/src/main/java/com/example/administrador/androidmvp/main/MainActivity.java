package com.example.administrador.androidmvp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrador.androidmvp.data.local.PreferencesManager;
import com.example.administrador.androidmvp.data.local.preferencesManagerImpl;
import com.example.administrador.androidmvp.R;

public class MainActivity extends AppCompatActivity implements MainView{

    MainPresenter presenter;
    PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencesManager = new preferencesManagerImpl(this);
        presenter = new MainPresenterImpl(this,preferencesManager);
        presenter.getPreferencesUser();
    }

    @Override
    public void showUser(String user) {
        Toast.makeText(this,"user:"+user,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPass(String pass) {

        Toast.makeText(this,"pass:"+pass,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showPreferencesEmptyError() {

        Toast.makeText(this,"no se guardaron preferencias",Toast.LENGTH_SHORT).show();

    }

}
