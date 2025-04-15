package com.ait.qa55.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        //click on Login Link
        click(By.cssSelector("[href*='/register']"));
        //enter name to name field
        type(By.id("FirstName"), "Helen");
        //enter last name to last name field
        type(By.id("LastName"), "Straus");
        //enter Email to mail field
//        type(By.id("Email"), "hatip45779@insfou.com");
        type(By.id("Email"), "test" + i + "@test.com");
        //enter Password to password field
        type(By.id("Password"), "Aa!12345");
        //enter Confirm Password to confirm password field
        type(By.id("ConfirmPassword"), "Aa!12345");
        //click on Registration button
        click(By.id("register-button"));

        //verify that "Registered" is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//h1[text()='Register']")));
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        //click on Login Link
        click(By.cssSelector("[href*='/register']"));
        //enter name to name field
        type(By.id("FirstName"), "Helen");
        //enter last name to last name field
        type(By.id("LastName"), "Straus");
        //enter Email to mail field
        type(By.id("Email"), "hatip45779@insfou.com");
        //enter Password to password field
        type(By.id("Password"), "Aa!12345");
        //enter Confirm Password to confirm password field
        type(By.id("ConfirmPassword"), "Aa!12345");
        //click on Registration button
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("//li[text()='The specified email already exists']")));


    }

}
