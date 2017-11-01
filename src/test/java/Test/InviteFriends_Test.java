package Test;

import PageFactory.Browser_SetUp;
import Pages.InviteFriends;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created by Hashantha on 6/21/2017.
 */
public class InviteFriends_Test {


    Browser_SetUp objBrowser;
    InviteFriends objInviteFriends;

    String email_1 = RandomStringUtils.randomAlphabetic(10) + "@test.com";
    String email_2 = RandomStringUtils.randomAlphabetic(10) + "@test.com";
    String email_3 = RandomStringUtils.randomAlphabetic(10) + "@test.com";

    String columnValue1;
    String columnValue2;
    String columnValue3;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @BeforeMethod()
    public void beforeMethods(){
        objInviteFriends = new InviteFriends(this.objBrowser.driver);

    }

    @Test(priority = 1)
    public void loginUser(){
        String user = "invitefriendtest@gmail.com";
        String password = "1qaz2wsx@";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objInviteFriends.setEmail_address(user);
        objInviteFriends.setPassword(password);
        objInviteFriends.clickLogin();
        objInviteFriends.sleep();

    }


    @Test(priority = 2)
    public void inviteFriend(){
        objBrowser.driver.get(objBrowser.site + "invite-friends");
        objInviteFriends.setSendInvitation(email_1,email_2,email_3);

    }


    @Test(priority = 3)
    public void getInviteCode() throws SQLException, ClassNotFoundException {

     /*   String email_1 = "zxjxpvanll@test.com";
        String email_2 = "lpiyblqzwm@test.com";
        String email_3 = "xeeihayzro@test.com";*/

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();
        String Query1 = "SELECT  invite_code FROM invite_friends WHERE invited_email = '" + email_1 + "'";
        ResultSet rs = stmt.executeQuery(Query1);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1)
                    System.out.println(", ");
                columnValue1 = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + email_1 + " " + "=" + " " + columnValue1);

            }

            System.out.println("");

        }

        String Query2 = "SELECT  invite_code FROM invite_friends WHERE invited_email = '" + email_2 + "'";
        rs = stmt.executeQuery(Query2);
        rsmd = rs.getMetaData();
        columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1)
                    System.out.println(", ");
                columnValue2 = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + email_2 + " " + "=" + " " + columnValue2);

            }
            System.out.println("");

        }

        String Query3 = "SELECT  invite_code FROM invite_friends WHERE invited_email = '" + email_3 + "'";
        rs = stmt.executeQuery(Query3);
        rsmd = rs.getMetaData();
        columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1)
                    System.out.println(", ");
                columnValue3 = rs.getString(i);
                System.out.println(rsmd.getColumnName(i) + " " + "for" + " " + email_3 + " " + "=" + " " + columnValue3);
            }

            System.out.println("");

        }

    }

    @Test(priority = 4)
    public void registerUser1WithInviteCode(){
        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.sleep();
        objBrowser.driver.get(objBrowser.site + "user/register?token=" + columnValue1);
        String password = "1qaz2wsx@";

        String randomName = RandomStringUtils.randomAlphabetic(20);
        objInviteFriends.setRegisterFirstname(randomName);
        objInviteFriends.setRegisterSurname(randomName);
        objInviteFriends.setRegisterEmail(email_1);
        objInviteFriends.clickShowPassword();
        objInviteFriends.setRegisterPassword(password);
        objInviteFriends.clickRegister();
        objInviteFriends.userPreference();
        objBrowser.sleep();

    }

    @Test(priority = 5)
    public void registerUser2WithInviteCode(){
        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.sleep();
        objBrowser.driver.get(objBrowser.site + "user/register?token=" + columnValue2);
        String password = "1qaz2wsx@";

        String randomName = RandomStringUtils.randomAlphabetic(20);
        objInviteFriends.setRegisterFirstname(randomName);
        objInviteFriends.setRegisterSurname(randomName);
        objInviteFriends.setRegisterEmail(email_2);
        objInviteFriends.clickShowPassword();
        objInviteFriends.setRegisterPassword(password);
        objInviteFriends.clickRegister();
        objInviteFriends.userPreference();
        objBrowser.sleep();

    }

    @Test(priority = 6)
    public void registerUser3WithInviteCode(){
        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.sleep();
        objBrowser.driver.get(objBrowser.site + "user/register?token=" + columnValue3);
        String password = "1qaz2wsx@";

        String randomName = RandomStringUtils.randomAlphabetic(20);
        objInviteFriends.setRegisterFirstname(randomName);
        objInviteFriends.setRegisterSurname(randomName);
        objInviteFriends.setRegisterEmail(email_3);
        objInviteFriends.clickShowPassword();
        objInviteFriends.setRegisterPassword(password);
        objInviteFriends.clickRegister();
        objInviteFriends.userPreference();
        objBrowser.sleep();
        objBrowser.driver.get(objBrowser.site + "user/logout");

    }


    @Test(priority = 7)
    public void confirmTokenRegistration() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.183/roomflip", "qa", "qa123");
        Statement stmt = con.createStatement();

        String Query4 = "SELECT invite_code, is_registered FROM invite_friends WHERE invited_email IN ('" + email_1 + "','" + email_2 + "', '" + email_3 + "' )";
        ResultSet rs = stmt.executeQuery(Query4);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (i > 1);
                String columnValue = rs.getString(i);
                System.out.println(rsmd.getColumnName(i)  + " " + "=" + " " + columnValue);

            }

            System.out.println("");

        }
        System.out.println("All the invited users are successfully registered as host users.");

    }


}
