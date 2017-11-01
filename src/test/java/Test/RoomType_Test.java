package Test;

import PageFactory.Browser_SetUp;
import Pages.RoomType;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Hashantha on 6/27/2017.
 */
public class RoomType_Test {


    Browser_SetUp objBrowser;
    RoomType objRoomType;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods()
    {
        objRoomType = new RoomType(this.objBrowser.driver);
    }

    String randomString = RandomStringUtils.randomAlphabetic(6);
    String randomNumber = RandomStringUtils.randomNumeric(1);


    @Test(priority = 1)
    public void loginUser(){
        String user = "flipmyroom.intervest@gmail.com";
        String password = "123456";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objRoomType.setEmail_address(user);
        objRoomType.setPassword(password);
        objRoomType.clickLogin();
        objRoomType.sleep();

    }

    @Test(priority = 2)
    public void roomTypeSearch(){

        objBrowser.driver.get(objBrowser.site + "admin/manage-property-types");
        objRoomType.setRoomTypeSearch(randomString);
        if (objBrowser.driver.getPageSource().contains("No results found.")){
            System.out.println("Room type search complete.");
        }else {System.out.println("Room type search fail.");}

        System.out.println("");

    }


    @Test(priority = 3)
    public void addNewRoomType(){
        objRoomType.setAddNewRoomType(randomString,randomNumber);
        if (objBrowser.driver.getPageSource().contains("The room type '" +  randomString + "' has been created.")){
            System.out.println("Room type" + " "+ randomString+ " "+  "adding complete.");
        }else {System.out.println("Room type adding fail.");}

        System.out.println("");

    }

    @Test(priority = 4)
    public void editRoomType(){
        String editDescription = RandomStringUtils.randomAlphabetic(6);
        objRoomType.setRoomTypeSearch(randomString);
        objRoomType.setEditRoomType(editDescription);
        if (objBrowser.driver.getPageSource().contains("The room type '" +  randomString + "' has been updated.")){
            System.out.println("Room type" + " "+ randomString+ " "+  "updating complete.");
        }else {System.out.println("Room type updating fail.");}

        System.out.println("");

    }


    @Test(priority = 5)
    public void roomTypeDBVerification() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();
        String Query1 = "SELECT * FROM propertytypes WHERE name = '" + randomString + "'";
        ResultSet rs = stmt.executeQuery(Query1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1);
                String columnValue = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + "room type" + " " + randomString + " " + "is" + " " +  "=" + " " + columnValue);

            }

            System.out.println("");

        }

        System.out.println("DB verification for" + " " + " " + "room type" + " " + randomString + " " +  "is complete.");
        System.out.println("");

    }




    @Test(priority = 6)
    public void deleteRoomType(){
        objRoomType.setRoomTypeSearch(randomString);
        objRoomType.setDeleteType();
        if (objBrowser.driver.getPageSource().contains("The room type '" +  randomString + "' has been deleted.")){
            System.out.println("Room type" + " "+ randomString+ " "+  "deleting complete.");
        }else {System.out.println("Room type deleting fail.");}

        System.out.println("");

    }



}
