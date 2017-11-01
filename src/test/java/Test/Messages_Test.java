package Test;

import PageFactory.Browser_SetUp;
import Pages.Messages;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Hashantha on 6/16/2017.
 */
public class Messages_Test {

    Browser_SetUp objBrowser;
    Messages objMessages;

    @BeforeTest()
    public  void  Setup() throws Exception {
        this.objBrowser = new  Browser_SetUp();
        this.objBrowser.setUp();

    }

    @Test(priority = 1)
    public void loginUser(){
        String user = "messagetest1@gmail.com";
        String password = "1qaz2wsx@";

        objBrowser.driver.get(objBrowser.site + "user/login");
        objMessages = new Messages(this.objBrowser.driver);
        objMessages.setEmail_address(user);
        objMessages.setPassword(password);
        objMessages.clickLogin();
        objMessages.sleep();

    }

    @Test(priority = 2)
    public void openNewMessageForm(){
        objBrowser.driver.get(objBrowser.site + "messages");
        objMessages = new Messages(this.objBrowser.driver);
        objMessages.setNewMessage();
    }

    @Test(priority = 3)
    public void sendNewMessage(){

        String toValue = "Reskin431 Reskin431";
        String randomName = RandomStringUtils.randomAlphabetic(20);
        String message = "0711111111" +'\n'+"hashantha@yahoo.com" +'\n'+"https://stack.com";
        objMessages.sendNewMessage(toValue,randomName,message);
    }

    @Test(priority = 4)
    public void sentMessages(){
        objBrowser.driver.get(objBrowser.site + "messages/sent");
        objMessages.sentMessages();
    }

    @Test(priority = 5)
    public  void archive(){
        objBrowser.driver.get(objBrowser.site + "user/logout");
        objBrowser.driver.get(objBrowser.site + "user/login");
        String user = "reskin431@gmail.com";
        String password = "1qaz2wsx@";
        objMessages.setEmail_address(user);
        objMessages.setPassword(password);
        objMessages.clickLogin();
        objMessages.sleep();
        objBrowser.driver.get(objBrowser.site + "messages");
        objMessages.archive();

    }

    @Test(priority = 6)
    public  void delete(){
        objBrowser.driver.get(objBrowser.site + "messages/list");
        objMessages.delete();
    }

}
