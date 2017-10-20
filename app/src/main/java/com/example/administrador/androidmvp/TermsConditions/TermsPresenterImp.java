package com.example.administrador.androidmvp.TermsConditions;

/**
 * Created by Administrador on 09/10/17.
 */

public class TermsPresenterImp implements TermsPresenter {

    private TermsView termsView;

    TermsPresenterImp(TermsView termsView){
        this.termsView = termsView;
    }

    @Override
    public void onCreate() {
        termsView.getArgsTerms();

    }

    @Override
    public void onStart() {

        termsView.setListener();
    }

    @Override
    public void changeTextTerms() {
        if(termsView!=null){
            termsView.setTextPoliticas();
        }
    }

    @Override
    public void onCreateView() {
        termsView.initViews();
    }


}
