package com.valya.app;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class LoginTest {

 private   LoginPage logpage;

    @Before
    public void setUp() {
        String url="https://love.ru/";
        logpage = new LoginPage();
        logpage.openLoginForm(url);
        Configuration.baseUrl=url;
    }

@Test
public void LoginCorrectTest(){
    String  login="elena108097";
    String password ="1080977";

   // LoginPage logpage = new LoginPage();
    //logpage.openLoginForm();
    logpage.typeLogin(login);
    logpage.TypePassword(password);
    logpage.clickLogin();
    logpage.checkAtPage(login);

}
    @Test
    public void LoginnotexistTest(){
        String  login="1elena108097";
        String password ="1080977";
        // open("https://love.ru/");
       // LoginPage logpage = new LoginPage();
       // logpage.openLoginForm();
        logpage.typeLogin(login);
        logpage.TypePassword(password);
        logpage.clickLogin();
        //$(".inn_alert").shouldBe(visible);
       // $("#ilogin #flogin+i").shouldHave(text("Пользователя с таким логином не существует")).shouldBe(visible);
        logpage.CheckLoginError("Пользователя с таким логином не существует");

    }

    @Test
    public void LoginisEmptyTEst(){
        String  login="";
        String password ="1080977";
       // LoginPage logpage = new LoginPage();
       // logpage.openLoginForm();
        logpage.typeLogin(login);
        logpage.TypePassword(password);
        logpage.clickLogin();
        logpage.CheckLoginError("Введите логин");

    }

    @Test
    public void PasswordIsWrongTest(){
        String  login="elena108097";
        String password ="456456";
      //  LoginPage logpage = new LoginPage();
      //  logpage.openLoginForm();
        logpage.typeLogin(login);
        logpage.TypePassword(password);
        logpage.clickLogin();
        logpage.CheckPasswordError("Неправильно указан логин или пароль");

    }
    @Test
    public void PasswordIsEmtyTest(){
        String  login="elena108097";
        String password ="";
      //  LoginPage logpage = new LoginPage();
      //  logpage.openLoginForm();
        logpage.typeLogin(login);
        logpage.TypePassword(password);
        logpage.clickLogin();
        $("#show_error").shouldBe(visible).shouldHave(text("Введите пароль"));

    }
}
