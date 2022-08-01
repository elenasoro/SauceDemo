package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LinkedinPage extends BasePage{

    private By LINKEDIN_LOGO = By.cssSelector("[data-test-id=nav-logo]");

    public LinkedinPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(LINKEDIN_LOGO).isDisplayed();
    }

    public LinkedinPage waitForLogo() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LINKEDIN_LOGO));
        Assert.assertTrue(driver.findElement(LINKEDIN_LOGO).isDisplayed(), "Linkedin Logo not displayed");
        return this;
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(LINKEDIN_LOGO).isDisplayed();
    }

}
