package stepdefinition.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pageobject.api.GETApi;
import utils.ConfigReader;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class GETApiSteps {

    Response response;
    GETApi getApi = new GETApi();

    @Given("User sends a GET request to {string}")
    public void send_get_request(String endpoint) {
        endpoint = ConfigReader.get("endpointURL");
        response = getApi.getUsers(endpoint);
    }

    @Then("Response status code should be {int}")
    public void get_status_code(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("Response should return all users")
    public void return_all_users() {
        response.then().body("data", not(empty()));
    }
}
