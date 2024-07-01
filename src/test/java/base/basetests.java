package base;

import actions.AssertActions;
import endpoints.API_CONSTRAINTS;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import modules.payload_manager;
import org.testng.annotations.BeforeTest;

public class basetests {
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public payload_manager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;
    @BeforeTest
    public void setUp(){
        System.out.println("Before Test");
        payload_manager p = new payload_manager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(API_CONSTRAINTS.base_url)
                .addHeader("Content-Type","application/json")
                .build().log().all();

//        requestSpecification = RestAssured.
//                given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();
    }
}
