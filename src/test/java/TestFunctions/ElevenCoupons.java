package TestFunctions;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevenCoupons extends PageObject {

    private By GridView = By.id("sortingType");
    private List<String> ProductList = new ArrayList<String>();
    private By CouponListSection = By.className("couponListSection");
    private By CouponContent = By.className("couponContent");
    private By Hyperlink = By.className("btn");
    private By VoucherDetail = By.xpath("//body//div[@id='newVoucherDetailModal']");
    private By Frame = By.className("modalCouponList__unorderedList");
    private By FrameClick = By.tagName("a");
    private By Pagination = By.className("pagination");
    private By Products = By.xpath("//*[@id='view']/ul");
    private By Product = By.xpath("//*[@class='column']");
    private By Sale = By.className("ratio");

    public ElevenCoupons(WebDriver driver) {
        super(driver);
    }

    public int getRandomIndex(int value){
        Random r = new Random();
        return r.nextInt(value);
    }

    public void couponDetail() {
        getDriver().switchTo().frame("reactCouponCenter");
        List<WebElement> coupons = getDriver().findElement(CouponListSection).findElements(CouponContent);
        coupons.get(getRandomIndex(coupons.size())).findElement(Hyperlink).click();
    }

    public void frameClick(){
        getDriver().switchTo().defaultContent();
        List<WebElement> nullAndVoidCategories = getDriver().findElement(VoucherDetail).findElements(Frame);
        nullAndVoidCategories.get(getRandomIndex(nullAndVoidCategories.size())).findElement(FrameClick).click();
    }

    public void filter(String visibleText){
        getDriver().switchTo().window(getDriver().getWindowHandles().toArray()[1].toString());
        Select select = new Select(getDriver().findElement(GridView));
        select.selectByVisibleText(visibleText);
    }

    public boolean retryingFindClick(WebElement element) {
        boolean result = false;
        int count = 0;
        while(count < 5) {
            try {
                element.click();
                result = true;
                break;
            } catch(StaleElementReferenceException | ElementClickInterceptedException e) {

            }
            count++;
        }
        return result;
    }

    public void getNoneDiscountProduct() throws IOException {
        for (int i=1; i<6; i++) {
            WebDriverWait wait = new WebDriverWait(getDriver(),20);
            WebElement pagination = getDriver().findElement(Pagination);
            wait.until(ExpectedConditions.elementToBeClickable(pagination.findElement(By.xpath("//a[.='"+i+"']"))));
            retryingFindClick(pagination.findElement(By.xpath("//a[.='"+i+"']")));
            wait.until(ExpectedConditions.presenceOfElementLocated(Products));
            List<WebElement> lst = getDriver().findElement(Products).
                    findElements(Product);
            for (WebElement list : lst) {
                try {
                    Assert.assertTrue(list.findElement(Sale).isDisplayed());
                    System.out.println(list.getText() + " İndirmli Ürün\n");
                } catch (Exception e) {
                    ProductList.add(list.getText().replace("\n", " "));
                }
            }
        }
        ReadAndWrite writeXLS = new ReadAndWrite();
        writeXLS.writeFile(ProductList);
    }

}
