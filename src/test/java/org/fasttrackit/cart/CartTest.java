package org.fasttrackit.cart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {

    @Test
    public void addProductToCart() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        // xpath concatenated here just to be displayed on two rows and be visible all at once
        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()" +
                "='Herald Glass Vase']]//button[contains(@class, 'btn-cart')]")).click();
    }

}
