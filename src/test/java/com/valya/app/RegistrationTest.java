package com.valya.app;

import com.codeborne.selenide.Configuration;
//import org.junit.Test;
//import org.junit.Before;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationTest {

   private RegistrationPage regPage;

    @BeforeMethod
    public void setUp() {

        String url=System.getenv("URL");
        if (url==null)  { url= "https://love.ru" ;}
        regPage=new RegistrationPage();
        regPage.Opensite(url);
        Configuration.baseUrl=url;
    }

    @Test
    public void regEmailAlreadyExistTest(){
        String email="dfg@ml.rootkid.ru";
       // RegistrationPage regPage=new RegistrationPage();
       // regPage.Opensite();
        regPage.enterName("olga");
        regPage.enterEmail(email);
        regPage.clickSignUP();
       regPage.checkEmailError("Пользователь с таким E-Mail уже зарегистрирован");
        regPage.checkButtonWantLogthisprofile(email);
    }
    @Test
    public void regEmailIsEmptyTest(){
     //   RegistrationPage regPage=new RegistrationPage();
      //  regPage.Opensite();
        regPage.enterName("olga");
       // regPage.enterEmail("dfg@ml.rootkid.ru");
        regPage.clickSignUP();
        regPage.checkEmailError("Укажите E-Mail");
    }


    @Test
    public void regEmailIsInvalidTest(){
     //   RegistrationPage regPage=new RegistrationPage();
     //   regPage.Opensite();
        regPage.enterName("olga");
        regPage.enterEmail("h123вапв");
        regPage.clickSignUP();
        regPage.checkEmailError("Введите корректный E-Mail");
    }

    @Test
    public void nameIsEmptyEmailIsEmpty(){
        regPage.clickSignUP();
        regPage.checkEmailError("Укажите E-Mail");
        regPage.checkNameError("Укажите имя");
       // RegistrationPage regPage=new RegistrationPage();

    }
    @Test
    public void nameIsEmpty(){
        regPage.enterEmail("ihfhkjdf@ml.rootkid.ru");
        regPage.clickSignUP();
        regPage.checkNameError("Укажите имя");
        // RegistrationPage regPage=new RegistrationPage();

    }
    @Test
    public void nameIsOneSymbolEmailisIncorrect(){
        regPage.enterName("o");
        regPage.enterEmail("ihfh");
        regPage.clickSignUP();
        regPage.checkNameError("Укажите имя");
        regPage.checkEmailError("Введите корректный E-Mail");


    }
    @Test
    public void lengthNameIsMoreThan21(){
        regPage.checkMaxLengthName();

    }
    @Test
    public void nameIsBad(){
        //укажем недопустимое имя, например номер телефона
        regPage.enterName("898634567567");
       regPage.enterEmail("ih325fh2@ml.rootkid.ru");
        regPage.clickSignUP();
        sleep(10000);
       // open("#settings/profile");
        sleep(1000);
        SettingsPage setPage = new SettingsPage();
        setPage.openSettings();
        //если имя некорректное генерим имя - Самое лучшее имя на свете
        setPage.checkName("Лучшее имя на свете");

    }
 @AfterMethod
    public void closeDriver(){
     Selenide.closeWebDriver();
 }

}
