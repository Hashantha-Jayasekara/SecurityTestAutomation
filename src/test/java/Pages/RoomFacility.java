package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
/**
 * Created by Hashantha on 6/26/2017.
 */
public class RoomFacility extends Browser_SetUp {

    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    //Search facility form
    @FindBy(id = "searchKeyword")
    WebElement facSearch;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/form/fieldset/div[2]/input")
    WebElement facSearchButton;


    //Add new facility form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/h1/a")
    WebElement addFac;
    @FindBy(id = "Name")
    WebElement facName;
    @FindBy(id = "Description")
    WebElement facDescription;
    @FindBy(id = "SortOrder")
    WebElement facPosition;
    @FindBy(id = "Publish")
    WebElement facPublish;
    @FindBy(id = "save-button")
    WebElement facSubmit;

    //Edit facility form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[4]/a/img")
    WebElement editFac;

    //Delete facility form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[6]/a/img")
    WebElement deleteFac;
    @FindBy(xpath = "/html/body/div[3]/div/a")
    WebElement deleteConfirm;




    public RoomFacility(WebDriver driver) {
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


    //Search facility data passing
    public void setFacSearch(String randomString){

        facSearch.sendKeys(randomString);
        facSearchButton.click();

    }

    public void addNewFac(String randomString, String randomNumber){

        addFac.click();
        facName.sendKeys(randomString);
        facDescription.sendKeys(randomString);
        facPosition.sendKeys(randomNumber);
        facSubmit.click();

    }

    public void setEditFac(String editDescription){
        editFac.click();
        facDescription.sendKeys(editDescription);
        facSubmit.click();

    }

    public void setDeleteFac(){
        deleteFac.click();
        deleteConfirm.click();
        sleep();
    }




}
