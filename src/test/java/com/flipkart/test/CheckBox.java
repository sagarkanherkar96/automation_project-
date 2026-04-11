package com.flipkart.test;

import com.flipkart.base.BaseClass;
import com.flipkart.pages.CheckBoxPage;
import com.flipkart.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox extends BaseClass {
   HomePage homePage;
   CheckBoxPage checkBoxPage;

   @BeforeMethod
   public void setupPages(){
       homePage=new HomePage(getDriver());
       checkBoxPage = new CheckBoxPage(getDriver());
   }


   public void  verifyCollapseAll() throws InterruptedException {
       homePage.clickOnElement();
     int webElementCount= checkBoxPage.verifyCollapseAll();
       Assert.assertEquals(webElementCount,1);
   }


    public void  verifyExpandAll(){
        homePage.clickOnElement();
        int webElementCount= checkBoxPage.verifyExpandAll();
        Assert.assertEquals(webElementCount,17);
    }

    @Test
    public void  verifyHomePageCheckbox() throws InterruptedException {
        homePage.clickOnElement();
        checkBoxPage.checkHomeCheckbox();
        Thread.sleep(3000);

    }

}
