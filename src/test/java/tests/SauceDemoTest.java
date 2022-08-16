package tests;

import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LinkedinPage;
import pages.LoginFormPage;
import testdata.PrepareLoginData;
import utils.RetryAnalyzer;


public class SauceDemoTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SauceDemoTest.class.getName());


    @Test(groups = {"smoke-contacts"}, priority = 2,invocationCount = 2, threadPoolSize = 2, retryAnalyzer = RetryAnalyzer.class)
    public void switchTabsTest() {
        LoginFormPage loginFormPage = new LoginFormPage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initiated", LoginFormPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getStandardUserCredentials();
        loginFormPage
                .openLoginFormPage()
                .inputUserName(loginModel.getLogin())
                .inputPassword(loginModel.getPassword())
                .clickLoginButton()
                .removeTimeout();
        LOGGER.info(String.format("Open %s page", LoginFormPage.class.getName()));
        LOGGER.info("Input UserName");
        LOGGER.info("Input Password");
//        InventoryPage inventoryPage = new InventoryPage(driverManager.getDriver());
//        inventoryPage.goToLinkedin().switchToNewTab();
        LinkedinPage linkedinPage = new LinkedinPage(driverManager.getDriver());
        linkedinPage.waitForLogo();
        Assert.assertTrue(linkedinPage.isLogoDisplayed(), "Linkedin Logo not displayed");
    }


    @Test(groups = {"smoke-cart"}, priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void addItemToCartTest() {

        LoginFormPage loginFormPage = new LoginFormPage(driverManager.getDriver());
        LoginModel loginModel = PrepareLoginData.getStandardUserCredentials();
        loginFormPage
                .openLoginFormPage()
                .inputUserName(loginModel.getLogin())
                .inputPassword(loginModel.getPassword())
                .clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driverManager.getDriver());
        Assert.assertTrue(inventoryPage.isPageOpened(), "Cart button isn't displayed");
        String itemTitle = inventoryPage.getItemText();
        String itemPrice = inventoryPage.getItemPrice();
        inventoryPage.addItemToCart().goToCart();

        CartPage cartPage = new CartPage(driverManager.getDriver());
        Assert.assertTrue(cartPage.isPageOpened(), "Checkout button isn't displayed");
        String itemInCartTitle = cartPage.getItemText();
        String itemInCartPrice = cartPage.getItemPrice();

        Assert.assertEquals(itemTitle, itemInCartTitle, "Title incorrect");
        Assert.assertEquals(itemPrice, itemInCartPrice, "Price incorrect");
    }

}
