package com.flipkart.test;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.flipkart.base.BaseClass;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.TextBoxPage;
import com.flipkart.utilities.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    private HomePage homePage;
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setupPages(){
        homePage=new HomePage(getDriver());
        textBoxPage = new TextBoxPage(getDriver());
    }

    @Test
    public void verifyToolsQaLogo(){
       Assert.assertTrue( homePage.verifyToolsQaLogo());
    }

    @Test
    public void openElement(){
        homePage.clickOnElement();
    }
}
