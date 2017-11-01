package Pages;

import Test.AddRoom_Test;
import Test.Register_Login_Test;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageFactory.Browser_SetUp;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.annotations.BeforeTest;

/**
 * Created by Hashantha on 4/6/2017.
 */
public class Register_Login extends Browser_SetUp{

    //Login Page Elements
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy (id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;

    //Register Page Elements
    @FindBy(id = "EmailAddress")
    WebElement RegisterEmail;
    @FindBy(id = "FirstName")
    WebElement RegisterFirstname;
    @FindBy(id = "surname")
    WebElement RegisterSurname;
    @FindBy (id = "show-pwd")
    WebElement ShowPassword;
    @FindBy(id = "Password")
    WebElement RegisterPassword;
    @FindBy(id = "registersubmit")
    WebElement RegisterButton;


    //UserPreference form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[1]/label[2]")
    WebElement hostTab;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/div/div/div[2]/form/div[2]/button")
    WebElement proceed;




    public Register_Login(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(this.driver , this);

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

    //Register page data passing
    public void setRegisterEmail(String strRemail){
        RegisterEmail.sendKeys(strRemail);

    }
    public void setRegisterFirstname(String strRfname){
        RegisterFirstname.sendKeys(strRfname);
    }

    public void setRegisterSurname(String strRsname){
        RegisterSurname.sendKeys(strRsname);
    }

    public void setRegisterPassword(String strRpassword){
        RegisterPassword.sendKeys(strRpassword);
    }

    public  void clickShowPassword(){
        ShowPassword.click();

    }


    public void clickRegister(){
        RegisterButton.click();
    }


    public  void LoginToFMR(String strEmail,String strPassword) throws Exception {
        this.setEmail_address(strEmail);
        this.setPassword(strPassword);
        this.clickLogin();
    }


    //User preference data passing
    public  void userPreference(){
        sleep();
        hostTab.click();
        sleep();
        proceed.click();
    }




}

