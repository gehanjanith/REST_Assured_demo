package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class GetPostSteps {
    @Given("User perform GET operation for {string}")
    public void userPerformGETOperationFor(String url) {
        given().contentType(ContentType.JSON);
    }

    @Given("User perform Search for Post {string}")
    public void userPerformSearchForPost(String postNumber) {
        when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("typicode"));
        /**  OR
         * then().body("author", equalTo("typicode")); **/
    }

    @Then("author should be shown as {string}")
    public void authorShouldBeShownAs(String name) {
        // then().body("author",("typicode"));
    }
}
