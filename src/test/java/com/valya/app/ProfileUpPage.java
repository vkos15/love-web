package com.valya.app;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfileUpPage {
    private SelenideElement profileUp= $("#user_place_num .pay_button");



    public void clickProfileUp(){
        profileUp.click();
    }




}
