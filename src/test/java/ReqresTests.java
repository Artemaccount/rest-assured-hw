import io.restassured.response.Response;
import models.RequestUser;
import models.ResponseUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqresTests {

    @Test
    public void getUserSuccessTest() {
        int expectedId = 2;
        ResponseUser response = given()
                .baseUri("https://reqres.in/")
                .when()
                .log().everything()
                .get("api/users/" + expectedId)
                .then()
                .log().everything()
                .statusCode(200)
                .extract()
                .response().body()
                .jsonPath().getObject("data", ResponseUser.class);

        Assertions.assertNotNull(response.getFirstName(), "actual name is null");
        Assertions.assertEquals(expectedId, response.getId(), "id is not " + expectedId);

    }

    @Test
    public void createUserSuccessTest() {
        RequestUser user = new RequestUser("Ivan", "QA Automation");

        Response response = given()
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
        Integer actualId = response.jsonPath().getInt("id");
        String createdAt = response.jsonPath().getString("createdAt");

        Assertions.assertNotNull(actualId, actualId + " is null");
        Assertions.assertNotNull(createdAt, createdAt + " is null");

    }
}
