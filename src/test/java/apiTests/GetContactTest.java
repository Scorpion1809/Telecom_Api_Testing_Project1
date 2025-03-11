package apiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class GetContactTest extends BaseTest {
    
    @Test
    public void testGetContact() {
        Assert.assertNotNull(token, "Token is required for authentication");
        String contactId = "REPLACE_WITH_CONTACT_ID";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/contacts/" + contactId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        //String firstName = response.jsonPath().getString("firstName");
        //Assert.assertNotNull(firstName, "First name should not be null");
    }
}
