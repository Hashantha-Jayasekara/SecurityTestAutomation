package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Hashantha on 6/27/2017.
 */
public class RoomCategory extends Browser_SetUp {


    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;


    //Search category form
    @FindBy(id = "featured")
    WebElement featuredCategory;
    @FindBy(id = "searchKeyword")
    WebElement categoryName;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/form/fieldset/div[3]/input")
    WebElement clickSearch;


    //Add new category
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/h1/a")
    WebElement clickAddNewCat;
    @FindBy(id = "name")
    WebElement catName;
    @FindBy(id = "sortorder")
    WebElement catSort;
    @FindBy(id = "icon")
    WebElement catIcon;
    @FindBy(id = "description")
    WebElement catDesc;
    @FindBy(id = "metadescription")
    WebElement catSearchEng;
    @FindBy(id = "featured")
    WebElement catFeatured;
    @FindBy(id = "sortorderfeatured")
    WebElement catSortFea;
    @FindBy(id = "published")
    WebElement catPublish;
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/div/form/div/fieldset/button")
    WebElement catSubmit;


    //Edit category
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[6]/a")
    WebElement editCat;


    //Delete category
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/table/tbody/tr/td[7]/a/img")
    WebElement deleteCat;
    @FindBy(xpath = "/html/body/div[3]/div/a")
    WebElement deleteConfirm;



    public RoomCategory(WebDriver driver) {
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


    //Search category data passing
    public void setSearchCat(String randomString){

        Select featuredCat = new Select(featuredCategory);
        featuredCat.selectByIndex(1);
        Select nonFeaturedCat = new Select(featuredCategory);
        nonFeaturedCat.selectByIndex(2);
        Select allCat = new Select(featuredCategory);
        allCat.selectByIndex(0);
        categoryName.sendKeys(randomString);
        clickSearch.click();

    }

    public void setAddCategory(String randomString, String randomNumber){

        clickAddNewCat.click();
        catName.sendKeys(randomString);
        catSort.sendKeys(randomNumber);
        catDesc.sendKeys(randomString);
        catSearchEng.sendKeys(randomString);
        catSubmit.click();

    }

    public void setEditCategory(String randomString,String editDescription ){
        categoryName.sendKeys(randomString);
        clickSearch.click();
        editCat.click();
        catDesc.sendKeys(editDescription);
        clickSearch.click();

    }

    public void setDeleteCat(String randomString){
        categoryName.sendKeys(randomString);
        clickSearch.click();
        deleteCat.click();
        deleteConfirm.click();
        sleep();

    }




}
