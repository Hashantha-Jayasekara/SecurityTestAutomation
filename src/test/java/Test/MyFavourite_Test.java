package Test;

import Pages.MyFavourite;
import Pages.Myprofile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import PageFactory.Browser_SetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Hashantha on 6/23/2017.
 */
public class MyFavourite_Test   {

    Browser_SetUp objBrowser;
    MyFavourite objMyFavourite;



    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objMyFavourite = new MyFavourite(this.objBrowser.driver);

    }


    @Test(priority = 1)
    public void loginUser(){
        String user = "myfavourite@gmail.com";
        String password = "1qaz2wsx@";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objMyFavourite.setEmail_address(user);
        objMyFavourite.setPassword(password);
        objMyFavourite.clickLogin();
        objMyFavourite.sleep();


    }

    @DataProvider
    public Object[][] roomRefDetails(){
        return new Object[][]{{"FR000515"},{"FR000507"}, {"FR000504"},{"FR000417"},{"FR000414"},
                {"FR000410"},{"FR000409"},{"FR000407"},{"FR000387"},{"FR000381"},
                {"FR000378"},{"FR000372"},{"FR000371"},
                {"FR000369"},{"FR000366"},{"FR000361"},{"FR000308"},{"FR000267"},{"FR000264"},{"FR000225"},{"FR000223"}};

    }

    @Test(priority = 2, dataProvider = "roomRefDetails")
    public void addMyFavourite(String roomRef) throws AWTException {

        objBrowser.driver.get(objBrowser.site + "room/" + roomRef);
        objMyFavourite.Favorite();

    }

    @Test(priority = 3, dataProvider = "roomRefDetails")
    public void removeFromFavourite(String roomRef){

        objBrowser.driver.get(objBrowser.site + "my-favourites");
        do
        {
            objMyFavourite.Favorite();

        }while (objBrowser.driver.getPageSource().contains("You haven't listed any rooms yet. Please return to the home page."));

    }


}
