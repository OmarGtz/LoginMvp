package com.example.administrador.androidmvp.model;

/**
 * Created by Administrador on 21/07/17.
 */

public class User {


    String email;
    String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
