package pageobject.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETApi {
    private Response response;

    public Response getUsers(String endpoint) {
        response = RestAssured
                .given()
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
        return response;
    }
}
