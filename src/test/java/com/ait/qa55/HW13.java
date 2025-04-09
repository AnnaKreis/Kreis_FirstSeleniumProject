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
        //href="/digital-downloads"
        driver.findElement(By.cssSelector("[href*='downloads']"));
        //start->^
        driver.findElement(By.cssSelector("[href^='/gift']"));
        driver.findElement(By.cssSelector("[href^='/digital']"));
        //end on->$
        driver.findElement(By.cssSelector("[href$='/shoes']"));
    }

    @Test
    public void findElementByXpath(){
        //xpath -> tag


        //id->xpath -> //*[@id='value']
        //driver.findElement(By.id("bar-notification"));
        driver.findElement(By.xpath("//div[@id='bar-notification']"));
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));

        //className-> //*[@class='value']
        //driver.findElement(By.className("master-wrapper-main"));
        driver.findElement(By.xpath("//div[@class='master-wrapper-main']"));
        //driver.findElement(By.className("footer"));
        driver.findElement(By.xpath("//div[@class='footer']"));

        //contains-> //*[@contains(.,'Text')] частичное совпадение
        driver.findElement(By.xpath("//h2[contains(.,'Welcome')]"));
        //equal-> //*[text()='Text')] точное совпадение, оба варианта
        driver.findElement(By.xpath("//h3[text()='Customer service']"));
        driver.findElement(By.xpath("//h3[.='Information']"));

        //starts-with-> //*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//input[starts-with(@autocomplete,'of')]"));
        driver.findElement(By.xpath("//div[starts-with(@title,'Err')]"));

        //move up
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/.."));
        driver.findElement(By.xpath("//ul[@class='top-menu']/.."));

        // parent
        driver.findElement(By.xpath("//a[@class='ico-register']/parent::*"));
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']/parent::form"));
        driver.findElement(By.xpath("//a[@class='ico-register']/.."));

       //ancestor
        driver.findElement(By.xpath("//a[@class='ico-register']/ancestor::*")); //all
        driver.findElement(By.xpath("//a[@class='ico-register']/ancestor::div")); //five options
        driver.findElement(By.xpath("//a[@class='ico-register']/ancestor::div[4]")); //one option

//        //child
        driver.findElement(By.xpath("//div[@class='leftside-3']/following-sibling::div"));
        driver.findElement(By.xpath("//div[@class='nivo-caption']/following-sibling::div"));

    }

}
