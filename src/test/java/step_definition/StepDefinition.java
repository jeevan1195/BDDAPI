package step_definition;

import static org.junit.Assert.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import resources.APIResources;
import resources.TestData;
import resources.Utils;

import java.io.IOException;


import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    TestData testData = new TestData();
    JsonPath jsonPath;


    @Given("Add place payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        requestSpecification = given().spec(requestSpecification())
                .body(testData.addPLacePayload(name,language,address));

    }

    @When("^user calls \"([^\"]*)\" using \"([^\"]*)\" request$")
    public void user_calls_something_using_something_request(String resource, String method) throws Throwable {

        APIResources resourceAPI = APIResources.valueOf(resource);
      System.out.println(resourceAPI.getResource());

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("Post")){
         response =  requestSpecification.when().post(resourceAPI.getResource());
        }
        else if(method.equalsIgnoreCase("Get")){
            requestSpecification.when().get(resourceAPI.getResource());
        }
    }

    @Then("^API response with status code 200$")
    public void api_response_with_status_code_200() throws Throwable {
        assertEquals(response.getStatusCode(),200);

    }

    @And("^\"([^\"]*)\" response should be \"([^\"]*)\"$")
    public void something_response_should_be_something(String keyValue, String ExpectedValue) throws Throwable {
        assertEquals(getJsonPathValues(response, keyValue),ExpectedValue);
    }

    @Then("Verify {string} with place_id of {string}")
    public void verify_with_place_id_of(String resource, String expectedName ) throws Throwable {

        String placeId = getJsonPathValues(response,"place_id");
        System.out.println(placeId);
        given().spec(requestSpecification()).queryParam("place_id",placeId);
        user_calls_something_using_something_request(resource ,"Get");
       String actualName = getJsonPathValues(response,"name");
       System.out.println(actualName);
       assertEquals(expectedName ,actualName);

    }



}
