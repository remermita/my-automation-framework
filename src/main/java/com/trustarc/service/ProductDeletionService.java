package com.trustarc.service;

import com.trustarc.model.Player;
import com.trustarc.pages.LoginPage;
import com.trustarc.pages.ProductPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductDeletionService {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    public ProductDeletionService(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.productPage = new ProductPage(driver);
    }

    public void deleteProductsForPlayers(List<Player> players) throws InterruptedException {
        loginPage.goToLoginPage();
        loginPage.enterEmail("admin@campus.ink");
        loginPage.enterPassword("CampusInkDTC2025$");

        System.out.println("Waiting for 2FA...");
        productPage.waitForAdminRedirect();

        productPage.goToProductsSection();
        System.out.println("Logged in successfully!");

        for (Player player : players) {
            try {
                productPage.deleteProductByName(player.name, player.school);
            } catch (Exception e) {
                System.out.println("Error processing " + player);
                e.printStackTrace();
            }
        }
    }
}
