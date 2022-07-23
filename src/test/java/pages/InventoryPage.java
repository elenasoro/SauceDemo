package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private By ITEM_TITLE = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[1]/a");
    private By ITEM_PRICE = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div");
    private By ADD_ITEM_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private By CART_BUTTON = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getItemText() {
        return driver.findElement(ITEM_TITLE).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public void addItemToCart() {
        driver.findElement(ADD_ITEM_BUTTON).click();
    }

    public void goToCart() {
        driver.findElement(CART_BUTTON).click();
    }
}
