package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    private By ITEM_TITLE = By.className("inventory_item_name");
    private By ITEM_PRICE = By.className("inventory_item_price");
    private By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(CHECKOUT_BUTTON).isDisplayed();
    }

    public String getItemText() {
        return driver.findElement(ITEM_TITLE).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }
}
