package TestFunctions;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll extends PageObject {

    public void crossSection(){

        ((JavascriptExecutor)getDriver()).executeScript("scroll(0,180)");
        waitABit(1000);

    }
}
