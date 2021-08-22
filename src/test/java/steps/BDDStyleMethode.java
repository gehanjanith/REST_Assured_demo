package steps;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class BDDStyleMethode {
    public static void simpleGetPost(String postNumber) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get(String.format("http://localhost:3000/posts/%s", postNumber))
                .then()
                .body("author", is("typicode"));
    }

    public static void PerformContainCollection() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("typicode", "typicode 2", null));

    }

    public static void GetStatusCode(String statusCode) {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .statusCode(Integer.parseInt(statusCode));
    }
}
