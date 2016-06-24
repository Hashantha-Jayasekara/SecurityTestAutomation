
package net.continuumsecurity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class MyAppNavigation {
    WebDriver driver;
    final static String BASE_URL = "http://localhost:8081/bodgeit/";
    final static String LOGOUT_URL = "http://localhost:8081/bodgeit/logout.jsp";
    final static String USERNAME = "bobby@continuumsecurity.net";
    final static String PASSWORD = "tables";

    public MyAppNavigation(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void login() {
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submit")).click();
        verifyTextPresent("successfully");
   }

    public void registerUser() {
        driver.get(BASE_URL+"register.jsp");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.id("password1")).clear();
        driver.findElement(By.id("password1")).sendKeys(PASSWORD);
        driver.findElement(By.id("password2")).clear();
        driver.findElement(By.id("password2")).sendKeys(PASSWORD);
        driver.findElement(By.id("submit")).click();
    }

    public void navigateBeforeLogin() {
        //driver.get(BASE_URL);
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Doodahs")).click();
        driver.findElement(By.linkText("Zip a dee doo dah")).click();
        driver.findElement(By.linkText("About Us")).click();
        driver.findElement(By.linkText("Scoring page")).click();
        driver.findElement(By.linkText("Your Basket")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[1]/td[2]/input")).sendKeys("testtesttest");
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[3]/td/table/tbody/tr/td[2]/font/form/table/tbody/tr[2]/td[2]/input")).click();

        //Make sure we're on the page we're supposed to be on
        //verifyTextPresent("Search");
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("Advanced Search")).click();
        driver.findElement(By.id("product")).clear();
        driver.findElement(By.id("product")).sendKeys("test");
        driver.findElement(By.id("desc")).clear();
        driver.findElement(By.id("desc")).sendKeys("test");
        driver.findElement(By.id("type")).clear();
        driver.findElement(By.id("type")).sendKeys("test");
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("test");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        //Make sure we're on the page we're supposed to be on
        //verifyTextPresent("No Results Found");
    }

    public void navigateAfterLogin() {



        driver.findElement(By.linkText("Doodahs")).click();
        driver.findElement(By.linkText("Zip a dee doo dah")).click();
        driver.findElement(By.id("submit")).click();

    }


    public void verifyTextPresent(String text) {
        if (!this.driver.getPageSource().contains(text)) throw new RuntimeException("Expected text: ["+text+"] was not found.");
    }
}
