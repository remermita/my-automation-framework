package stepdefinition.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pageobject.api.POSTApi;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class POSTApiSteps {
    Response response;
    POSTApi postApi = new POSTApi();

    @Given("User successfully POST a new user")
    public void adds_new_customer() {
        response = postApi.createUser();
    }

    @Then("User verifies customer Id")
    public void verify_customer_id() {
        response.then().body("id", notNullValue());
    }

}
