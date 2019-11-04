package TestFunctions;

import net.thucydides.core.annotations.Step;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class User {
    Scroll scroll;
    Account account;
    Login login;
    ElevenCoupons elevenCoupons;

    @Step
    public void userLogin () throws IOException, ParseException {
       login.SignInPage();
    }
    @Step
    public void showAccountMenu(){
        account.showInside();
    }
    @Step
    public void clickCouponBtn() {
        account.couponBtn();
    }
    @Step
    public void ScrollPage() {
        scroll.crossSection();
    }
    @Step
    public void seeCouponDetail() {
        elevenCoupons.couponDetail();
    }
    @Step
    public void nullAndVoidCategories() {
        elevenCoupons.frameClick();
        elevenCoupons.filter("Mağaza Puanı");
    }
    @Step
    public void noneDiscountProduct() throws IOException {
        elevenCoupons.getNoneDiscountProduct();
    }

}
