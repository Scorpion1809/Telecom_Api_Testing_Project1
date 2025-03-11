package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class UpdateUserTest extends BaseTest {
    
    @Test
    public void testUpdateUser() {
        Assert.assertNotNull(token, "Token is required for authentication");

        String requestBody = "{" +
                "\"firstName\": \"JohnUpdated\"," +
                "\"lastName\": \"DoeUpdated\"}";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/users/me")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //String firstName = response.jsonPath().getString("firstName");
        //Assert.assertEquals(firstName, "JohnUpdated", "First name should be updated");
    }
}
