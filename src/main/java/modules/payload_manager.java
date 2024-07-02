package modules;

import com.google.gson.Gson;
import pojos.*;

public class payload_manager {
    Gson g=new Gson();
   public String createPayload()
   {
       Booking b=new Booking();

       b.setFirstname("lokesh");
       b.setLastname("KURU");
       b.setTotalprice(40);
       b.setDepositpaid(true);
       bookingdates b1=new bookingdates();
       b1.setCheckin("27-06-2024");
       b1.setCheckout("27-07-2024");
       b.setBookingdates(b1);
       b.setAdditionalneeds("lunch");
       String jsonPayload = g.toJson(b);;
       return jsonPayload;
   }
    public String createInvalidPayloadBookingAsString() {
        return "{}";
    }
    public String fullUpdatePayloadAsString() {
        Booking b = new Booking();
        b.setFirstname("James");
        b.setLastname("Dutta");
        b.setTotalprice(112);
        b.setDepositpaid(true);

        bookingdates bookingdates = new bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        b.setBookingdates(bookingdates);
        b.setAdditionalneeds("Breakfast");
        return g.toJson(b);
    }
    public BookingResponse bookingResponseJava(String responseString){
        g = new Gson();
        BookingResponse bookingRespons = g.fromJson(responseString,BookingResponse.class);
        return bookingRespons;
    }
    public String setauthpayload()
    {
        Auth a=new Auth();
        a.setUsername("admin");
        a.setPassword("password123");
       String jsonpayload= g.toJson(a);
        return jsonpayload;
    }
    public String gettoken(String tokenresponse)
    {
       TokenResponse gettoken1= g.fromJson(tokenresponse, TokenResponse.class);
        return gettoken1.getToken();
    }
    public Booking bookingresponse(String getresponse)
    {
        Booking GETRESPONSE =g.fromJson(getresponse, Booking.class);
        return GETRESPONSE;
    }

}
