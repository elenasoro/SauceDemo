package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SauceDemoElements {
    WebDriver driver;
    WebElement logoElement = driver.findElement(By.className("login_logo"));
    WebElement formElement = driver.findElement(By.tagName("form"));
    WebElement link = driver.findElement(By.linkText("Sauce Labs Backpack"));
    WebElement partialLink = driver.findElement(By.partialLinkText("Bike Light"));
    WebElement button = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
    WebElement usernames = driver.findElement(By.xpath("//h4[text()='Accepted usernames are:']"));
    WebElement img = driver.findElement(By.xpath("//img[contains(@class,'inventory')]"));
    WebElement passwordsTitle = driver.findElement(By.xpath("//h4[contains(text(),'Password')]"));
    WebElement byAncestorEl = driver.findElement(By.xpath("//div[contains(text(),'Backpack')]/ancestor::div"));
    WebElement byParentEl = driver.findElement(By.xpath("//div[contains(@class,'inventory_item_img')]/parent::div"));
    WebElement userNameByXpath = driver.findElement(By.xpath("//input[contains(@class, 'input_error') and @type='text']"));
    WebElement userNameByCss = driver.findElement(By.cssSelector(".input_error"));
    WebElement loginButtonByCss = driver.findElement(By.cssSelector("#login-button"));
    WebElement formElementByCss = driver.findElement(By.cssSelector("form"));
    WebElement loginButtonByCssClassStart = driver.findElement(By.cssSelector("[class^=submit]"));
    WebElement loginButtonByCssClassEnd = driver.findElement(By.cssSelector("[class$=action]"));
    WebElement loginButtonByCssClassContains = driver.findElement(By.cssSelector("[class*=btn]"));
    WebElement firstInventoryItem = driver.findElement(By.cssSelector(".inventory_list:first-child"));
    WebElement secondInventoryItem = driver.findElement(By.cssSelector(".inventory_list:nth-child(2)"));

}
