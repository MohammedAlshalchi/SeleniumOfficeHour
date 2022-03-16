package com.cydeo.tests.practice_03_02_2202;



import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class CRM_VotePoll {
    WebDriver driver;




    /*
    AYSON NOTE
     US7 :  WebElement optionButton = driver.findElement(By.xpath("//label[.='JAVA']"));
text of  'JAVA' can change depends on which poll you are testing. If you create your own poll and want to test on it please do not forget to change text part!!!

2

     */
    @BeforeMethod
    public void setupMethod() {

        //We are getting the browserType dynamically from our configuration.properties file
        String browserType = ConfigurationReader.getProperty("browser");

        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("env1"));

        CRM_Utilities.crm_login(driver);

    }


    @Test
    public void Vote() {

        WebElement optionButton = driver.findElement(By.xpath("//label[.='JAVA']"));

        BrowserUtils.sleep(3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionButton);
        optionButton.click();
        BrowserUtils.sleep(3);

        WebElement voteButton = driver.findElement(By.xpath("(//button[.='Vote'])[1]"));

        BrowserUtils.sleep(3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteButton);

        voteButton.click();
        BrowserUtils.sleep(3);
        WebElement voteAgainButton = driver.findElement(By.xpath("(//button[.='Vote again'])[1]"));
        BrowserUtils.sleep(3);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteAgainButton);
        assertTrue(voteAgainButton.isDisplayed());

        voteAgainButton.click();
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }
























}
