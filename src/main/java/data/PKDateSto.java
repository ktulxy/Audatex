package data;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static util.Constants.USERNAME;

public class PKDateSto {

    public static void findTask(){
        $(By.xpath("//div/div/ul/li[2]/a/span")).click(); // клик на лупу
        WebElement number = $(By.xpath("//div[2]/div/div/div/div[2]/input")); // номер дела
        number.clear();
        ((SelenideElement) number).val("ClaimNumber№");
        $(By.xpath("//div[4]/button[3]/span")).click(); //поиск

    }

    public void changeMenu(){

    }


    public static String dateSto(){  //String

        $(By.xpath("//div[15]/div/div/div/div/div/div")).click(); // три точки
        $(By.xpath("//a[@id='openTask']/span")).click(); // открыть дело
        $(By.xpath("//span[2]")).click(); // переходим на вкладку "дело"
        // $(By.xpath("//div[@id='root.task.basicClaimData.repairDetail.carEstimatedArrivalDateTime']/input")).val("01.01.2023");
        SelenideElement date = $(By.xpath("//div[2]/div[2]/div/div/div/div[2]/div/div/input"));
        date.clear();
        date.val("01.01.2023").sendKeys(Keys.ENTER);
        $(By.xpath("//a[@id='root.actionButtons.saveButton']/div/div/div")).click(); // save
        String statusDelo = $(By.xpath("//div[@id='index-content']/div/nav/div/div/div[2]/span/span")).getText();
        return statusDelo;
  }
}
