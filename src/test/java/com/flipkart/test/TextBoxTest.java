package com.flipkart.test;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.flipkart.base.BaseClass;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.TextBoxPage;
import com.flipkart.utilities.DataProviders;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class TextBoxTest extends BaseClass {

    TextBoxPage textBoxPage;
    HomePage homePage;

    @BeforeMethod
    public void setupPages(){
        homePage=new HomePage(getDriver());
        textBoxPage=new TextBoxPage(getDriver());

    }

//    @Test (dataProvider="validFormData", dataProviderClass = DataProviders.class)
//  public void fillNdSubmitForm(String firstName,String email,String currentAddress,String permanentAddress){
//        homePage.clickOnElement();
//        textBoxPage.fillNdSubmitForm(firstName,email,currentAddress,permanentAddress);
//  }
//
//    @Test (dataProvider="validFormData", dataProviderClass = DataProviders.class)
//    public void verifySubmittedData(String firstName,String email,String currentAddress,String permanentAddress){
//        homePage.clickOnElement();
//       Assert.assertTrue( textBoxPage.verifySubmittedData( firstName, email, currentAddress, permanentAddress));
//  }

 // @Test
    public void verifyInvalidEmailId() throws InterruptedException {
        homePage.clickOnElement();
        Assert.assertTrue(textBoxPage.validateInvalidEmail());

  }

    public void keyStroke() throws InterruptedException {
        //google.com
        WebDriver driver=getDriver();
       WebElement s= driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
       s.sendKeys("selenium");
      Thread.sleep(5000);
      s.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(5000);
      s.sendKeys(Keys.ARROW_DOWN);
      Thread.sleep(5000);
      s.sendKeys(Keys.ENTER);

      List<WebElement>ele=driver.findElements(By.xpath("//span[contains(text(),'selenium')]\n"));
  }

  @Test
public void listBoxHandling() throws InterruptedException, AWTException {
        //facebook.com
      WebDriver driver = getDriver();
      driver.findElement(By.linkText("Create new account")).click();
      driver.findElement(By.id("day")).click();
      driver.findElement(By.xpath("//option[text()='6']")).click();
      driver.findElement(By.id("month")).click();
      Thread.sleep(5000);
      Robot robot=new Robot();
    //  robot.keyPress(KeyEvent.VK_UP);
    //  robot.keyRelease(KeyEvent.VK_UP);

     // Thread.sleep(5000);
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.keyRelease(KeyEvent.VK_DOWN);

      robot.keyPress(KeyEvent.VK_ENTER);
     // Thread.sleep(5000);
      WebElement webElement=driver.findElement(By.id("year"));
      Select s=new Select(webElement);
      s.selectByValue("2012");
    //  Thread.sleep(5000);
      s.selectByIndex(2);
     // Thread.sleep(5000);
      s.selectByVisibleText("2015");
     List<WebElement>ref= s.getOptions();
      System.out.println(ref.size());


      Thread.sleep(5000);
}
}
