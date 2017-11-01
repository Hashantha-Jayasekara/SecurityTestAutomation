package Test;

import PageFactory.Browser_SetUp;
import Pages.Subscribers;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Hashantha on 6/26/2017.
 */
public class Subscribers_Test {

    Browser_SetUp objBrowser;
    Subscribers objSubscribers;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objSubscribers = new Subscribers(this.objBrowser.driver);
    }

    String randomName = RandomStringUtils.randomAlphabetic(6);
    String randomEmail = RandomStringUtils.randomAlphabetic(10) + "@test.com";


    @Test(priority = 1)
    public void subscriberDetails(){

        objBrowser.driver.get(objBrowser.site);
        objSubscribers.setSubscribers(randomName,randomEmail);
        System.out.println("");
        System.out.println(randomName + " " +  "is subscribed as" + " " + randomEmail);
        System.out.println("");

    }

    @Test(priority = 2)
    public void subDBVerification() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();
        String Query1 = "SELECT * FROM subscribers WHERE email = '" + randomEmail + "'";
        ResultSet rs = stmt.executeQuery(Query1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1);
                String columnValue1 = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + randomEmail + " " + "=" + " " + columnValue1);

            }

            System.out.println("");

        }

        System.out.println("DB verification for" + " " + randomEmail + " " +  "is complete.");

    }



}
