package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AddUserTest extends BaseTest {
    
    @Test
    public void testAddUser() {
        String requestBody = "{" +
                "\"firstName\": \"John\"," +
                "\"lastName\": \"Doe\"," +
                "\"email\": \"test6.mvn@example.com\"," +
                "\"password\": \"Test@123\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        String userId = response.jsonPath().getString("id");
        //Assert.assertNotNull(userId, "User ID should not be null");
    }
}
