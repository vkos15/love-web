package com.valya.app;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class BaseLogin {


    public void loginSite(String site, String log, String pass) {
        LoginPage page = new LoginPage();
        page.openLoginForm(site);
        page.typeLogin(log);
        page.TypePassword(pass);
        page.clickLogin();
    }
}
