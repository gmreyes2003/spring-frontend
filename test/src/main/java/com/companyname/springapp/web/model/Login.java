package com.companyname.springapp.web.model;

import java.io.Serializable;

public class Login implements Serializable {

    private String mail;
    private String password;
    private String check;

    public Login() {
    }

    public Login(String mail, String password, String check) {
        this.mail = mail;
        this.password = password;
        this.check = check;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Login{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", check='" + check + '\'' +
                '}';
    }
}
