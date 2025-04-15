package com.ait.qa55.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    @Test
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href*='/register']")).click();

        //enter name to name field
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Helen");

        //enter last name to last name field
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Straus");

        //enter Email to mail field
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("hatip45779@insfou.com");

        //enter Password to password field
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Aa!12345");

        //enter Confirm Password to confirm password field
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Aa!12345");

        //click on Registration button
        driver.findElement(By.id("register-button")).click();

        //verify that "Registered" is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//h1[text()='Register']")));


    }
}
