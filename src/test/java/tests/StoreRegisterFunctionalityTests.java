package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {
    //Data Driven Testing
    @DataProvider(name="signUpDataProvider")
    public  static Object[][] testData(){
        Object[][] data=new Object[][]{
                {"John","Doe","123345",DataUtils.generateRandomNumber(30)+"","1","2021","345 Long Str","Chicago", "13","12345","21","123456789"},//set1
                {"Kim","Ly","abcdf1","1","12","1980","34 Lincoln Ave","New York","32","76543","21","9888777"},//set2
                {"Patel","Harsh","abcdf1","1","12","1980","34 My Road Ave","New York","32","76543","21","9866677"},//set3

        };
        return data;
    }
    @Test(dataProvider = "signUpDataProvider",groups = {"regression","smokeS"})
    public void test1(String firstName,String lastName,String password, String day, String month,String year,
                      String address, String city, String state,String zipCode, String country, String phoneNumber) {
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();


        storeAppLoginPage.emailBox.sendKeys(DataUtils.generateEmail());
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.FirstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.LastNameBox.sendKeys(lastName);
        storeAppCreateAccountPage.PasswordBox.sendKeys(password);

        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);
        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox, state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox, country);
        storeAppCreateAccountPage.phonemobileBox.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title " + actualTitle + " did not match");

    }

 }

