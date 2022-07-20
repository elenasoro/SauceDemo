package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import constants.Urls;

public class SourceDemoTest extends BaseTest {

    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @Test
    public void normalTest() {

        driver.get(Urls.SAUCEDEMO_URL);

        //login
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys(USER_NAME);
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        //get 1st item title
        String itemTitle = driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[1]/a")).getText();
        //get 1st item price
        String itemPrice = driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText();
        //add item to the cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //go to cart
        driver.findElement(By.className("shopping_cart_link")).click();
        //get title of inventory item in the cart
        String itemInCartTitle = driver.findElement(By.className("inventory_item_name")).getText();
        //get price of inventory item in the cart
        String itemInCartPrice = driver.findElement(By.className("inventory_item_price")).getText();

        // Check titles and prices equal
        Assert.assertEquals(itemTitle, itemInCartTitle, "Title incorrect");
        Assert.assertEquals(itemPrice, itemInCartPrice, "Price incorrect");
    }

}
