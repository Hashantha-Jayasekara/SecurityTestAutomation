package Pages;

import PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Hashantha on 6/23/2017.
 */
public class MyFavourite extends Browser_SetUp {

    //Add favourite form
    @FindBy(className = "property-favorite")
    WebElement addFavourite;

    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    public MyFavourite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    //Login page data passing
    public  void setEmail_address(String user){
        email_address.sendKeys(user);
    }
    public  void  setPassword(String strPassword){
        password.sendKeys (strPassword);
    }
    public void clickLogin(){
        login_button.click();
    }


    //Add favourite data passing
    public void Favorite(){

        if (addFavourite == null)
        {
           driver.getPageSource().contains("You haven't listed any rooms yet. Please return to the home page.");
        }

        else {addFavourite.click();}

    }

}
