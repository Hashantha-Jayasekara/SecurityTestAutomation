package Pages;

import PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Hashantha on 6/21/2017.
 */
public class ContactUs extends Browser_SetUp {


    //ContactUs form
    @FindBy(id = "edit-name")
    WebElement name;
    @FindBy(id = "edit-mail")
    WebElement email;
    @FindBy(id = "edit-subject")
    WebElement subject;
    @FindBy(id = "edit-message")
    WebElement message;
    @FindBy(id = "send_me_a_copy")
    WebElement copySend;
    @FindBy(id = "edit-submit")
    WebElement sendMsg;




    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void setContactUs(String randomString, String randomEmail){
        name.sendKeys(randomString);
        email.sendKeys(randomEmail);
        subject.sendKeys(randomString);
        message.sendKeys(randomString);
        copySend.click();
        sendMsg.click();
        sleep();
    }




}
