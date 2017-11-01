package Pages;

import PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Hashantha on 6/26/2017.
 */
public class Subscribers extends Browser_SetUp {


    @FindBy(id = "subscribe_name")
    WebElement subName;
    @FindBy(id = "subscribe_email")
    WebElement subEmail;
    @FindBy(id = "btn-newsletter-sign-up")
    WebElement clickSub;




    public Subscribers(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void setSubscribers(String randomName, String randomEmail){

        subName.sendKeys(randomName);
        subEmail.sendKeys(randomEmail);
        clickSub.click();

    }


}
