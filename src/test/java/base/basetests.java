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

    public String getToken()
    {
//        r.baseUri(API_CONSTRAINTS.base_url);
//        r.basePath(API_CONSTRAINTS.auth_url);
//        r.contentType(ContentType.JSON).body(p.setauthpayload());
//        r.when().log().all().post();
//        r.response().then();
//        String token = p.gettoken(response.asString());
//        return token;

        r =
                RestAssured.given().baseUri(API_CONSTRAINTS.base_url)
                        .basePath(API_CONSTRAINTS.auth_url);

        // Setting the up the Payload
        String payload = p.setauthpayload();

        // Getting the Response
        response = r
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        // Extracting of the Token via Deserialization.
        String token = p.gettoken(response.asString());

        // Verify
        return token;

    }


}
