package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void findElementTest() {
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println();

        //find list of elements by tag name
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }
    @Test
    public void findElementBySimpleLocators(){
        // by id
        driver.findElement(By.id("city"));
        // by className
        driver.findElement(By.className("header"));
        System.out.println(driver.findElement(By.className("header")).getText());
        // by linkText
        driver.findElement(By.linkText("Let the car work"));
        // by partialLinkText частичное совпадение
        driver.findElement(By.partialLinkText("car"));
    }
    @Test
    public void findElementByCssSelector(){
        // tagName == css
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        // id-> css(#) чтобы локатор превратить в css селектор
        //driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        // by className->
        //driver.findElement(By.className("header"));
        driver.findElement(By.cssSelector(".header"));

        //[attr='value']
        // href="/registration?url=%2Fsearch"
        //точное совпадение
        driver.findElement(By.cssSelector("[href='/registration?url=%2Fsearch']"));
        // contains(частичное совпадение) ->*
        driver.findElement(By.cssSelector("[href*='/registration']"));
        //start->^
        driver.findElement(By.cssSelector("[href^='/reg']"));
        //end on->$
        driver.findElement(By.cssSelector("[href$='/search']"));
        //tag+id
        driver.findElement(By.cssSelector("input#city"));
        driver.findElement(By.cssSelector("div.mobile-header"));
        driver.findElement(By.cssSelector("div.search-card"));
        //tag+id+[attr='value']
        driver.findElement(By.cssSelector("input#city[type='text']"));
    }

    //       //*[@att='value']
    @Test
    public void findElementByXpath(){
        //xpath -> tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));

        //id->xpath -> //*[@id='value']
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //className-> //*[@class='value']
        //driver.findElement(By.className("header"));
        driver.findElement(By.xpath("//div[@class='header']"));
        //contains-> //*[@contains(.,'Text')] частичное совпадение
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));
        //equal-> //*[text()='Text')] точное совпадение, оба варианта
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
        //starts-with-> //*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));
        //move up / вверх
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));
        // parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        //ancestor предок
        driver.findElement(By.xpath("//h1/ancestor::*")); //all
        driver.findElement(By.xpath("//h1/ancestor::div")); //two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]")); //one option
        //child потомок текущего узла
        driver.findElement(By.xpath("//h1/following-sibling::form"));
    }


}
