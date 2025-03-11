package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class GetUserProfileTest extends BaseTest {

    @Test
    public void testGetUserProfile() {
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/users/me")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //String email = response.jsonPath().getString("email");
        //Assert.assertEquals(email, "john.doe@example.com", "Email should match");
    }
}
