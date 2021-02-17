package com.valya.app;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BaseHelp {

    public  void deactivateOAuth(String log) {

        LoginPage page = new LoginPage();
        page.loginSite("https://mylove.ru/","valentina13919","r347b7");
        sleep(1000);

        String url1= "https://mylove.ru/#admin/user/"+log;
       // Configuration.baseUrl ="https://mylove.ru/#admin/user/";

        open(url1);
        //sleep(6000);
        $("input[value = 'A']").click();
        $(withText("Прочие манипуляции")).click();
        $("[value = 'Сбросить привязку к соц.сетям']").click();
        confirm();
        sleep(1000);



    }

   // public static void main(String args[]) {
    //    deactivateOAuth("klavdiya706");

   // }


@Test
    public void test(){

 //   open("https://mylove.ru/#admin/user/");
  /*  LoginPage page = new LoginPage();
    page.loginSite("https://mylove.ru/","valentina13919","r347b7");
    sleep(1000);*/

    // BaseHelp help = new BaseHelp();
     // help.
              deactivateOAuth("inna10613");
   // open("https://mylove.ru/#admin/user2/");
   // sleep(1000);


    }
}
