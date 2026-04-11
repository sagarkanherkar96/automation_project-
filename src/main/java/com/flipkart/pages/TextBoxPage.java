package com.flipkart.pages;

import com.flipkart.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TextBoxPage {
    private ActionDriver actionDriver;

    private By fullName = By.id("userName");
    private By email = By.xpath("//input[@id='userEmail']");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By textBox = By.xpath("//span[text()='Text Box']");
    private By submittedName = By.id("name");
    private By submittedEmail = By.id("email");
    private By submittedCurrentAddress = By.xpath("//p[@id='currentAddress']");
    private By submittedPermanentAddress = By.xpath("//p[@id='permanentAddress']");
    private By outputBox = By.xpath("//div[@id='output']");

    public TextBoxPage(WebDriver driver){
        this.actionDriver = new ActionDriver(driver);
    }

    public void enterFullName(String fullName){
       actionDriver.enterText(this.fullName,fullName);
    }

    public void enterEmail(String email){
        actionDriver.enterText(this.email,email);
    }

    public void enterCurrentAddress(String currentAddress){
        actionDriver.enterText(this.currentAddress,currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress){
        actionDriver.enterText(this.permanentAddress,permanentAddress);
    }

    public void clickSubmitButton(){
        actionDriver.click(submitButton);
        actionDriver.scrollToElement(outputBox);
    }


    //Method to fill form and submit
    public void fillNdSubmitForm(String firstName,String email,String currentAddress,String permanentAddress){
        actionDriver.click(textBox);
        enterFullName(firstName);
        enterEmail(email);
        enterCurrentAddress(currentAddress);
        enterPermanentAddress(permanentAddress);
        clickSubmitButton();
    }

    public boolean verifySubmittedName(String firstName){
       return  ( actionDriver.getText(submittedName).split(":")[1].trim()).equals("firstName");
    }
    public boolean verifySubmittedEmail(String email){
        return  ( actionDriver.getText(submittedEmail).split(":")[1].trim()).equals(email);
    }
    public boolean verifySubmittedCurrentAddress(String currentAddress){
        return  ( actionDriver.getText(submittedCurrentAddress).split(":")[1].trim()).equals(currentAddress);
    }
    public boolean verifySubmittedPermanentAddress(String permanentAddress){
        return  ( actionDriver.getText(submittedPermanentAddress).split(":")[1].trim()).equals(permanentAddress);
    }
     public boolean verifySubmittedData(String firstName,String email,String currentAddress,String permanentAddress){
         actionDriver.click(textBox);
         fillNdSubmitForm( firstName, email, currentAddress, permanentAddress);
         enterFullName(firstName);
         enterEmail(email);
         enterCurrentAddress(currentAddress);
         enterPermanentAddress(permanentAddress);
         clickSubmitButton();

         return verifySubmittedName(firstName) && verifySubmittedEmail(email) && verifySubmittedCurrentAddress(currentAddress) && verifySubmittedPermanentAddress(permanentAddress);
    }

    public boolean validateInvalidEmail(){
        actionDriver.click(textBox);
        enterEmail("sagar");
        actionDriver.scrollToElement(submitButton);
        clickSubmitButton();
        String cssValue = actionDriver.getCssValue(email,"border-color");
        System.out.println("css valus ================"+cssValue);
       return cssValue.equals("rgb(255, 0, 0)");
    }
}
