package com.valya.app;

import com.codeborne.selenide.Configuration;
import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import sun.rmi.runtime.Log;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationVkTest {

    private RegistrationVkPage vkPage = new RegistrationVkPage();
    private RegistrationPage regPage = new RegistrationPage();
   // String url="https://love.ru/";
    String url=System.getenv("URL");

    @BeforeTest
    public void setUp() {

        regPage.Opensite(url);
        Configuration.baseUrl=url;
    }

    @Test
    public void autorizationVkTestMultipleChoice(){
      //  regPage.Opensite(url);
        String winHandleBefore = getWebDriver().getWindowHandle();
        vkPage.openVkAutorization();
        vkPage.autorizationVK("89125825296","ar347b7");
        getWebDriver().switchTo().window(winHandleBefore);
        vkPage.chooseProfile("sergey862191");
        vkPage.submit();
        LoginPage lp=new LoginPage();
        lp.checkAtPage("sergey862191");
        BaseHelp help = new BaseHelp();
        help.deactivateOAuth("sergey862191");

    }

    @Test
    public void registrationVkTestWithoutEmail(){
        
    }








}
