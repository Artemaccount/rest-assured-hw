import io.restassured.response.Response;
import models.RequestUser;
import models.ResponseUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import steps.ReqresSteps;

public class ReqresTests {

    @Test
    public void getUserSuccessTest() {
        int expectedId = 2;
        ResponseUser response = ReqresSteps.getUser(expectedId);
        Assertions.assertNotNull(response.getFirstName(), "actual name is null");
        Assertions.assertEquals(expectedId, response.getId(), "id is not " + expectedId);
    }

    @Test
    public void createUserSuccessTest() {
        RequestUser user = new RequestUser("Ivan", "QA Automation");
        Response response = ReqresSteps.createUser(user);

        Integer actualId = response.jsonPath().getInt("id");
        String createdAt = response.jsonPath().getString("createdAt");

        Assertions.assertNotNull(actualId, actualId + " is null");
        Assertions.assertNotNull(createdAt, createdAt + " is null");
    }
}
