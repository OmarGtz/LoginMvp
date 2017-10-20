package com.example.administrador.androidmvp.TermsConditions;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrador.androidmvp.R;

/**
 * Created by Administrador on 09/10/17.
 */

public class TermsFragment extends Fragment implements TermsView, View.OnClickListener {

    public static final String ARG_TEXT_TERMS = "termsText";
    TextView tvTermsConditions;
    Button btnAceptar;
    View v;
    TermsPresenter presenter;
    String textTems;

    public static TermsFragment newInstance(String text){
        TermsFragment termsFragment = new TermsFragment();
        Bundle bundleTerms = new Bundle();
        bundleTerms.putString(ARG_TEXT_TERMS,text);
        termsFragment.setArguments(bundleTerms);

        return termsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TermsPresenterImp(this);
        presenter.onCreate();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_terms,container,false);
        presenter.onCreateView();
        presenter.changeTextTerms();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void initViews() {
        tvTermsConditions = (TextView) v.findViewById(R.id.terms_tv_politicas);
        btnAceptar = (Button) v.findViewById(R.id.terms_btn_aceptar);
    }

    @Override
    public void setListener() {
        btnAceptar.setOnClickListener(this);
    }

    @Override
    public void setTextPoliticas() {
        tvTermsConditions.setText(textTems);
    }

    @Override
    public void getArgsTerms() {
        if(getArguments()!=null){
            textTems = getArguments().getString(ARG_TEXT_TERMS);
        }
    }

    @Override
    public void onClick(View v) {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
