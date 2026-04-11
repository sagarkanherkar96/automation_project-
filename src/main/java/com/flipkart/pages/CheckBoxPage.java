package com.flipkart.pages;

import com.flipkart.actiondriver.ActionDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxPage {
    private ActionDriver actionDriver;

    public CheckBoxPage(WebDriver driver){
        actionDriver=new ActionDriver(driver);
    }

    By checkBoxOption = By.xpath("//span[text()='Check Box']");
    By expandAllButton = By.xpath("//button[@aria-label='Expand all']");
    By collapseAll = By.xpath("//button[@aria-label='Collapse all']");
    By homeToggle = By.xpath("//span[text()='Home']/parent::label/preceding-sibling::button[@aria-label='Toggle']");
    By desktopToggle = By.xpath("//span[text()='Desktop']/parent::label/preceding-sibling::button[@aria-label='Toggle']");
    By downloadsToggle = By.xpath("//span[text()='Downloads']/parent::label/preceding-sibling::button[@aria-label='Toggle']");
    By homeCheckbox = By.xpath("//span[text()='Home']/preceding-sibling::span[@class='rct-checkbox']");
    By desktopCheckbox = By.xpath("//span[text()='Desktop']/preceding-sibling::span[@class='rct-checkbox']");
    By notesCheckbox = By.xpath("//span[text()='Notes']/preceding-sibling::span[@class='rct-checkbox']");
    By commandsCheckbox = By.xpath("//span[text()='Commands']/preceding-sibling::span[@class='rct-checkbox']");
    By documentsCheckbox = By.xpath("//span[text()='Documents']/preceding-sibling::span[@class='rct-checkbox']");
    By getExpandedNodesList =By.xpath("//span[@class='rct-title']");
    By unchecked = By.xpath("//svg[contains(@class,'rct-icon-uncheck')]");
    By checked = By.xpath("//svg[contains(@class,'rct-icon-check')]");

    public void openCheckBox(){
        actionDriver.click(checkBoxOption);
    }
    public void clickOnHomeToggle(){
        openCheckBox();
        actionDriver.click(homeToggle);
    }

    public int verifyExpandAll(){
        openCheckBox();
        actionDriver.click(expandAllButton);
        List<WebElement> elements=actionDriver.getWebElements(getExpandedNodesList);
        return elements.size();
    }

    public int verifyCollapseAll() throws InterruptedException {
        openCheckBox();
        actionDriver.click(expandAllButton);
        Thread.sleep(2000);
        actionDriver.click(collapseAll);
        List<WebElement> elements=actionDriver.getWebElements(getExpandedNodesList);
        return elements.size();
    }

    public void verifyAllChecked(){
        openCheckBox();
        actionDriver.isDisplayed(checked);
    }
    public void checkHomeCheckbox(){
        openCheckBox();
        actionDriver.click(homeCheckbox);
    }

}
