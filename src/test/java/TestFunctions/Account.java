package TestFunctions;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Account extends PageObject {

    private By Kuponlarım = By.xpath("//a[@title='Kuponlarım']");
    private By Eleven = By.xpath("//*[@id=\"js-wrapperForPreventingActions\"]/section[2]/div/button[2]");
    private By Hesabım = By.linkText("Enes Baş");

    public Account(WebDriver driver) {
        super(driver);
    }

    public void showInside() {
        WebElement hesabım = getDriver().findElement(Hesabım);
        Actions action = new Actions(getDriver());
        action.moveToElement(hesabım).build().perform();
        waitABit(1000);
        getDriver().findElement(Kuponlarım).click();
    }

    public void couponBtn(){
        getDriver().switchTo().frame("reactCouponCenter");
        getDriver().findElement(Eleven).click();
        getDriver().switchTo().defaultContent();
        waitABit(1000);
    }
}


