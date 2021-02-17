package com.valya.app;

import org.junit.Test;
///import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import org.testng.annotations.AfterTest;

public class DiaryTest {

    @Test
    public void diaryOpenTest(){
        LoginPage page = new LoginPage();
        page.loginSite("https://love.ru","elena108097","1080977");
        DiaryPage diary = new DiaryPage();
        diary.openDiary();
        diary.checkYourDiaryOpen();
    }
}
