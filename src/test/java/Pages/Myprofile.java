package Pages;

import PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hashantha on 6/12/2017.
 */
public class Myprofile extends Browser_SetUp {
    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    //ContactDetails form
    @FindBy(id = "FirstName")
    WebElement first_name;
    @FindBy(id = "Surname")
    WebElement Surname;
    @FindBy(id = "Age")
    WebElement Age;
    @FindBy(id = "edit-field-gender-und")
    WebElement Gender;
    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    WebElement save_continue;


    //EmailVerification form
    @FindBy(id = "edit-field-mobile-number-und-0-value")
    WebElement emailAddress;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/section/div/section/form/div/div/div/div/fieldset/div[3]/div[2]/div[1]/div/div[2]/input")
    WebElement sendEmailVerification;
    @FindBy(id = "edit-field-verification-code-value")
    WebElement emailVerify;
    @FindBy(name = "verify_email")
    WebElement Verify;


    //ProfilePicture form
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/section/div/section/form/div/div/div/div/div[1]/div/div[2]/div[2]/a[2]/button")
    WebElement buttonBrowse;
    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    WebElement profileSave;


    //Facebook form
    @FindBy(name = "skip")
    WebElement fbSkip;


    //AboutYou form
    @FindBy(id = "edit-field-occupation-und-0-value")
    WebElement occupation;
    @FindBy(id = "edit-field-field-countries-i-have-vis-und-0-value")
    WebElement countriesVisit;
    @FindBy(id = "edit-field-field-countries-i-like-vis-und-0-value")
    WebElement countriesLike;
    @FindBy(id = "edit-field-field-spoken-und-0-value")
    WebElement languages;
    @FindBy(id = "edit-field-interests-und-0-value")
    WebElement interest;
    @FindBy(id = "edit-field-hobbies-und-0-value")
    WebElement hobbies;
    @FindBy(id = "edit-submit")
    WebElement aboutSave;


    //MyGallery form
    @FindBy(linkText = "button version")
    WebElement buttonLink;
    @FindBy(id = "img-browse-btn")
    WebElement chooseFile;
    @FindBy(id = "edit-submit")
    WebElement saveGallaryImage;


    //ChangePassword form
    @FindBy(id = "OldPassword")
    WebElement oldPassword;
    @FindBy(id = "NewPassword")
    WebElement newPassword;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/section/div/form/div/input")
    WebElement savePassword;



    public Myprofile(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    //Login page data passing
    public void setEmail_address(String user) {
        email_address.sendKeys(user);
    }

    public void setPassword(String strPassword) {
        password.sendKeys(strPassword);
    }

    public void clickLogin() {
        login_button.click();
    }

    //ContactDetails data passing
    public void setFirst_name(String firstName) {
        first_name.sendKeys(firstName);
    }

    public void setSurname(String surname) {
        Surname.sendKeys(surname);
    }

    public void setAge() {
        Select dropdown = new Select(Age);
        dropdown.selectByIndex(3);
    }

    public void setGender() {
        Select dropdown = new Select(Gender);
        dropdown.selectByIndex(2);
    }

    public void clickSave() {
        save_continue.click();
    }

    //EmailVerification data passing
    public void setemailAddress(String user) {

        emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"),user);

    }

    public void clickEmailVerification() {
        sendEmailVerification.click();
    }

    public void setEmailVerify(String randomNumber) {
        emailVerify.sendKeys(randomNumber);

    }
    public void clickVerify(){
        Verify.click();
    }

    //ProfilePicture data passing
    public void setProfileSave(){
        profileSave.click();

    }

    //FacebookVerification data passing
    public void setFbSkip(){
        fbSkip.click();
    }

    //AboutYou data passing
    public void setAboutYou(String randomString){
        occupation.sendKeys(Keys.chord(Keys.CONTROL, "a"),randomString);
        countriesVisit.sendKeys (Keys.chord(Keys.CONTROL, "a"),randomString);
        countriesLike.sendKeys(Keys.chord(Keys.CONTROL, "a"),randomString);
        languages.sendKeys (Keys.chord(Keys.CONTROL, "a"),randomString);
        interest.sendKeys (Keys.chord(Keys.CONTROL, "a"),randomString);
        hobbies.sendKeys (Keys.chord(Keys.CONTROL, "a"),randomString);
        aboutSave.click();
    }

    //MyGallery data passing
    public  void setMyGallery() {
        buttonLink.click();
        chooseFile.click();
        sleep();
    }
    public void setSaveGallaryImage(){
        saveGallaryImage.click();
        sleep();

    }

    //changePassword data passing
    public void setNewPassword(String password){
        oldPassword.sendKeys(password);
        newPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        savePassword.click();

    }

}
