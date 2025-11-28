import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void seUp(){
        RestAssured.baseURI = "http://localhost:4004/";
    }

    @Test
    public void shouldReturnOkWithValidToken(){
        // Arrange -> Act ->  Assert
        String loginPayload = """
                {
                    "email":"testuser@test.com",
                    "password":"password123"
                }
                """;

        Response response = RestAssured.given()// Arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()// Act
                .post("/auth/login")
                .then()
                .statusCode(200)// Assert
                .body("token",notNullValue())
                .extract().response();

        System.out.println("Generated Token :"+ response.jsonPath().getString("token") );

    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidLogin(){
        // Arrange -> Act ->  Assert
        String loginPayload = """
                {
                    "email":"wrong_testuser@test.com",
                    "password":"password1233456"
                }
                """;

        RestAssured.given()// Arrange
                .contentType("application/json")
                .body(loginPayload)
                .when()// Act
                .post("/auth/login")
                .then()
                .statusCode(401); // Assert;

        //System.out.println("Generated Token :"+ response.jsonPath().getString("token") );

    }

}
