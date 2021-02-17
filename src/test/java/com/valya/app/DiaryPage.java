package com.valya.app;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DiaryPage {
    private SelenideElement linkDiary = $("#pmenu_diary");


    public void openDiary() {
        linkDiary.click();
    }

    public void checkYourDiaryOpen(){
        $("#post_add").shouldBe(visible).click();
    }



}
