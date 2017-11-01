package Test;

import PageFactory.Browser_SetUp;
import Pages.RoomCategory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Hashantha on 6/27/2017.
 */
public class RoomCategory_Test {


    Browser_SetUp objBrowser;
    RoomCategory objRoomCategory;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();
    }


    @BeforeMethod()
    public void beforeMethods(){
        objRoomCategory = new RoomCategory(this.objBrowser.driver);
    }


    @Test(priority = 1)
    public void loginUser(){
        String user = "flipmyroom.intervest@gmail.com";
        String password = "123456";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objRoomCategory.setEmail_address(user);
        objRoomCategory.setPassword(password);
        objRoomCategory.clickLogin();
        objRoomCategory.sleep();

    }







}
