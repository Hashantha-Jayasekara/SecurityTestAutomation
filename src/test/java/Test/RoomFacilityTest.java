package Test;

import PageFactory.Browser_SetUp;
import Pages.RoomFacility;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Hashantha on 6/26/2017.
 */
public class RoomFacilityTest {

    Browser_SetUp objBrowser;
    RoomFacility objRoomFacility;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objRoomFacility = new RoomFacility(this.objBrowser.driver);
    }

    String randomString = RandomStringUtils.randomAlphabetic(6);
    String randomNumber = RandomStringUtils.randomNumeric(1);


    @Test(priority = 1)
    public void loginUser(){
        String user = "flipmyroom.intervest@gmail.com";
        String password = "123456";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objRoomFacility.setEmail_address(user);
        objRoomFacility.setPassword(password);
        objRoomFacility.clickLogin();
        objRoomFacility.sleep();

    }


    @Test(priority = 2)
    public void searchFac(){
        objBrowser.driver.get(objBrowser.site + "admin/manage-property-facilities");
        objRoomFacility.setFacSearch(randomString);
        if (objBrowser.driver.getPageSource().contains("No results found.")){
            System.out.println("Facility search complete.");
        }else {System.out.println("Facility search fail.");}

        System.out.println("");


    }

    @Test(priority = 3)
    public void addFac(){
        objRoomFacility.addNewFac(randomString,randomNumber);
        if (objBrowser.driver.getPageSource().contains("The room facility '" +  randomString + "' has been created.")){
            System.out.println("Facility adding complete.");
        }else {System.out.println("Facility adding fail.");}

        System.out.println("");

    }

    @Test(priority = 4)
    public void EditAddFac(){
        String editDescription = RandomStringUtils.randomAlphabetic(6);
        objRoomFacility.setFacSearch(randomString);
        objRoomFacility.setEditFac(editDescription);
        if (objBrowser.driver.getPageSource().contains("The room facility '" +  randomString + "' has been updated.")){
            System.out.println("Facility update complete.");
        }else {System.out.println("Facility update fail.");}

        System.out.println("");

    }

    @Test(priority = 5)
    public void facDBVerification() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();
        String Query1 = "SELECT * FROM facilities WHERE facility_name = '" + randomString + "'";
        ResultSet rs = stmt.executeQuery(Query1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1);
                String columnValue = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + "facility" + " " + randomString + " " + "is" + " " +  "=" + " " + columnValue);

            }

            System.out.println("");

        }

        System.out.println("DB verification for" + " " + " " + "facility" + " " + randomString + " " +  "is complete.");
        System.out.println("");

    }


    @Test(priority = 6)
    public void deleteFac(){
        objRoomFacility.setFacSearch(randomString);
        objRoomFacility.setDeleteFac();
        if (objBrowser.driver.getPageSource().contains("The room facility '" +  randomString + "' has been deleted.")){
            System.out.println("Facility delete complete.");
        }else {System.out.println("Facility delete fail.");}
    }


}
