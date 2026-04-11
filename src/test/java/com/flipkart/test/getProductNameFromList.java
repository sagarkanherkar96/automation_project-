package com.flipkart.test;

import com.flipkart.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class getProductNameFromList extends BaseClass {

    @Test
    public void multipleElementsHandling() {
        WebDriver driver = getDriver();
        List<WebElement> webElements = driver.findElements(By.xpath("//div[@class='product-collection__title mb-3']//a"));
        for (WebElement webElement : webElements) {
            String cardName = webElement.getText();
            System.out.println(cardName);
        }
    }
}
