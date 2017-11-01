package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Browser_SetUp;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Hashantha on 6/16/2017.
 */
public class Messages extends Browser_SetUp {


    //Login form
    @FindBy(id = "emailOrUsername")
    WebElement email_address;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    WebElement login_button;

    //Write new message form
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/div/section/div/section/form/div/div/div[1]/div/div/div[1]/a")
    WebElement newMessage;
    @FindBy(id = "edit-recipient")
    WebElement to;
    @FindBy(id = "edit-subject")
    WebElement subject;
    @FindBy(id = "edit-body-value")
    WebElement messageField;
    @FindBy(id = "edit-submit")
    WebElement sendMessage;
    @FindBy(id = "edit-body-value")
    WebElement continueMessage;
    @FindBy(id = "edit-cancel")
    WebElement clear;
    @FindBy (id = "edit-submit")
    WebElement sendConversation;
    @FindBy (xpath = "/html/body/div[1]/div/div/div/div/div/div/div/div/div/section/div/section/div[3]/div[1]/div[2]/div/div[2]/div/button")
    WebElement deleteCon;
    @FindBy (xpath = "/html/body/div[3]/div/button[3]")
    WebElement confirmDelete;


    //Sent message form
    @FindBy(linkText = "Subject")
    WebElement subjectOrder;
    @FindBy(linkText = "From")
    WebElement fromOrder;
    @FindBy(id = "select-all")
    WebElement selectAll;
    @FindBy(xpath = "//*[@id=\"edit-operation\"]")
    WebElement readActions;

    //Delete message form
    @FindBy(id = "edit-delete")
    WebElement delete;
    @FindBy(xpath = "//*[@id=\"remodal-confirm\"]")
    WebElement confirmSelectDel;




    public Messages(WebDriver driver) {

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


    //WriteNewMsg data passing
    public void setNewMessage(){
        newMessage.click();
        sleep();

    }
    public void sendNewMessage(String toValue,  String randomName, String message){
        to.sendKeys(toValue);
        subject.sendKeys(randomName);
        messageField.sendKeys(message);
        sendMessage.click();
        continueMessage.sendKeys(randomName);
        clear.click();
        continueMessage.sendKeys(randomName);
        sendConversation.click();
        deleteCon.click();
        confirmDelete.click();

    }


    //SentMsg data passing
    public void sentMessages(){

        subjectOrder.click();
        sleep();
        fromOrder.click();
        sleep();
        selectAll.click();
        Select unread = new Select(readActions);
        unread.selectByIndex(2);
        selectAll.click();
        Select read = new Select(readActions);
        read.selectByIndex(1);
    }


    //Archive data passing
    public void archive(){
        selectAll.click();
        Select archive = new Select(readActions);
        archive.selectByIndex(3);
        sleep();

    }

    //DeleteMsg data passing
    public void delete(){
        selectAll.click();
        delete.click();
        sleep();
        confirmSelectDel.click();
    }



}
