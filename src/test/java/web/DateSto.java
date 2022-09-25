package web;

import data.LoginPage;
import data.PKDateSto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static data.LoginPage.logIn;
import static data.PKDateSto.dateSto;
import static data.PKDateSto.findTask;

public class DateSto {

    @BeforeMethod
    public void start(){
        logIn();
        findTask();
    }


    @Test
    public static void dateSto(){

        Assert.assertEquals(PKDateSto.dateSto(),"Дело");

    }


}
