package TestScenarios;

import TestFunctions.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


@RunWith(SerenityRunner.class)
public class InvalidCategoriesInCoupon {
    @Steps
    User user;

    @Managed(driver = "remote")
    WebDriver driver;

    @Test
    public void ShowAsGridViewAndListingProduct () throws IOException, ParseException {
        user.userLogin();
        user.showAccountMenu();
        user.ScrollPage();
        user.clickCouponBtn();
        user.seeCouponDetail();
        user.nullAndVoidCategories();
        user.noneDiscountProduct();
    }
}
