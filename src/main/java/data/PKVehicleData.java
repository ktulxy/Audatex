package data;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class PKVehicleData {


    public static String vehicleDataPK()  {
        $(By.xpath("//div[15]/div/div/div/div/div/div")).click(); // три точки
        $(By.xpath("//a[@id='openTask']/span")).click(); // открыть дело
        SelenideElement auto = $(By.xpath("//li[@id='toDoListItem_Vehicle']/a/span[2]"));
        auto.click(); // выбираем раздел авто
        SelenideElement dataToSto = $(By.xpath("//div[2]/div/div/div/div[2]/div/div/input"));
        dataToSto.click();
        dataToSto.clear();
        dataToSto.val("07.07.2023").sendKeys(Keys.ENTER); // дата передачи сто
        SelenideElement color = $(By.xpath("//div[16]/div/div[2]/div/div/div[2]/div"));
        color.click();
        SelenideElement typeColor = $(By.xpath("//*/text()[normalize-space(.)='PearlEffect']/parent::*"));
        color.shouldHave((Condition) typeColor);
        color.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);

        $(By.xpath("//a[@id='root.actionButtons.saveButton']/div/div/div")).click(); // save
        String check = $(By.xpath("//div[3]/div/div/h6")).getText();
        return check;
    }



}
