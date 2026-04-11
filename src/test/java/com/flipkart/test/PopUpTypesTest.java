package com.flipkart.test;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.flipkart.base.BaseClass;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class PopUpTypesTest extends BaseClass {
    //Hidden division pop-up https://www.abhibus.com/
   // @Test
    public void hiddenDivisionPopUp() throws InterruptedException {
      WebDriver driver =getDriver();
      driver.findElement(By.xpath("//span[text()='Login/SignUp']")).click();
      driver.findElement(By.xpath("//span[text()='Enter Mobile Number to Continue ']/following:: input[1]")).sendKeys("8756453423");
      driver.findElement(By.xpath("//span[text()='Enter Mobile Number to Continue ']/following:: input[2]")).sendKeys("flat500Off");
        Thread.sleep(1000);
      driver.findElement(By.xpath("//button[text()='Login']")).click();
      Thread.sleep(5000);
    }

    //Alert pop-up/javascript popup https://the-internet.herokuapp.com/
   // @Test
    public void alertPopUp() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        Alert a = driver.switchTo().alert();
        Thread.sleep(2000);
        a.accept();
       // alert.dismiss();
        //alert.sendKeys("Sagar");
        //alert.getText()
        Thread.sleep(2000);

    }

    //Child-Browser pop-up https://demoqa.com/browser-windows
   // @Test
    public void childBrowserPopUp() throws InterruptedException {
        WebDriver driver=getDriver();
        driver.findElement(By.id("windowButton")).click();
        Set<String> window = driver.getWindowHandles();
        String parent = driver.getWindowHandle();
        System.out.println(window.size());
        System.out.println(driver.getTitle());

        for (String windowId : window) {
            if (!windowId.equals(parent)) { // close only child
                driver.switchTo().window(windowId);
                Thread.sleep(1000);
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.getTitle());
                driver.manage().window().maximize();
                Thread.sleep(1000);
                driver.close();
            }
        }
        Thread.sleep(1000);
        driver.switchTo().window(parent);
        Thread.sleep(1000);

//        Iterator itr = window.iterator();
//        while (itr.hasNext()) {
//            String refId = itr.next().toString();
//            driver.switchTo().window(refId);
//            Thread.sleep(2000);
//            if(refId!=parent) {
//                driver.close();
//            }
//            Thread.sleep(2000);
//        }

    }

    @Test
    //file upload pop-up
    //using sendkeys https://demoqa.com/upload-download only we can use when popUp created using input tag and type= file attribute
    public void fileUploadPopUp() throws InterruptedException, AWTException {
        WebDriver driver = getDriver();
       WebElement element =  driver.findElement(By.id("uploadFile"));
       //using sendkeys
//        String relativePath = "src/test/resources/testdata/TestData.xlsx";
//        File f = new File(relativePath);
//        String absolutePath = String.valueOf(f.getAbsoluteFile());
//        Thread.sleep(1000);
//        System.out.println(absolutePath);
//        element.sendKeys(absolutePath);
//        Thread.sleep(1000);

        //using robot can't work in mac and jenkin because no UI headless,No active screen, Robot works at the OS level, not browser level.
//        element.click();
//        Thread.sleep(1000);
//        Robot r = new Robot();
//        Thread.sleep(1000);
//        r.keyPress(KeyEvent.VK_C);
//        r.keyRelease(KeyEvent.VK_C);
//        Thread.sleep(1000);
//        r.keyPress(KeyEvent.VK_DOWN);
//        r.keyRelease(KeyEvent.VK_DOWN);
//        Thread.sleep(1000);
//        r.keyPress(KeyEvent.VK_ENTER);
//        r.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(1000);

        //using AutoIt

    }

    //Authentication popUp https://the-internet.herokuapp.com/basic_auth
    public void authenticationPopUp(){
        //Approch 01 pass username and password in url
        //Approch 02 using Robot class
        //Approch 03 using third party tool Auto it
    }

    //Notification popUp
    public void notificationPopUp(){
        //Approch 01 -> handle by changing chromeBrowser setting. chromeOptions options =new options();
    }

    // Window popup
    public void windowPopUp(){
        //approch 01 ->handle using keyStroke
        //Approch 02 -> handle using third party tool
      //  Runtime .getRuntime().exec("location of autoit script .exc location");
    }



}
