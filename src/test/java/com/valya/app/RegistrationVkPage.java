package com.valya.app;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationVkPage {

    private SelenideElement vk = $("#vk");
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




}
