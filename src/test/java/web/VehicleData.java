package web;

import data.PKVehicleData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static data.LoginPage.logIn;
import static data.PKDateSto.*;
import static data.PKVehicleData.vehicleDataPK;

public class VehicleData {


    @BeforeMethod
    public void start(){
        logIn();
        findTask();
    }


    @Test()
    public static void vehicleData() {

        Assert.assertEquals(vehicleDataPK(),"Данные ТС");

    }
}
