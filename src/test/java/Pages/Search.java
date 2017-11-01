package Pages;


import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Hashantha on 6/20/2017.
 */
public class Search extends Browser_SetUp {

    //Search form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/section/div/form/div/button")
    WebElement searchIcon;
    @FindBy(id = "guestcount")
    WebElement guest;
    @FindBy(id = "categorylist")
    WebElement style;
    @FindBy(id = "viewlist")
    WebElement view;
    @FindBy(id = "SearchText")
    WebElement searchField;


    //RoomDetails form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[2]/div/ul/li[2]/a")
    WebElement details;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[2]/div/ul/li[3]/a")
    WebElement calendar;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[2]/div/ul/li[4]/a")
    WebElement map;
    @FindBy(xpath = "//*[@id=\"profile\"]")
    WebElement profile;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[2]/div/ul/li[6]/a")
    WebElement nearby;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[2]/div/ul/li[1]/a")
    WebElement gallery;

    //LatestRooms & NoResult form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/section[3]/div[2]/a")
    WebElement latestRooms;
    @FindBy(xpath = "//*[@id=\"SearchText\"]")
    WebElement searchLatest;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div[2]/div/div/form/div[4]/button")
    WebElement latestSearchIcon;
    @FindBy(xpath = "//*[@id=\"SearchText\"]")
    WebElement noresultSearch;


    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void emptySearch(){
        searchIcon.click();
        //Guests
        Select guest1 = new Select(guest);
        guest1.selectByValue("1");
        sleep();
        Select guest2 = new Select(guest);
        guest2.selectByValue("2");
        sleep();
        Select guest3 = new Select(guest);
        guest3.selectByValue("3");
        sleep();
        Select guest4 = new Select(guest);
        guest4.selectByValue("4");
        sleep();
        Select guest5 = new Select(guest);
        guest5.selectByValue("5");
        sleep();
        Select guest6 = new Select(guest);
        guest6.selectByValue("6");
        sleep();
        guest1.selectByValue("1");
        sleep();
        System.out.println("Guest search done!");

        //Styles
        Select mountain = new Select(style);
        mountain.selectByValue("mountain");
        sleep();
        Select rural = new Select(style);
        rural.selectByValue("rural");
        sleep();
        Select apartments = new Select(style);
        apartments.selectByValue("apartments");
        sleep();
        Select beach = new Select(style);
        beach.selectByValue("beach");
        sleep();
        Select city = new Select(style);
        city.selectByValue("city");
        sleep();
        Select all = new Select(style);
        all.selectByValue("all");
        sleep();
        System.out.println("Styles search done!");

        //Views
        Select grid = new Select(view);
        grid.selectByValue("grid");
        sleep();
        Select map = new Select(view);
        map.selectByValue("map");
        sleep();
        Select list = new Select(view);
        list.selectByValue("list");
        sleep();
        System.out.println("Views done!");

        //Shuffle lists
        guest4.selectByValue("4");
        sleep();
        rural.selectByValue("rural");
        sleep();
        grid.selectByValue("grid");
        sleep();
        System.out.println("Shuffle search done!");

    }

    //Search data passing
    public void setSearch(String searchValue){
        searchField.sendKeys(searchValue);
        System.out.println("Search" + " " + searchValue + " " + "complete.");
        sleep();

    }

    //NoResult & Latest Room data passing
    public void setLatestRoomsAndNoResult(String randomString, String country){
        sleep();
        latestRooms.click();
        System.out.println("Latest rooms verified.");
        searchLatest.sendKeys(randomString);
        sleep();
        latestSearchIcon.click();
        sleep();
        System.out.println("No-result page actions done!");
        noresultSearch.sendKeys(country);


    }


    //RoomDetails data passing
    public void setRoomDetails(){
        System.out.println("Room detail verification started.");
        sleep();
        details.click();
        System.out.println("Details section done!");
        sleep();
        calendar.click();
        System.out.println("Calendar section done!");
        sleep();
        map.click();
        System.out.println("Map section done!");
        sleep();
        profile.click();
        System.out.println("Profile section done!");
        sleep();
        nearby.click();
        System.out.println("Nearby  section done!");
        sleep();
        gallery.click();
        System.out.println("Gallery section done!");
        sleep();

    }



}
