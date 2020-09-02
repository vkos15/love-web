package com.valya.app;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

 private  SelenideElement name=$(By.xpath("//*[@id='form_settings_profile']//a[1]/div"));


    public void checkName(String nameInSettings){

        name.shouldHave(exactText(nameInSettings));
    }

    public  void openSettings(){
        open("#settings/profile");
    }
}
