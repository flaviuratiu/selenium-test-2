package org.fasttrackit.search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SimpleSearchTest {

    @Test
    public void simpleSearchWithOneKeyword() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        String keyword = "vase";
        driver.findElement(By.id("search")).sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed Enter in search field.");

        List<WebElement> productNames = driver.findElements(By.cssSelector(".product-name a"));

        System.out.println("Stored " + productNames.size() + " product names from search results.");

        for (WebElement productName : productNames) {
            assertThat("Some of the product names do not contain the searched keyword.",
                    productName.getText(), containsString(keyword.toUpperCase())
            );
        }
    }

    @Test
    public void specialPriceDisplayedAfterSimpleSearch() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://fasttrackit.org/selenium-test/");

        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        String oldPrice = driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();
        String specialPrice = driver.findElement(By.xpath("//p[@class='special-price']//span[@class='price']")).getText();

        String oldPriceValue = oldPrice.split(" ")[0]
                .replace(",", ".");

        String specialPriceValue = specialPrice.split(" ")[0]
                .replace(",", ".");

//        assertThat("Old price greater than special price",
//                Double.parseDouble(oldPriceValue),
//                is(lowerThan(Double.parseDouble(specialPriceValue)))
//                );

    }

}
