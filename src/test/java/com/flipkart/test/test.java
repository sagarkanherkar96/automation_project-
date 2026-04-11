package com.flipkart.test;

import com.flipkart.base.BaseClass;
import org.testng.annotations.Test;

public class test extends BaseClass {


    @Test
    public void loginTest(){
        String title=getDriver().getTitle();
        System.out.println("Title of the page: "+title);
    }
}
