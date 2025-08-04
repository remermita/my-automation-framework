package com.trustarc;

import com.trustarc.automation.base.BaseTest;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.util.Arrays.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DeleteProducts extends BaseTest {

    WebDriverWait wait;
    WebDriverWait driver;

    static class Player {
        String name;
        String school;

        public Player(String name, String school) {
            this.name = name;
            this.school = school;
        }

        @Override
        public String toString() {
            return name + " (" + school + ")";
        }
    }

    public void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://admin.shopify.com/store/campus-ink-nil-2");
            driver.findElement(By.id("account_email")).sendKeys("admin@campus.ink");
            driver.findElement(By.name("commit")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("account_password")).sendKeys("CampusInkDTC2025$");
            driver.findElement(By.name("commit")).click();

            System.out.println("Waiting for 2FA!");

            new WebDriverWait(driver, Duration.ofMinutes(2)).until(ExpectedConditions.urlContains("admin"));
            driver.findElement(By.xpath("//*[@id='body-content']/div[2]/div/div[2]/div/div/div/div[3]/div/div[3]/a[1]")).click();

            System.out.println("Logged in successfully!");

            List<Player> players = asList(
                    new Player("Talon Gamez", "Marquette"),
                    new Player("Maciah Turner", "Marquette"),
                    new Player("Andreas Christou", "Marquette"),
                    new Player("Patrick Crantz", "Marquette"),
                    new Player("Donovan Jones", "Marquette"),
                    new Player("Timothy Smith", "Marquette"),
                    new Player("Caroline Cline", "Marquette"),
                    new Player("Kate Gibson", "Marquette"),
                    new Player("Mia Haertle", "Marquette"),
                    new Player("Marina HIll", "Marquette"),
                    new Player("Josie Kelderman", "Marquette"),
                    new Player("Aeryn Kennedy", "Marquette"),
                    new Player("Katie Koker", "Marquette"),
                    new Player("Madelyn Louks", "Marquette"),
                    new Player("Alexa Maletis", "Marquette"),
                    new Player("Carina Murphy", "Marquette"),
                    new Player("Julia O'Niell", "Marquette"),
                    new Player("Capri Oliviero", "Marquette"),
                    new Player("Chloe Olson", "Marquette"),
                    new Player("Taylor Schad", "Marquette"),
                    new Player("Maggie Starker", "Marquette"),
                    new Player("Braeden Carlsen", "Mercer"),
                    new Player("Anthony Grant", "Mercer"),
                    new Player("Jah Quinones", "Mercer"),
                    new Player("Brady Shoulders", "Mercer"),
                    new Player("Jacob Ferris", "Mercer"),
                    new Player("Whitt Newbauer", "Mercer"),
                    new Player("Sophia Henry", "Mercer"),
                    new Player("Destiny Nelson", "Mercer"),
                    new Player("Gavin Sitarz", "MSU"),
                    new Player("Brady Chambers", "MSU"),
                    new Player("Anthony Jones", "MSU"),
                    new Player("Jaelen Smith", "MSU"),
                    new Player("Ken Talley", "MSU"),
                    new Player("Aziah Johnson", "MSU"),
                    new Player("Brian Lewerke", "MSU"),
                    new Player("Charles Careidinw", "MSU"),
                    new Player("Dillon Tatum", "MSU"),
                    new Player("Shawn Smith", "MSU"),
                    new Player("Joseph Martinez", "MSU"),
                    new Player("Philipp Davis", "MSU"),
                    new Player("DJ Kennard", "MSU"),
                    new Player("James Schott", "MSU"),
                    new Player("Brandon Lewis", "MSU"),
                    new Player("Caleb Coley", "MSU"),
                    new Player("Carter Enyard", "MSU"),
                    new Player("AJ Dennis", "MSU"),
                    new Player("Mason Nickel", "MSU"),
                    new Player("Kyler Brunan", "MSU"),
                    new Player("Jake Merritt", "MSU"),
                    new Player("Jackson Carson-Wentz", "MSU"),
                    new Player("Jaylan Brown", "MSU"),
                    new Player("Dyson Sims", "MSU"),
                    new Player("Austin Clay", "MSU"),
                    new Player("Skylar Santucci", "MSU"),
                    new Player("Madie Lasinski", "MSU"),
                    new Player("Ella Kubas", "MSU"),
                    new Player("Reagan Korte", "MSU"),
                    new Player("Emily Matthews", "MSU"),
                    new Player("Jordyn Wickes", "MSU"),
                    new Player("Mackenzie Anthony", "MSU"),
                    new Player("Justina Gaynor", "MSU"),
                    new Player("Cassidy Corcione", "MSU"),
                    new Player("Ava Panduren", "MSU"),
                    new Player("Nalani Losia", "MSU"),
                    new Player("Akasha Anderson", "MSU"),
                    new Player("Selin Aslayan", "MSU"),
                    new Player("Kayla Foley", "MSU"),
                    new Player("Avery Horejsi", "MSU"),
                    new Player("Aliyah Moore", "MSU"),
                    new Player("Grace Kelly", "MSU"),
                    new Player("Jayhlin Swain", "MSU"),
                    new Player("Amani McArthur", "MSU"),
                    new Player("Kaya Hood", "MSU"),
                    new Player("Julia Bishop", "MSU")
            );

            for (Player player: players) {
                try {
                    String name = player.name;
                    String school = player.school;
                    System.out.println("Searching" + name + school);

                    driver.get("https://admin.shopify.com/store/campus-ink-nil-2");

                    driver.findElement(By.xpath("//span[contains(@class, 'Polaris-Text--root') and contains(text(), 'Products')]"));
//                    driver.findElement(By.xpath("//button[contains(@type, 'button') and contains(@aria-label, 'Search and filter products')]"));

                    WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@type, 'button') and contains(@aria-label, 'Search and filter products')]")));
                    searchBox.clear();
                    searchBox.sendKeys(player.name);
                    searchBox.sendKeys(Keys.ENTER);

                    Thread.sleep(3000);

                    List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@role='columnheader']//input[@type='checkbox']"));
                    if (checkboxes.isEmpty()) {
                        System.out.println("No products for" + player);
                        continue;
                    }
                    checkboxes.get(0).click();

                    WebElement moreActions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Actions']")));
                    moreActions.click();

                    WebElement deleteOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[text()='Delete products']]")));
                    deleteOption.click();

                    WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'Polaris-Text') and contains(text(), 'Delete')]")));
                    confirmDelete.click();

                    System.out.println("Deleted" + player);
                    Thread.sleep(2000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}