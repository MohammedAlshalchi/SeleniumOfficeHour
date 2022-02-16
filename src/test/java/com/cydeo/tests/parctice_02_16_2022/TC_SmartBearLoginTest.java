package com.cydeo.tests.parctice_02_16_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC_SmartBearLoginTest {
    public static void main(String[] args) {
        String appUrl="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        String userName ="Tester";
        String password ="test";

//TC-1: Basic login authentication
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2- Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get(appUrl);


        String expectedTitle= "Web Orders Login";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification before login is passed!");
        }else{
            System.out.println("Title verification before login is failed!");
        }



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
driver.findElement(By.id("ctl00_MainContent_login_button")).click();
String expected = "Web Orders";
String actual = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification after login is passed!");
        }else{
            System.out.println("Title verification afdter login is failed!");
        }


        // 3- Verify title equals:
        // Expected: Web Orders Login
        // 4- Enter username: Tester
        // 5- Enter password: test
        // 6- Click “Sign In” button
        // 7- Verify title equals:
        // Expected: Web Orders


//driver.quit();






    }
}
