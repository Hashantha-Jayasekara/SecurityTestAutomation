package Test;

/**
 * Created by Hashantha on 11/7/2016.
 */

import PageFactory.Browser_SetUp;
import Pages.Register_Login;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Register_Login_Test {

    Browser_SetUp objBrowser;
    Register_Login objRegLog;


    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }


    @Test
    public void tstRegisterUser() throws Exception {
        // Create random username so we can rerun test
        String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        this.registerUser(randomUser, "password");
        if (objBrowser.driver.getPageSource().indexOf("I want to be a") > 0)
            System.out.println("USER CREATION: PASS");
        else
            System.out.println("USER CREATION: FAIL");

        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.sleep();
        System.out.println("LOGOUT: PASS");


        this.loginUser(randomUser,"password");
        if (objBrowser.driver.getPageSource().indexOf("I want to be a")> 0)
            System.out.println("LOGIN: PASS");
        else
            System.out.println("LOGIN: FAIL");

        objRegLog.userPreference();
        objBrowser.sleep();
        System.out.println("UserPreference: PASS");

    }


    public void loginUser(String user, String password) throws Exception {

        objBrowser.driver.get(objBrowser.site + "user/login");
        objRegLog.LoginToFMR(user, password);

    }

    public void registerUser(String user, String password) throws Exception {

        objBrowser.driver.get(objBrowser.site + "user/register");
        String randomName = RandomStringUtils.randomAlphabetic(20);
        objRegLog = new  Register_Login(this.objBrowser.driver);
        objRegLog.setRegisterFirstname(randomName);
        objRegLog.setRegisterSurname(randomName);
        objRegLog.setRegisterEmail(user);
        objRegLog.clickShowPassword();
        objRegLog.setRegisterPassword(password);
        objRegLog.clickRegister();
        objBrowser.sleep();

    }




}
