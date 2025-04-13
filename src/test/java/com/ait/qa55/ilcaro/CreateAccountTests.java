package com.ait.qa55.ilcaro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void newUserRegistrationPositiveTest() {
        //click on Login Link
        driver.findElement(By.cssSelector("[href*='/registration']")).click();

        //enter Email to name field
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Helen");

        //enter Email to last name field
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Straus");

        //enter Email to mail field
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("hatip45779@insfou.com");

        //enter Password to password field
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Aa!12345");

        //click on checkbox
        WebElement checkbox = driver.findElement(By.id("terms-of-use"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

        //click on Registration button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //verify that "Registered" is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//h1[text()='Registered']")));


    }

}
