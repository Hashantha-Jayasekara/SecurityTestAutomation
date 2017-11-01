package Test;

import PageFactory.Browser_SetUp;
import Pages.AddRoom;
import Pages.Myprofile;
import Pages.Register_Login;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Priority;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Hashantha on 6/13/2017.
 */
public class AddRoom_Test{

    Browser_SetUp objBrowser;
    AddRoom objAddRoom;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objAddRoom = new AddRoom(this.objBrowser.driver);

    }

    @Test(priority = 1)
    public void registerUser() throws Exception {


        String password = "1qaz2wsx@";

        objBrowser.driver.get(objBrowser.site + "user/register");
        String randomName = RandomStringUtils.randomAlphabetic(20);
        String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        objAddRoom.setRegisterFirstname(randomName);
        objAddRoom.setRegisterSurname(randomName);
        objAddRoom.setRegisterEmail(randomEmail);
        objAddRoom.clickShowPassword();
        objAddRoom.setRegisterPassword(password);
        objAddRoom.clickRegister();
        objAddRoom.userPreference();
        objBrowser.sleep();

    }

    @Test(priority = 2)
    public void roomName() throws Exception {

        String randomName = RandomStringUtils.randomAlphabetic(10);
        objAddRoom.setRoomName(randomName);
        objAddRoom.setPropertyType();
        objAddRoom.setRoomCategory();
        objAddRoom.clickRoomSave();
    }

    @Test(priority = 3)
    public  void locatoinMap() throws AWTException {
        String location = "Negril Westmoreland";
        String randomName = RandomStringUtils.randomAlphabetic(3);
        objAddRoom.setCountry();
        objAddRoom.setTownCity();
        objAddRoom.setCounty(randomName);
        objAddRoom.setPostAddress(location);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        String randomNumber = RandomStringUtils.randomNumeric(2);
        objAddRoom.streetDetails(randomName,randomNumber);

    }

    @Test(priority = 4)
    public  void roomDetails(){
        String randomName = RandomStringUtils.randomAlphabetic(5);
        objAddRoom.roomDetails(randomName);
    }

    @Test(priority = 5)
    public  void facilityDetails(){
        String randomName = RandomStringUtils.randomAlphabetic(5);
        objAddRoom.facilityDetails(randomName);
    }

    @Test(priority = 6)
    public  void photoDetails() throws AWTException {
        objAddRoom.setPhotos();
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
        objAddRoom.setSavePhotos();
    }

    @Test(priority = 7)
    public void contactDetails(){
        String randomName = RandomStringUtils.randomAlphabetic(5);
        objAddRoom.contactDetails(randomName);
    }

    @Test(priority = 8)
    public void profilePicDetails(){
        objAddRoom.profilePicDetails();
    }

    @Test(priority = 9)
    public void facebookDetails(){
        objAddRoom.facebookDetails();
    }

    @Test(priority = 10)
    public void aboutYou(){
        String randomName = RandomStringUtils.randomAlphabetic(5);
        objAddRoom.aboutYouDetails(randomName);
    }

    @Test(priority = 11)
    public void roomPublish(){
        objAddRoom.roomPublish();
    }

    @Test(priority = 12)
    public void viewLive(){
        objAddRoom.viewLive();

    }

    @Test(priority = 13)
    public void roomUnpublish(){
        objBrowser.driver.get(objBrowser.site + "my-room");
        objBrowser.sleep();
        objAddRoom.roomUnpublish();
    }

    @Test(priority = 14)
    public void preview(){
        objAddRoom.preview();
    }

}




