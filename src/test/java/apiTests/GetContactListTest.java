package apiTests;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class GetContactListTest extends BaseTest {
    
    @Test
    public void testGetContactList() {
        Assert.assertNotNull(token, "Token is required for authentication");

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/contacts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        int count = response.jsonPath().getList("$").size();
        //System.out.println("Total contacts: " + count);
    }
}
