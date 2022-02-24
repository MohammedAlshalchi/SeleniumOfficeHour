package com.cydeo.tests.practice_02_23_2022;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;


public class SmartBearTest {


WebDriver driver;
   String appUrl="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
   String userName ="Tester";
   String password ="test";


    /*
    TC-1: SmartBearSoftware CheckBox Button Test
    1- Open a chrome browser
    2- Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3- Verify title equals: Expected: Web Orders Login
    4- Enter username: Tester
    5- Enter password: test
    6- Click “Sign In” button
    7- Locate and click checkbox button for Paul Brown
    8- Verify Paul Brown checkbox is selected
    9- Click checkbox button for All
    10- Verify All checkbox is selected.
*/
   @BeforeMethod
   public void setUpMethod () throws InterruptedException {



       driver = WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


      driver.get(appUrl);


      String expectedTitle= "Web Orders Login";
      String actualTitle=driver.getTitle();

      Assert.assertEquals(actualTitle,expectedTitle,"Before Title did not match");

      //Thread.sleep(3000);
      driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
     // Thread.sleep(3000);
      driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
    //  Thread.sleep(3000);
      driver.findElement(By.id("ctl00_MainContent_login_button")).click();

   }


@Test
   public void loginTest (){


   String expectedTitle= "Web Orders";
   String actualTitle=driver.getTitle();

  Assert.assertEquals(actualTitle,expectedTitle,"After Title did not match");


}

@Test
public void checkBoxTest(){
//       7. Locate and click checkbox button for Paul Brown
    WebElement paulBox = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
    paulBox.click();

//        8- Verify Paul Brown checkbox is selected
    Assert.assertTrue(paulBox.isSelected());
    System.out.println(paulBox.isSelected());
    paulBox.click();// we click again so will be back as the start ( we click at line 85 )

//        9- Click checkbox button for All
    //     10- Verify All checkbox is selected.
    List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(WebElement eachBox : boxes){
        eachBox.click();
        Assert.assertTrue(eachBox.isSelected());
        //System.out.println(eachBox.isSelected());
    }
}






    @Test
    public void radioButtonTest(){
//        7-  Locate and Click “Order”
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

//        8-  Locate and click “Visa” radio button
        WebElement visaButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaButton.click();

//        9-  Verify “Visa” radio button is selected
       // System.out.println(visaButton.isSelected());
        Assert.assertTrue(visaButton.isSelected());

    }

    @Test
    public void dropDownTest(){
//        7-  Locate and Click “Order”
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();

//        8-  Locate Product dropdown and Select FamilyAlbum
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(product);
        select.selectByVisibleText("FamilyAlbum");

//        9-  Verify selected option is FamilyAlbum
        String expectedOption = "FamilyAlbum";
        String actualOption= select.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption,"FamilyAlbum option did not selected!");

    }





@AfterMethod
   public void tearDown (){

      driver.close();



}










/*
TC-2: SmartBearSoftware Radio Button Test
1- Open a chrome browser
2- Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3- Verify title equals: Expected: Web Orders Login
4- Enter username: Tester
5- Enter password: test
6- Click “Sign In” button
7-  Locate and Click “Order”
8-  Locate and click “Visa” radio button
9-  Verify “Visa” radio button is selected
 */


}
