package web;

import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static util.Constants.startUrl;

public class LoginTest {


    @Test
    public void login(){
        LoginPage.loginStart();
    }
}
