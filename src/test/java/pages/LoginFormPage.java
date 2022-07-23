package pages;

import constants.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    private By USERNAME_INPUT = By.id("user-name");
    private By PASSWORD_INPUT = By.id("password");
    private By LOGIN_BUTTON = By.cssSelector("[value='Login']");

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginFormPage() {
        driver.get(Urls.SAUCEDEMO_LOGIN_URL);
    }

    public void inputUserName(String userName) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
    }

    public void inputPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
