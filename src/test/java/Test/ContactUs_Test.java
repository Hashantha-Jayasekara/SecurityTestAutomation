package Test;

import PageFactory.Browser_SetUp;
import Pages.ContactUs;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Hashantha on 6/21/2017.
 */
public class ContactUs_Test {
    Browser_SetUp objBrowser;
    ContactUs objContactUs;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objContactUs = new ContactUs(this.objBrowser.driver);

    }

    String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@test.com";

    @Test(priority = 1)
    public void contactUs(){
        objBrowser.driver.get(objBrowser.site + "contact-us");
        String randomString = RandomStringUtils.randomAlphabetic(6);
        objContactUs.setContactUs(randomString,randomEmail);
        if (objBrowser.driver.getPageSource().contains("We'll respond to your enquiry quickly, usually within a few hours.")) {
            System.out.println("Contact enquiry sent.");}
        else {
            System.out.println("Contact enquiry sending fail.");}

        System.out.println("");

    }


    @Test(priority = 2)
    public void contactUsDBVerification() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();
        String Query = "SELECT * FROM contact_mails WHERE sender_email = '" + randomEmail + "'";
        ResultSet rs = stmt.executeQuery(Query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1);
                String columnValue = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + randomEmail + " " + "=" + " " + columnValue);

            }

            System.out.println("");

        }

        System.out.println("DB verification for new contact enquiry from" + " " + randomEmail + " " +  "is complete.");

    }

}



