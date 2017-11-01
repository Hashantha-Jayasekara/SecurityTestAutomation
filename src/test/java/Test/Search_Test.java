package Test;

import PageFactory.Browser_SetUp;
import Pages.Search;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Hashantha on 6/20/2017.
 */

public class Search_Test {

    Browser_SetUp objBrowser;
    Search objSearch;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new Browser_SetUp();
        this.objBrowser.setUp();


    }

    @BeforeMethod()
    public void beforeMethod(){
        objSearch = new Search(this.objBrowser.driver);

    }


    @Test(priority = 1)
    public void emptySearch(){
        objBrowser.driver.get(objBrowser.site);
        objBrowser.sleep();
        objSearch.emptySearch();
        objBrowser.driver.get(objBrowser.site);
    }

    @DataProvider
    public Object[][] searchDetails(){
        return new Object[][]{{"Jamaica"},{"Kingston"},{"Switzerland"},{"Geneva"},{"South Africa"},{"Cape Town"},{"Colombo"},{"United Kingdom"},{"London"},{"Kandy"},{"Paris"},{"Brazil"},{"Dhilli"},
                                {"Brixton"},{"Derbyshire"},{"Abu Dhabi"},{"Greater Manchester"},{"Oxfordshire"},{"Bangkok"},{"West Yorkshire"},{"Leicestershire"},
                                {"Hampshire"},{"Cornwall"},{"Gondar"},{"Lagos"},{"Arizona"},{"Dorset"},{"Berkshire"},{"Nuuk"},{"Manisa"},{"Maritime"},{"Merseyside"},{"Warwickshire"},{"Changi"}};
    }

    @Test(priority = 2, dataProvider = "searchDetails")
    public void search(String searchValue) throws AWTException {
        //objSearch = new Search(this.objBrowser.driver);
        objBrowser.driver.get(objBrowser.site);
        objSearch.setSearch(searchValue);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);

    }

    @Test(priority = 3)
    public void roomDetails(){
        //objSearch = new Search(this.objBrowser.driver);
        objBrowser.driver.get(objBrowser.site + "room/fr000515-bookingtest");
        objSearch.setRoomDetails();
    }

    @Test(priority = 4)
    public void latestRoomsAndNoResult() throws AWTException {
        //objSearch = new Search(this.objBrowser.driver);
        objBrowser.driver.get(objBrowser.site);
        String randomString = RandomStringUtils.randomAlphabetic(4);
        String country = "Switzerland";
        objSearch.setLatestRoomsAndNoResult(randomString,country);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


}


