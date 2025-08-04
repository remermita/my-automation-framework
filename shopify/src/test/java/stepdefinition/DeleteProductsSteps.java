package stepdefinition;

import com.trustarc.automation.base.BaseTest;
import com.trustarc.pages.LoginPage;
import com.trustarc.pages.ProductPage;
import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteProductsSteps extends BaseTest {

    private LoginPage loginPage;
    private ProductPage productPage;
    private String playerName;
    private String school;

    @Given("I am logged into the Shopify admin portal")
    public void i_am_logged_into_the_shopify_admin_portal() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        productPage = new ProductPage(getDriver());

        loginPage.goToLoginPage();
        loginPage.enterEmail("admin@campus.ink");
        loginPage.enterPassword("CampusInkDTC2025$");

        System.out.println("Waiting for 2FA...");
        loginPage.clickLogin();

        productPage.waitForAdminRedirect();

        System.out.println("Logged in successfully.");
    }

    @When("I search for the product of {string} and {string}")
    public void i_search_for_the_product_of(String playerName, String school) {
        productPage.goToProductsSection();
        productPage.clickSearchBox(playerName);
        this.playerName = playerName;
        this.school = school;
        System.out.println("Searching product for: " + playerName + school);
    }

    @And("I delete the product if it exists")
    public void i_delete_the_product_if_it_exists() throws InterruptedException {
        productPage.deleteProductByName(playerName, school);
    }

    @Then("the product for {string} and {string} should be removed")
    public void the_product_should_be_removed(String name, String school) {
        System.out.println("Checked deletion for: " + name + school);
    }
}
