package steps;

import io.restassured.response.Response;
import models.RequestUser;
import models.ResponseUser;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    public static ResponseUser getUser(int id) {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .log().everything()
                .get("api/users/" + id)
                .then()
                .log().everything()
                .statusCode(200)
                .extract()
                .response().body()
                .jsonPath().getObject("data", ResponseUser.class);
    }

    public static Response createUser(RequestUser user) {
        return given()
                .baseUri("https://reqres.in/")
                .when()
                .log().everything()
                .body(user)
                .post("api/users")
                .then()
                .log().everything()
                .statusCode(201)
                .extract()
                .response();
    }
}
