package tests.integration;

import base.basetests;
import endpoints.API_CONSTRAINTS;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pojos.Booking;
import pojos.BookingResponse;

public class TCintegration extends basetests {

    @Test(priority = 1)
    public void createBooking(ITestContext iTestContext)
    {

        iTestContext.setAttribute("token", getToken());
        r.basePath(API_CONSTRAINTS.base_path);
        r.baseUri(API_CONSTRAINTS.base_url);
        r.contentType(ContentType.JSON).log().all().body(p.createPayload());
        response=r.when().log().all().post();
//        String res= response.asString();
//        System.out.println(res);
        v= response.then();
        v.statusCode(200);
BookingResponse bookingResponse=p.bookingResponseJava(response.asString());
       iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }
    @Test(priority = 2)
    public void verifybookingID(ITestContext iTestContext)
    {


        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        // GET Req
        String basePathGET = API_CONSTRAINTS.base_path+"/"+bookingid;
        System.out.println(basePathGET);
        r.baseUri(API_CONSTRAINTS.base_url);
        r.basePath(basePathGET);
//        response = RestAssured
//                .given(r)
//                .when().get();
        response=r.when().log().all().get();
        v = response.then().log().all();
        // Validatable Assertion
        v.statusCode(200);

        Booking booking = p.bookingresponse(response.asString());
//        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
//        assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));


    }
    @Test(priority = 3)
    public void updatebooking(ITestContext iTestContext)
    {
        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathGET = API_CONSTRAINTS.base_path+"/"+bookingid;
      r.basePath(basePathGET);
      r.cookie("token",token);
    r.contentType(ContentType.JSON).body(p.fullUpdatePayloadAsString());
       response= r.when().log().all().put();
        v = response.then().log().all();
        v.statusCode(200);
    }
    @Test(priority = 4)
    public void deletebooking(ITestContext iTestContext)
    {
        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathGET = API_CONSTRAINTS.base_path+"/"+bookingid;
        r.basePath(basePathGET);
        r.cookie("token",token);
        response= r.when().log().all().delete();
        v = response.then().log().all();
        v.statusCode(201);
    }

}
