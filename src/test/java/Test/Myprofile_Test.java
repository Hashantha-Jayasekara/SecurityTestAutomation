package Test;

import PageFactory.Browser_SetUp;
import Pages.Myprofile;
import Pages.Register_Login;
import org.apache.commons.collections.buffer.PriorityBuffer;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Hashantha on 6/12/2017.
 */
public class Myprofile_Test {

    Browser_SetUp objBrowser;
    Myprofile objMyprofile;

    @BeforeTest
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();
    }


    @Test(priority = 1)
    public void loginUser(){
        String user = "myprofiletest@gmail.com";
        String password = "1qaz2wsx@";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objMyprofile = new Myprofile(this.objBrowser.driver);
        objMyprofile.setEmail_address(user);
        objMyprofile.setPassword(password);
        objMyprofile.clickLogin();
        objMyprofile.sleep();

    }

    @Test(priority = 2)
    public void contactDetails(){
        objBrowser.driver.get(objBrowser.site + "user/edit-my-profile");
        String randomName = RandomStringUtils.randomAlphabetic(20);
        objMyprofile.setFirst_name(randomName);
        objMyprofile.setSurname(randomName);
        objMyprofile.setAge();
        objMyprofile.setGender();
        objMyprofile.clickSave();
    }

    @Test(priority = 3)
    public void emailVerification(){
        String randomUser = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        objMyprofile.setemailAddress(randomUser);
        objMyprofile.clickEmailVerification();
        String randomNumber = RandomStringUtils.randomNumeric(4);
        objMyprofile.setEmailVerify(randomNumber);
        objMyprofile.clickVerify();
    }

    @Test(priority = 4)
    public  void profilePicture(){
        objBrowser.driver.get(objBrowser.site + "user/edit-my-profile/363E0C80-3335-483A-84E3-6725D97169CA/image-upload#edit-group_room_details");
        objMyprofile.setProfileSave();

    }

    @Test(priority = 5)
    public void facebookVerification(){
        objBrowser.driver.get(objBrowser.site + "user/edit-my-profile/363E0C80-3335-483A-84E3-6725D97169CA/social-network#edit-group_room_details");
        objMyprofile.setFbSkip();
    }

    @Test(priority = 6)
    public void aboutYou(){
        objBrowser.driver.get(objBrowser.site + "user/edit-my-profile/363E0C80-3335-483A-84E3-6725D97169CA/more-information#edit-group_room_details");
        String randomString = RandomStringUtils.randomAlphabetic(6);
        objMyprofile.setAboutYou(randomString);

    }

    @Test(priority = 7)
    public void gallery() throws AWTException {
        objBrowser.driver.get(objBrowser.site + "user/363E0C80-3335-483A-84E3-6725D97169CA/gallery");
        objMyprofile.setMyGallery();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_H);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        objMyprofile.setSaveGallaryImage();

    }

    @Test(priority = 8)
    public void changePassword(){
        String password = "1qaz2wsx@";
        objBrowser.driver.get(objBrowser.site + "user/change-my-password");
        objMyprofile.setNewPassword(password);
    }

}
