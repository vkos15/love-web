package com.valya.app;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement name=$("#reg_form_field_name_d input[name='name']");
    SelenideElement email=$("#reg_form_field_email_d input[name='email']");

    public void Opensite (String url){
     //   open("https://love.ru/");
        open(url);
    }

    public void enterName(String name1){
        name.val(name1);

    }
    public void enterEmail(String email1){
        email.val(email1);

    }
    public void clickSignUP(){
        $("#reg_form_submit").click();
    }

    public void checkEmailError(String error){
        //проверка сообщения об ошибке
        $("#reg_form_field_email_d i").shouldHave(text(error)).shouldBe(visible);
    }

    public void checkNameError(String error){
        //проверка сообщения об ошибке
        $("#reg_form_field_name_d i").shouldHave(text(error)).shouldBe(visible);
    }

    public void checkMaxLengthName(){

        name.shouldHave(attribute("maxlength","21"));
    }
    public void checkButtonWantLogthisprofile(String email){
        //проверка что появилась кнопка "Желаете войти в эту анкету" и по нажатию открывается окно входа
        $("#mail_dup_login").shouldBe(visible).click();
       // $("#ilogin #flogin").shouldHave(value(email));//проверяем что в окне входа заполнен емаил
         LoginPage log=new LoginPage();
         log.checkinputLogin(email);
    }

}
