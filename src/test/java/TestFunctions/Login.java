package TestFunctions;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;


public class Login extends Account {

    private ReadAndWrite writeXLS =  new ReadAndWrite();

    String url = writeXLS.readJson().get("url").toString();

    private By LoginButton = By.id("loginButton");
    private By SignIn = By.className("btnSignIn");
    private By UserEmail = By.id("email");
    private By Sifre = By.name("password");

    public Login(WebDriver driver) throws IOException, ParseException {
        super(driver);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void SignInPage() throws IOException, ParseException {
        String mail=writeXLS.readJson().get("mail").toString();
        String password=writeXLS.readJson().get("password").toString();

        getDriver().findElement(SignIn).click();
        getDriver().findElement(UserEmail).sendKeys(mail);
        getDriver().findElement(Sifre).sendKeys(password);
        getDriver().findElement(LoginButton).click();
    }
}
