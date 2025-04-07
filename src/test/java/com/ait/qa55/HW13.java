package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW13 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
    }
    @Test
    public void openDemowebshopTest() {
        System.out.println("Good evening");
    }
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementBySimpleLocators(){
        driver.findElement(By.id("dialog-notifications-success"));
        driver.findElement(By.id("dialog-notifications-error"));
        driver.findElement(By.id("bar-notification"));
        driver.findElement(By.id("mob-menu-button"));
        driver.findElement(By.className("mob-top-menu"));
        driver.findElement(By.className("master-wrapper-main"));
        driver.findElement(By.className("title"));
        driver.findElement(By.className("footer"));
        System.out.println(driver.findElement(By.className("footer")).getText());
        driver.findElement(By.linkText("Computers"));
        driver.findElement(By.linkText("Log in"));
        driver.findElement(By.partialLinkText("Digital"));
        driver.findElement(By.partialLinkText("Shopping"));
    }
    @Test
    public void findElementByCssSelector(){
        // by tagName
        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("title"));
        // by id->
        driver.findElement(By.cssSelector("#topcartlink"));
        driver.findElement(By.cssSelector("#flyout-cart"));
        // by className->
        driver.findElement(By.cssSelector(".search-box"));
        driver.findElement(By.cssSelector(".header-menu"));
        //[attr='value']
        driver.findElement(By.cssSelector("[href='/apparel-shoes']"));
        driver.findElement(By.cssSelector("[href='/register']"));
        //contains
        driver.findElement(By.cssSelector("[href*='/books']"));
        driver.findElement(By.cssSelector("[href*='/apparel']"));
        //start->^
        driver.findElement(By.cssSelector("[href^='/gift']"));
        driver.findElement(By.cssSelector("[href^='/digital']"));
        //end on->$
        //href="/digital-downloads"
//        driver.findElement(By.cssSelector("[href$='/downloads']"));
        driver.findElement(By.cssSelector("[href$='/shoes']"));







    }



}
