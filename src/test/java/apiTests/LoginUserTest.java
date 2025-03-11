package apiTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import utils.BaseTest;

public class LoginUserTest extends BaseTest {

    @BeforeClass
    public void setUp() {
        super.setup();
    }

    @Test
    public void testLoginUser() {
        String requestBody = "{"
                + "\"email\": \"test6.mvn@example.com\","
                + "\"password\": \"Test@123\"}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users/login")
                .then()
                .extract()
                .response();

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Login failed!");

        // Extract token and store it in BaseTest
        token = response.jsonPath().getString("token");
        System.out.println("Response Token = : " + token);
        BaseTest.setToken(token);

        //Assert.assertNotNull(token, "Token should not be null");
        //System.out.println("User logged in successfully. Token: " + token);
    }
}
