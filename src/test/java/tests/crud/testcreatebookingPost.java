package tests.crud;

import base.basetests;
import endpoints.API_CONSTRAINTS;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojos.BookingResponse;
import  org.assertj.core.api.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

public class testcreatebookingPost extends basetests {
    @Test(groups = "smoke")
    @Owner("chitra")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking() {
        r.basePath(API_CONSTRAINTS.base_path);
        response = RestAssured
                .given(r)
                .when().body(p.createPayload()).post();

        v = response.then().log().all();


        v.statusCode(200);

        BookingResponse bookingResponse = p.bookingResponseJava(response.asString());

        assertActions.verifyStatusCode(response,200);
    }
    @Test(groups = "smoke")
    @Owner("chitra")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingNegative() {
        r.basePath(API_CONSTRAINTS.base_path);
        response = RestAssured
                .given(r)
                .when().body(p.createInvalidPayloadBookingAsString()).post();

        v = response.then().log().all();



        // Validatable Assertion
        v.statusCode(500);
        assertActions.verifyStatusCode(response,500);
    }

}
