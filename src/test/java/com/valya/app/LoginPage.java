package com.valya.app;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement login_form= $(By.id("log_link"));

    private SelenideElement login= $(By.name("login"));
    private SelenideElement password= $(By.name("password"));

    public void typeLogin(String log){
        login.val(log);
    }
    public void TypePassword (String pass){
        password.val(pass);
    }

    public void clickLogin(){
        $(By.className("block_save")).click();
    }
    public void openLoginForm(String url){
     //   open("https://love.ru/");
        open(url);
        login_form.click();
    }
    public void CheckLoginError(String error){
       //проверка сообщения об ошибке у поля логина
        $("#ilogin #flogin+i").shouldHave(text(error)).shouldBe(visible);
    }

    public void CheckPasswordError(String error){
        //проверка сообщения об ошибке у поля пароля
        $(By.xpath("//*[@type='password']/following-sibling::i")).shouldHave(text(error));
    }

    public void checkAtPage(String login){
        //return
        $("#mprofile_link").shouldBe(visible);
        Assert.assertTrue("в ссылке нет логина",$("#mprofile_link").attr("href").contains(login));

      //  $("#mprofile_link").shouldHave(attributeMatching("href",*login*));
        //проверка что залогинились
    }
    public void checkinputLogin(String login1){
        login.shouldHave(value(login1));

        //проверка какой логин указан в поле логина
    }



}
