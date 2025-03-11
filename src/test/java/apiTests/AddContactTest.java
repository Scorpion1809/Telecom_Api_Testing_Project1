package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class AddContactTest extends BaseTest {

    @Test
    public void testAddContact() {
        // Get the token from BaseTest
        //String authToken = BaseTest.getToken();
        System.out.println("Test add contact Response Token = : " + token);
        Assert.assertNotNull(token, "Token is required for authentication");

        String requestBody = "{"
                + "\"firstName\": \"Jane\","
                + "\"lastName\": \"Smith\","
                + "\"phone\": \"1234567890\""
                + "}";

        Response response = given()
                .header("Authorization", "Bearer " + token) // Use stored token
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201) // Expected status code for successful creation
                .extract()
                .response();

        String contactId = response.jsonPath().getString("id");
        //Assert.assertNotNull(contactId, "Contact ID should not be null");
        //System.out.println("Contact added successfully: " + contactId);
    }
}
