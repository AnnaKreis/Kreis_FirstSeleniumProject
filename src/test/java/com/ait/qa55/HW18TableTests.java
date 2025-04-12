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

public class HW18TableTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table_align.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementTableWithCssTest() {
        //print number of row
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement el : rows) {
            System.out.println(el.getText());
            System.out.println("============================================");
            //get row 2
            WebElement row2 = driver.findElement(By.cssSelector("tr:nth-child(2)")); //xpath -> //tr[2]
            System.out.println(row2.getText());
            //get second item in row
            WebElement item1 = driver.findElement(By.cssSelector("tr:nth-child(3) td:nth-child(2)"));
            System.out.println(item1.getText());
            //get first item in row
            WebElement item2 = driver.findElement(By.cssSelector("tr:nth-child(1) th:nth-child(1)"));
            System.out.println(item2.getText());
            //get last and first element
            WebElement peter = driver.findElement(By.cssSelector("tr:nth-child(2) td:last-child"));
            System.out.println(peter.getText());
            WebElement lois = driver.findElement(By.cssSelector("tr:nth-child(2) td:first-child"));
            System.out.println(lois.getText());

        }
    }


}
