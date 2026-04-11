package com.flipkart.test;

import com.flipkart.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SfAutomation extends BaseClass {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver=getDriver();
       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("dsr.stuti.raizada@jsw.in.uat");
        driver.findElement((By.xpath("//input[@placeholder='Password']"))).sendKeys("JSWUAT@1234");
        driver.findElement(By.xpath("//span[text()='Log in']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//button[text()='Create new opportunity']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(@name,'PlaceOrderfor')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//lightning-base-combobox-item[contains(@data-value,'Self')]")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//span[text()='Select Ship-to address type']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Select Ship-to address type']"));
       // driver.findElement(By.xpath("//lightning-base-combobox-item[contains(@data-value,'Site')]")).click();

//
//        Select select = new Select(element);
//        for (WebElement option : select.getOptions()) {
//            System.out.println(option.getText());
//        }
        Thread.sleep(9000);

//                retailerOrderTypeOption:
//        en_US:
//        web: xpath=(//lightning-base-combobox-item)[2]
//# Self Order Type Address Selection
//        shipToAddressTypeDropdown:
//        en_US:
//        web: xpath=//span[text()='Select Ship-to address type']
//                shipToAddressTypeSite:
//        en_US:
//        web: xpath=//lightning-base-combobox-item[contains(@data-value,'Site')]
//

    }

}