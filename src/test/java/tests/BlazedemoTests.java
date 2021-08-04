package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazeDemoHomePage;
import pages.BlazedemoFlightPage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTests extends TestBase {


    @Test(groups={"regression"})
    public void test1(){
        BlazeDemoHomePage blazeDemoHomePage=new BlazeDemoHomePage();
        BlazedemoFlightPage blazedemoFlightPage=new BlazedemoFlightPage();

        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        blazeDemoHomePage.findFlightsButton.click();
        //validate all prices in table are below $1000
        List<WebElement> prices=blazedemoFlightPage.prices;
        for (WebElement element:prices){
            String priceStr=element.getText();
            // $472.56==String== Integer.parseInt(String);
            priceStr=priceStr.substring(1);
            double priceDouble=Double.parseDouble(priceStr);
            Assert.assertTrue(priceDouble<1000);

        }
    }
    @Test(groups = {"regression"})
    public void test2(){
        BlazeDemoHomePage blazeDemoHomePage=new BlazeDemoHomePage();
        BlazedemoFlightPage blazedemoFlightPage=new BlazedemoFlightPage();

        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        Select select=new Select(blazeDemoHomePage.fromCityDropdown);
        select.selectByVisibleText("Boston");
        select=new Select(blazeDemoHomePage.toCityDropdown);
        select.selectByVisibleText("London");
        blazeDemoHomePage.findFlightsButton.click();
       String actualText=blazedemoFlightPage.headerText.getText();
       String expectedText="Flights from Boston to London:";
       Assert.assertEquals(actualText,expectedText);


    }


}
