package tests;

import drivermanager.DriverManager;
import models.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginFormPage;
import testdata.PrepareLoginData;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SauceDemoTestOnChrome extends BaseTestChrome {
    public DriverManager driverManager;

    @Test
    public void switchTabsTest() {
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        LoginModel loginModel = PrepareLoginData.getStandardUserCredentials();
        loginFormPage
                .openLoginFormPage()
                .inputUserName(loginModel.getLogin())
                .inputPassword(loginModel.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToLinkedin();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test-id=nav-logo]")));
        Assert.assertTrue(driver.findElement(By.cssSelector("[data-test-id=nav-logo]")).isDisplayed(), "Linkedin Logo not displayed");
    }

    @Test
    public void addItemToCartTest() {

        LoginFormPage loginFormPage = new LoginFormPage(driver);
        LoginModel loginModel = PrepareLoginData.getStandardUserCredentials();
        loginFormPage
                .openLoginFormPage()
                .inputUserName(loginModel.getLogin())
                .inputPassword(loginModel.getPassword())
                .clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isPageOpened(), "Cart button isn't displayed");
        String itemTitle = inventoryPage.getItemText();
        String itemPrice = inventoryPage.getItemPrice();
        inventoryPage.addItemToCart().goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isPageOpened(), "Checkout button isn't displayed");
        String itemInCartTitle = cartPage.getItemText();
        String itemInCartPrice = cartPage.getItemPrice();

        Assert.assertEquals(itemTitle, itemInCartTitle, "Title incorrect");
        Assert.assertEquals(itemPrice, itemInCartPrice, "Price incorrect");
    }

}
