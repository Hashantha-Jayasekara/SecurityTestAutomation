package Pages;

import PageFactory.Browser_SetUp;
import org.apache.commons.collections.iterators.ListIteratorWrapper;
import org.apache.tools.ant.taskdefs.Concat;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.lift.match.TextMatcher;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hashantha on 6/16/2017.
 */
public class Booking extends Browser_SetUp{


    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;

    //Favourite form
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div/div/section/div/section/div/div/div[2]/div[1]/div/div[2]/a")
    WebElement viewRoom;
    @FindBy(xpath = "//*[@id=\"contact_host\"]")
    WebElement contactHost;

    //StayEnquiry form
    @FindBy(xpath = "//*[@id=\"enquiryFrom\"]")
    WebElement checkIn;
    @FindBy(xpath = "/html/body/div[5]/div/a[2]")
    WebElement nextMonthCheck;
    @FindBy(xpath = "/html/body/div[5]/table/tbody/tr[4]/td[4]/a")
    WebElement pickDate;
    @FindBy(xpath = "//*[@id=\"enquiryTo\"]")
    WebElement checkOut;
    @FindBy(xpath = "/html/body/div[5]/table/tbody/tr[4]/td[7]/a")
    WebElement pickCheckOut;
    @FindBy(xpath = "//*[@id=\"editguests\"]")
    WebElement numberOfGuest;
    @FindBy(xpath = "//*[@id=\"edit-fmr-message\"]")
    WebElement message;
    @FindBy(xpath = "//*[@id=\"edit-submit-form\"]")
    WebElement sendStay;

    //StayReject form
    @FindBy(xpath = "//*[@id=\"reject-booking\"]")
    WebElement rejectBooking;


    //StayAccept form
    @FindBy(xpath = "//*[@id=\"accept-booking\"]")
    WebElement acceptBooking;
    @FindBy (xpath = "//*[@id=\"payment-button\"]")
    WebElement payBooking;

    //StayCancel form
    @FindBy(id = "cancel-booking")
    WebElement cancelBooking;


    //Calendar form
    @FindBy(xpath = "//*[@id=\"dateFrom\"]")
    WebElement calendarFrom;
    @FindBy(xpath = "/html/body/div[2]/div/a[2]")
    WebElement calendarFromNext;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[1]/td[7]/a")
    WebElement calendarFromDatePick;
    @FindBy(xpath = "//*[@id=\"dateTo\"]")
    WebElement calendarTo;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[6]/td[2]/a")
    WebElement calendarToDatePick;
    @FindBy(xpath = "//*[@id=\"apply_period\"]")
    WebElement clickApply;
    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    WebElement clickSave;


    //Availability form
    @FindBy(xpath = "//*[@id=\"is_property_available\"]")
    WebElement manageAvailability;
    @FindBy(xpath = "//*[@id=\"edit-submit\"]")
    WebElement calendarSave;




    public Booking(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    //StayEnquiry data passing
    public void stayEnquiryPage(String guest, String randomString){
        viewRoom.click();
        sleep();
        contactHost.click();
        sleep();
        checkIn.click();
        nextMonthCheck.click();
        sleep();
        pickDate.click();
        checkOut.click();
        pickCheckOut.click();
        numberOfGuest.sendKeys(guest);
        message.sendKeys(randomString);
        sendStay.click();
    }


    //StayReject data passing
    public void rejectBooking(){
        rejectBooking.click();
        sleep();

    }

    //StayAccept data passing
    public void stayAccept(){
        acceptBooking.click();
        sleep();
    }

    //PayBooking data passing
    public void stayPay(){
        payBooking.click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        wait.until(ExpectedConditions.titleContains("Stay Thank You - flipMyroom"));
        sleep();

    }

    //CancelBooking data passing
    public void setCancelBooking(){
        cancelBooking.click();
        sleep();
        Alert alt = driver.switchTo().alert();
        alt.accept();


    }

    //Calendar data passing
    public void calendarSet(){
        sleep();
        calendarFrom.click();
        calendarFromNext.click();
        calendarFromDatePick.click();
        calendarTo.click();
        calendarToDatePick.click();
        clickApply.click();
        clickSave.click();
    }

    //Availability
    public void setAvailability(){
        Select notAvailable = new Select(manageAvailability);
        notAvailable.selectByValue("0");
        calendarSave.click();
        sleep();
        Select available = new Select(manageAvailability);
        available.selectByValue("1");
        calendarSave.click();

    }



}
