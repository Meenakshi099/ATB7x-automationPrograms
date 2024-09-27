package ex_22092024.gson_seralization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class gson_Serialization {
    // Strings
    // Hashmap
    // Class - Pojo -
    // Create class for the Payload - pojo

    // PUT Request
    // token, booking id

//    {
//                "firstname" : "Jim",
//                        "lastname" : "Brown",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }

    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {
        booking booking = new booking();
        booking.setFirstname("Meenu");
        booking.setLastname("Gopi");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-09-08");
        bookingDates.setCheckout("2024-09-10");

        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) -
        Gson gson = new Gson();
        String jsonpayload=gson.toJson(booking);

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonpayload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Parse - DeSerilization




    }
}
