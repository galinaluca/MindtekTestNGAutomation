package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

   protected WebDriver driver;//default
                     //protected->is accessible
    @BeforeMethod(groups={"regression","smoke"})
    public void setUp(){
        driver=Driver.getDriver();
    }
    @AfterMethod(groups={"regression","smoke"})
    public void rearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
