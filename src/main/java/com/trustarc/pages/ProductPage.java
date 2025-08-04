package com.trustarc.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForAdminRedirect() {
        new WebDriverWait(driver, Duration.ofMinutes(1))
                .until(ExpectedConditions.urlContains("admin"));
    }

    public void clickSearchBox(String playerName) {
        WebElement searchBox = driver.findElement(By.xpath("//button[@aria-label='Search and filter products']"));
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Searching all products']"));
        searchBox.click();
        searchField.click();
        searchField.sendKeys(playerName);
        searchField.sendKeys(Keys.ENTER);
    }

    public void goToProductsSection() {
        driver.findElement(By.xpath(
                "//span[text()='Products']/ancestor::*[self::a or self::button or self::div][1]"
        )).click();
    }

    public void deleteProductByName(String name, String school) throws InterruptedException {
        List<WebElement> productRows = Collections.singletonList(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Polaris-Table']"))));

        boolean productFound = false;

        for (WebElement row: productRows) {
            String rowText = row.getText().toLowerCase();

            if (rowText.contains(name.toLowerCase()) && rowText.contains(school.toLowerCase())) {
                WebElement checkbox = row.findElement(By.xpath("//div[@class='Polaris-Table-TableRow__CheckboxHitState']"));
                checkbox.click();
                productFound = true;
                System.out.println("Products to be deleted: " + name + school);
            }

            if (!productFound) {
                System.out.println("No matching product found:" + name + school);
                return;
            }
        }

        WebElement moreActions = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@aria-label='Actions']")));
        moreActions.click();

        WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[.//span[text()='Delete products']]")));
        deleteOption.click();

        WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(), 'Delete')]")));
        confirmDelete.click();

        System.out.println("Deleted: " + name);
        Thread.sleep(2000);
    }
}
