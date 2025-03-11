package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class UpdateFullContactTest extends BaseTest {
    
    @Test
    public void testUpdateFullContact() {
        Assert.assertNotNull(token, "Token is required for authentication");
        String contactId = "REPLACE_WITH_CONTACT_ID";

        String requestBody = "{" +
                "\"firstName\": \"UpdatedFirst\"," +
                "\"lastName\": \"UpdatedLast\"," +
                "\"email\": \"updated.email@example.com\"}";

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/contacts/" + contactId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        //String updatedFirstName = response.jsonPath().getString("firstName");
        //Assert.assertEquals(updatedFirstName, "UpdatedFirst", "First name should be updated");
    }
}
