package com.trustarc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("https://admin.shopify.com/store/campus-ink-nil-2");
    }

    public void enterEmail(String email) throws InterruptedException {
        driver.findElement(By.id("account_email")).sendKeys(email);
        Thread.sleep(4000);
        driver.findElement(By.name("commit")).click();
    }

    public void enterPassword(String password) throws InterruptedException {
        Thread.sleep(2000); // wait for password input to appear
        driver.findElement(By.id("account_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
        System.out.println("Waiting for 2FA!");
    }

    public void clickLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'captcha__submit') and contains(., 'Log in')]")));
        driver.findElement(By.xpath("//button[contains(@class, 'captcha__submit') and contains(., 'Log in')]")).click();

        System.out.println("Logged in successfully!");
    }
}

