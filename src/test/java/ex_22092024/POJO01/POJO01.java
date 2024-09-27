package ex_22092024.POJO01;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.qameta.allure.internal.shadowed.jackson.databind.type.LogicalType.Map;

public class POJO01 {
    // Hashmap Payload

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;
    String Firstname;

    @Test
    public void test_post_with_hashmap() {

        // {
        //    "firstname" : "sally",
        //    "lastname" : "brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}

        // Hashmap ->
        // {} - map

        Map<String, Object> JsonHashMap = new LinkedHashMap<>();
        JsonHashMap.put("firstname", "James");
        JsonHashMap.put("lastname", "Sally");
        JsonHashMap.put("totalprice", 111);
        JsonHashMap.put("depositpaid", true);

        Map<String, Object> BookingdatesMap = new LinkedHashMap<>();
        BookingdatesMap.put("checkin", "2018-01-01");
        BookingdatesMap.put("checkout", "2018-01-01");

        JsonHashMap.put("bookingdates", BookingdatesMap);
        JsonHashMap.put("additionalneeds", "Breakfast");

        System.out.println(JsonHashMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(JsonHashMap).log().all();
        Gson gson = new Gson();
        String jsonHashMap = gson.toJson(bookingId);
        jsonHashMap = gson.toJson(Firstname);

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
       // firstname = response.jsonPath().getString(("firstname"));
       // System.out.println(firstname);


        System.out.println(response.asString());
       JsonPath json = new JsonPath(response.asString());
        bookingId = json.getString("bookingid");
        System.out.println(bookingId);
        Firstname =json.getString("booking.firstname");
        System.out.println(Firstname);

    }
}
