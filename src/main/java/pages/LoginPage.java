package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.openqa.selenium.By;
import org.xml.sax.Locator;

import javax.xml.xpath.XPath;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static util.Constants.*;

public class LoginPage {

 //   private Locator userName = new XPath("//form[@id='fm1']/div[3]/input")


    public static void loginStart(){
        open(startUrl);
        $(By.xpath("//form[@id='fm1']/div[3]/input")).val(USERNAME);
        $(By.xpath("//form[@id='fm1']/div[4]/input")).val(PASSWORD);
        $(By.xpath("//form[@id='fm1']/div[5]/input")).click();
        $(By.xpath("//div[@id='index-content']/div/nav/div/div[3]/div/div[2]/div/div/p")).click();
        $(By.xpath("//li[contains(.,'Logged as ingo.user')]")).shouldHave(Condition.text("Logged as ingo.user"));
    }
}
