package base;

import actions.AssertActions;
import endpoints.API_CONSTRAINTS;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import modules.payload_manager;
import org.testng.annotations.BeforeTest;

public class basetests {
    public RequestSpecification r;
    public AssertActions assertActions;
    public payload_manager p;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse v;
    @BeforeTest
    public void setUp(){
        System.out.println("Before Test");
        p = new payload_manager();
        assertActions  = new AssertActions();
//        requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(API_CONSTRAINTS.base_url)
//                .addHeader("Content-Type","application/json")
//                .build().log().all();

        r = RestAssured.
                given()
                .baseUri(API_CONSTRAINTS.base_url)
                .contentType(ContentType.JSON)
                .log().all();
    }

    public String getToken() {
        return null;
    }
}
