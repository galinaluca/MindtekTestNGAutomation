package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {
    @Test(groups = {"regression","smoke"})
    @Parameters({"username","password"})
    public void loginTest(String username, String password){
        SauceDemoLoginPage sauceDemoLoginPage=new SauceDemoLoginPage();
        SauceDemoHomePage sauceDemoHomePage= new SauceDemoHomePage();
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauceDemoLoginPage.username.sendKeys(username);
        sauceDemoLoginPage.password.sendKeys(password);
        sauceDemoLoginPage.loginButton.click();
        String actPageTitle=sauceDemoHomePage.pageTitle.getText();
        String expPageTitle="PRODUCTS";
        Assert.assertEquals(actPageTitle,expPageTitle);
    }
}
