package com.valya.app;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationVkPage {

    private SelenideElement vk = $("#vk");
    private SelenideElement submit = $("#reg_form_submit");
    private ElementsCollection listOfUsers = $$(".reg_outside_user ");
   // String winHandleBefore = getWebDriver().getWindowHandle();
    public  void openVkAutorization(){
        vk.click();
        switchTo().window("ВКонтакте | Вход");
    }

    public void autorizationVK(String loginVK, String passVK){
        $(By.name("email")).setValue(loginVK);
        $(By.name("pass")).setValue(passVK);
        $("#install_allow").click();
      //  switchTo().activeElement();
     //   $(withText("Разрешить")).click();
        $(By.xpath("//*[contains(@onclick,'return allow(this);')]")).click();
      //  getWebDriver().switchTo().window(winHandleBefore);

    }

    public void checkAtPageAfterRegVk(){

    }

    public void chooseProfile(String login){
      //  listOfUsers.findBy(value(login)).click();
      $(By.xpath("//*[@class='reg_outside_user']//input[@value= '"+login+"']/following-sibling::div")).click();
//System.out.println(a);

    }

    public  void submit(){
        submit.click();
    }




}
