package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginFormPage;

public class SauceDemoTest extends BaseTest {

    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @Test
    public void addItemToCartTest() {

        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.openLoginFormPage();
        loginFormPage.inputUserName(USER_NAME);
        loginFormPage.inputPassword(PASSWORD);
        loginFormPage.clickLoginButton();

        InventoryPage inventoryPage = new InventoryPage(driver);
        String itemTitle = inventoryPage.getItemText();
        String itemPrice = inventoryPage.getItemPrice();
        inventoryPage.addItemToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        String itemInCartTitle = cartPage.getItemText();
        String itemInCartPrice = cartPage.getItemPrice();

        Assert.assertEquals(itemTitle, itemInCartTitle, "Title incorrect");
        Assert.assertEquals(itemPrice, itemInCartPrice, "Price incorrect");
    }

}
