package com.valya.app;

import org.junit.Test;
import sun.rmi.runtime.Log;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationVkTest {

    private RegistrationVkPage vkPage = new RegistrationVkPage();
    private RegistrationPage regPage = new RegistrationPage();
    String url="https://love.ru/";

    @Test
    public void registrationVkTestMultipleChoice(){
        regPage.Opensite(url);
        String winHandleBefore = getWebDriver().getWindowHandle();
        vkPage.openVkAutorization();
        vkPage.autorizationVK("89125825296","ar347b7");
        getWebDriver().switchTo().window(winHandleBefore);
        LoginPage lp=new LoginPage();
        lp.checkAtPage("");


    }
}
