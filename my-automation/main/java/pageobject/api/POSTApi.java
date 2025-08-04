package pageobject.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class POSTApi {

    private Response response;

    static {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public Response createUser() {
        String requestBody = """
            {
              "name": "John Doe",
              "email": "john@example.com",
              "password": "P@ssword123"
            }
        """;

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
        .when()
                .post("/posts")
        .then()
                .log().all()
                .extract()
                .response();
        return response;
    }

    public void invalidEmail() {
        String requestBody = """
            {
                "name": "John Doe",
                "email": "not-an-email",
                "password": "P@ssword123"
            }
        """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
        .when()
                .post("/api/users")
        .then()
                .log().all()
                .statusCode(422)
                .body("Error", containsString("Invalid email"));
    }

    public Response getResponse() {
        return response;
    }
}
