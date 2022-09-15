package web;

import org.testng.annotations.Test;
import data.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {


    @Test
    public void login(){
        LoginPage.loginStart();
    }
}
