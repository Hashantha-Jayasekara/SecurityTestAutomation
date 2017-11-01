package Test;

import PageFactory.Browser_SetUp;
import Pages.Booking;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Hashantha on 6/16/2017.
 */
public class Booking_Test  {

    Browser_SetUp objBrowser;
    Booking objBooking;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @Test(priority = 1)
    public void loginAsGuest(){
        String user = "bookingguest@gmail.com";
        String password = "1qaz2wsx@";


        objBrowser.driver.get(objBrowser.site + "user/login");
        objBooking = new Booking(this.objBrowser.driver);
        objBooking.setEmail_address(user);
        objBooking.setPassword(password);
        objBooking.clickLogin();
        objBooking.sleep();


    }

    @Test(priority = 2)
    public void stayEnquiryPage(){
        objBrowser.driver.get(objBrowser.site + "my-favourites");
        objBooking = new Booking(this.objBrowser.driver);
        String randomString = RandomStringUtils.randomAlphabetic(5);
        String guest = "5";
        objBooking.stayEnquiryPage(guest,randomString);

    }

    @Test(priority = 3)
    public void loginAsHost(){
        String user = "bookinghost@gmail.com";
        String password = "1qaz2wsx@";
        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.driver.get(objBrowser.site + "user/login");
        objBooking.setEmail_address(user);
        objBooking.setPassword(password);
        objBooking.clickLogin();
        objBooking.sleep();

    }

    @Test(priority = 4)
    public void rejectBooking() throws AWTException {
        objBrowser.driver.get(objBrowser.site + "user/host/booking-requests");
        objBooking.rejectBooking();

    }

    @Test(priority = 5)
    public void acceptBooking(){
        objBrowser.driver.get(objBrowser.site + "user/logout");
        loginAsGuest();
        stayEnquiryPage();
        loginAsHost();
        objBooking.driver.get(objBrowser.site + "user/host/booking-requests");
        objBooking.stayAccept();


    }

    @Test(priority = 6)
    public void stayPay(){
        System.out.println("You are in a manual entry mode" + '\n' + "Please fill the payment form within 20sec" + '\n' + "Use credit card detail as: 4142621111111112");
        objBrowser.driver.get(objBrowser.site + "user/logout");
        loginAsGuest();
        objBooking.driver.get(objBrowser.site + "user/guest/booking-requests");
        objBooking.stayPay();
    }

    @Test(priority = 7)
    public void cancelStay() {
        loginAsHost();
        objBooking.driver.get(objBrowser.site + "user/host/confirmed-bookings");
        objBooking.setCancelBooking();

    }

    @Test(priority = 8)
    public void calendarChange() {

        objBooking.driver.get(objBrowser.site + "calendar");
        objBooking.calendarSet();
    }

    @Test(priority = 9)
    public void availabilityChange(){
        objBooking.driver.get(objBrowser.site + "current-availability");
        objBooking.setAvailability();

    }

}
