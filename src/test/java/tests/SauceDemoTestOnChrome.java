package tests;

import models.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginFormPage;
import testdata.PrepareLoginData;

public class SauceDemoTestOnChrome extends BaseTest {

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
