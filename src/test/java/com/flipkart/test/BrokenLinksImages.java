package com.flipkart.test;

import com.flipkart.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinksImages extends BaseClass {

    //https://demoqa.com/links
   // MalformedURLException: unknown protocol: javascript occurs when Selenium captures non-HTTP links like javascript:void(0). These must be filtered before making HTTP calls.

    public void brokenLinks() throws IOException {
        WebDriver driver = getDriver();
       List<WebElement> webElementList = driver.findElements(By.xpath("//a"));
        System.out.println(webElementList.size());

       for(WebElement element : webElementList){
           String url = element.getAttribute("href");

           if(url ==null || url.isEmpty()){
               System.out.println("url is empty or null");
               continue;
           }

           // MalformedURLException: unknown protocol: javascript occurs when Selenium captures non-HTTP links like javascript:void(0). These must be filtered before making HTTP calls.
           if (url.startsWith("javascript")
                   || url.startsWith("mailto")
                   || url.startsWith("tel")
                   || url.equals("#")) {
               continue;
           }

           HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
           connection.setRequestMethod("HEAD");
           connection.connect();
          int responseCode = connection.getResponseCode();

          if(responseCode >= 400){
              System.out.println(url+ " broken ink");
          }else {
              System.out.println(url+ " valid link");
          }

       }

    }

    //An image id broken if naturalWidth == 0
    @Test
    public void brokenImage(){
        WebDriver driver = getDriver();
        List<WebElement> webElementList = driver.findElements(By.xpath("//img"));

        System.out.println(webElementList.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(WebElement img : webElementList){
            boolean isImageBroken = (boolean) js.executeScript( "return arguments[0].complete && arguments[0].naturalWidth > 0", img);
            if(isImageBroken){
                System.out.println("valid img " + img.getAttribute("src"));
            }else {
                System.out.println("broken image "+ img.getAttribute("src"));
            }
        }

    }
}
