package apiTests;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class LogoutUserTest extends BaseTest {
    
    @Test
    public void testLogoutUser() {
        Assert.assertNotNull(token, "Token is required for authentication");

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .post("/users/logout")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("User logged out successfully.");
    }
}
