package stepdefinition.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.web.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;
import io.cucumber.java.en.Given;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is on Login Page")
    public void user_opens_chrome_browser() {
        driver.get(ConfigReader.get("url"));
    }

    @When("User inputs {string} and {string}")
    public void user_input_email_password(String email, String password) {
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
    }

    @And("User clicks submit button")
    public void user_clicks_submit_btn() {
        loginPage.clickSubmit();
    }

    @Then("User logs in successfully")
    public void user_logs_in_successfully() {
        loginPage.getTitle();
        loginPage.successfulLogin();
    }

    @And("User closes the browser")
    public void user_closes_browser() {
        loginPage.closeBrowser();
    }
}
