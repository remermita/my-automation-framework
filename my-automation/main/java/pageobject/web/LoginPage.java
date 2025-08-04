package pageobject.web;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.BasePage;

public class LoginPage extends BasePage {

    private final By typeUsername = By.id("username");
    private final By typePassword = By.id("password");
    private final By submitBtn = By.id("submit");
    private final By title = By.id("title-page");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        enterText(typeUsername, username);
    }

    public void enterPassword(String password) {
        enterText(typePassword, password);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    public void successfulLogin() {
        WebElement element = driver.findElement(By.xpath("//div/h1[@class='post-title']"));
        element.getText();
        Assert.assertTrue("Logged In Successfully", true);
    }
}
