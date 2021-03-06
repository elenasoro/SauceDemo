package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class InventoryPage extends BasePage{

    private By ITEM_TITLE = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[1]/a");
    private By ITEM_PRICE = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div");
    private By ADD_ITEM_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private By CART_BUTTON = By.className("shopping_cart_link");
    private By LINKEDIN_BUTTON = By.linkText("LinkedIn");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(CART_BUTTON).isDisplayed();
    }

    public String getItemText() {
        return driver.findElement(ITEM_TITLE).getText();
    }

    public String getItemPrice() {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public InventoryPage addItemToCart() {
        driver.findElement(ADD_ITEM_BUTTON).click();
        return this;
    }

    public InventoryPage goToCart() {
        driver.findElement(CART_BUTTON).click();
        return this;
    }

    public InventoryPage goToLinkedin() {
        driver.findElement(LINKEDIN_BUTTON).click();
        return this;
    }

    public InventoryPage switchToNewTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return this;
    }

}
