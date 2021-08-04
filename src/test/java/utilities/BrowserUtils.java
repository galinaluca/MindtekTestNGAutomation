package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {
    // method that will accept dropdown web Element and the value of that element
    // and will select that value which is provided in parameters.
    //.selectBy Value(dropdownElement,"1";->void

    public static void selectByValue(WebElement element,String value){
        Select select= new Select(element);
        select.selectByValue(value);

    }
}
