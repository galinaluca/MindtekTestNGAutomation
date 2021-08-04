package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AssignmentsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();

    }

    @Test
    public void test1() {
        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        Select select = new Select(dropdown);
        select.selectByValue("San Diego");
        driver.findElement(By.name("toPort")).sendKeys("New York");
        // WebElement dropdown1=driver.findElement(By.name("toPort"));
        // select.selectByValue("New York");

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        // driver.findElement(By.xpath("//input[@value='Choose This Flight']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//input[@value='Choose This Flight']"));

        for (int i = 0; i < list.size(); i++) {
            String expectedResult = list.get(i).getText();
            System.out.println(expectedResult);
            // String expectedPrice=driver.findElement(By.xpath("//td[contains(text(),'$765.32')]")).getText();
            //String expected=driver.findElement(By.xpath("//input[@value='765.32']")).getText();
            //String actualResult="Total Cost: 914.76";
            // Assert.assertEquals(actualResult,expectedResult);
        }

        }
        @AfterMethod
        public void tearDown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }
