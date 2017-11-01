package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
/**
 * Created by Hashantha on 6/21/2017.
 */
public class InviteFriends extends Browser_SetUp {


    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    //Invite Friend form
    @FindBy(id = "email")
    WebElement email1;
    @FindBy(id = "email2")
    WebElement email2;
    @FindBy(id = "email3")
    WebElement email3;
    @FindBy(id = "edit-submit")
    WebElement sendInvitation;

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



    public InviteFriends(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Invite friend data passing
    public void setSendInvitation(String email_1, String email_2, String email_3){
        email1.sendKeys(email_1);
        email2.sendKeys(email_2);
        email3.sendKeys(email_3);
        sendInvitation.click();

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


    //User preference data passing
    public  void userPreference(){
        sleep();
        hostTab.click();
        sleep();
        proceed.click();
    }


}
