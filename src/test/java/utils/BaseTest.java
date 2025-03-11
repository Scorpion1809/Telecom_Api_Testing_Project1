package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static String token; // Make sure token is a static variable

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }

    public static void setToken(String authToken) {
        token = authToken; // Store the token
    }

    public static String getToken() {
        return token;
    }
}
