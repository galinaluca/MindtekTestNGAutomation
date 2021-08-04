package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class StoreTests extends TestBase {

    @Test(groups = {"regression","smoke"})
    public void test1(){
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage=new StoreAppContactUsPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select=new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys("123@gmail.com");
        String projectPath=System.getProperty("user.dir");
        System.out.println("Path is: "+projectPath);
        storeAppContactUsPage.fileUpload.sendKeys(projectPath+"/src/test/resources/testdata/mypicture.jpg");

        storeAppContactUsPage.message.sendKeys("Hello World");
        storeAppContactUsPage.submitButton.click();

        String actualSuccessMessage=storeAppContactUsPage.successMessage.getText();
        String expectedSuccessMessage="Your message has been successfully sent to our team.";
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);





    }
    @Test(groups = {"regression","smoke"})
    public void test2(){
        StoreAppHomePage storeAppHomePage=new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage=new StoreAppContactUsPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select=new Select(storeAppContactUsPage.subjectHeadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys("123@gmail.com");
        String projectPath=System.getProperty("user.dir");
        System.out.println("Path is: "+projectPath);

        storeAppContactUsPage.fileUpload.sendKeys(projectPath+"/src/test/resources/testdata/mypicture.jpg");
        storeAppContactUsPage.submitButton.click();

        String actualErrorMessage=storeAppContactUsPage.errorMessage.getText();
        String expectedErrorMessage="The message cannot be blank.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }


    }


