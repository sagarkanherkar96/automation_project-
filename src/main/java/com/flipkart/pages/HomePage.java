package com.flipkart.pages;

import com.flipkart.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private ActionDriver actionDriver;

   private By element = By.xpath("//h5[text()='Elements']");
   private By forms = By.xpath("//h5[text()='Forms']");
   private By alertsWindowFrames = By.xpath("//h5[text()='Alerts, Frame & Windows']");
   private By widgets = By.xpath("//h5[text()='Widgets']");
   private By interaذtions = By.xpath("//h5[text()='Interactions']");
   private By bookStoreApplication = By.xpath("//h5[text()='Book Store Application']");
   private By toolsQaLogo = By.xpath("//img[@src='/images/Toolsqa.jpg']");


   public HomePage(WebDriver driver){
       this.actionDriver=new ActionDriver(driver);
   }

   //method to varify logo is displayed
    public boolean verifyToolsQaLogo(){
       return actionDriver.isDisplayed(toolsQaLogo);
    }

    //method to click and open element page
    public void clickOnElement(){
       actionDriver.scrollToElement(element);
        actionDriver.click(element);
    }

    //method to click and open forms page
    public void clickOnForms(){
        actionDriver.click(forms);
    }

    //method to click and open alerts window and frames page
    public void clickOnAlertsWindow(){
        actionDriver.click(alertsWindowFrames);
    }

    //method to click and open widgets
    public void clickOnWidgets(){
        actionDriver.click(widgets);
    }

    //method to click & open interactions
    public void clickOnInetraذtions(){
        actionDriver.click(interaذtions);
    }

    //Method to click & open book store application
    public void clickOnBookStoreApp(){
        actionDriver.click(bookStoreApplication);
    }

}
