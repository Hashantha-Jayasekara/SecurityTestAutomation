package Pages;

import PageFactory.Browser_SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Hashantha on 6/27/2017.
 */
public class RoomType extends Browser_SetUp{

    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    //Search facility form
    @FindBy(id = "searchKeyword")
    WebElement roomTypeSearch;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div/form/fieldset/div[2]/input")
    WebElement roomTypeSearchButton;


    //Add new room type form
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div/h1/a")
    WebElement addNewRoomType;
    @FindBy(id = "name")
    WebElement typeName;
    @FindBy(id = "description")
    WebElement typeDescription;
    @FindBy(id = "SortOrder")
    WebElement typeOrder;
    @FindBy(id = "save-button")
    WebElement typeSave;

    //Edit room type form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[3]/a/img")
    WebElement editType;

    //Delete room type form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[4]/a/img")
    WebElement deleteType;
    @FindBy(xpath = "/html/body/div[3]/div/a")
    WebElement confirmDelete;




    public RoomType(WebDriver driver) {
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
    public void setRoomTypeSearch(String randomString){
        roomTypeSearch.sendKeys(randomString);
        roomTypeSearchButton.click();

    }

    public void setAddNewRoomType(String randomString, String randomNumber){
        addNewRoomType.click();
        typeName.sendKeys(randomString);
        typeDescription.sendKeys(randomString);
        typeOrder.sendKeys(randomNumber);
        typeSave.click();

    }

    public void setEditRoomType(String editDescription){
        editType.click();
        typeDescription.sendKeys(editDescription);
        typeSave.click();

    }

    public void setDeleteType(){
        deleteType.click();
        confirmDelete.click();
        sleep();
    }


}
