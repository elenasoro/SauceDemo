package pages;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginFormPage extends BasePage{

    private By USERNAME_INPUT = By.id("user-name");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.cssSelector("[value='Login']");

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    public LoginFormPage openLoginFormPage() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
        return this;
    }

    public LoginFormPage inputUserName(String userName) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        return this;
    }

    public LoginFormPage inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public LoginFormPage clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
