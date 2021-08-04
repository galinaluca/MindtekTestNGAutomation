package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlazeDemoHomePage {
    // @FindBy
    public BlazeDemoHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);// this means this class
    }
    // webElement type of attribute
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement findFlightsButton;
    // public WebElement getFindFlightsButton=driver.findElement(By xpath"//input[@class='btn btn-primary']")

    @FindBy(name="fromPort")
    public WebElement fromCityDropdown;

    @FindBy(name="toPort")
    public WebElement toCityDropdown;
}
