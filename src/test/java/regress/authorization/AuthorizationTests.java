package regress.authorization;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationTests {
    private static final String BASE_URI = "http://localhost:50044/api/v1";

    @Test
    void login(){
        String requestBody = """
                {
                "password": "Test",
                "userName": "TestUser"
                }
                """;
        given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/login")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void register(){
        String requestBody = """
                {
                "password": "Test1",
                "secondPassword": "Test1",
                "userName": "TestUser1"
                }
                """;
        given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/register")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void registerIsUserAlreadyExist(){
        String requestBody = """
                {
                "password": "Test",
                "secondPassword": "Test",
                "userName": "TestUser"
                }
                """;
        given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/register")
                .then()
                .statusCode(500)
                .log().all();
    }

    @Test
    void loginWrongPassword(){
        String requestBody = """
                {
                "password": "Te",
                "userName": "TestUser"
                }
                """;
        given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/login")
                .then()
                .statusCode(500)
                .log().all();
    }

    @Test
    void loginWrongLogin(){
        String requestBody = """
                {
                "password": "Test",
                "userName": "Test"
                }
                """;
        given()
                .baseUri(BASE_URI)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/login")
                .then()
                .statusCode(500)
                .log().all();
    }


}



