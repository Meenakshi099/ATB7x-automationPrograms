package com.testingAcademy.ex_21092024.CRUD.Assertions;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;



                 public class test_011_Assertions {
        //  POST - Create -> Verify the Response
        RequestSpecification requestSpecification;
        ValidatableResponse validatableResponse;
        Response response;
        String token;
        Integer bookingId;

        @Test
        public void test_post() {
            String payload_POST = "{\n" +
                    "    \"firstname\" : \"Pramod\",\n" +
                    "    \"lastname\" : \"Dutta\",\n" +
                    "    \"totalprice\" : 111,\n" +
                    "    \"depositpaid\" : false,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2024-01-02\",\n" +
                    "        \"checkout\" : \"2024-01-20\"\n" +
                    "    },\n" +
                    "    \"additionalneeds\" : \"Lunch\"\n" +
                    "}";


            requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
            requestSpecification.basePath("/booking");
            requestSpecification.contentType(ContentType.JSON);
            requestSpecification.body(payload_POST).log().all();

            Response response = requestSpecification.when().post();

            // Get Validatable response to perform validation
            validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);

            // Rest Assured Default - Hamcrest
            // import org.hamcrest.Matchers;
//        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
//        validatableResponse.body("bookingid",Matchers.notNullValue());


            // TestNG Assertion
            // SoftAssert vs
            // HardAssert - This means that if any assertion fails, the remaining statements in that test method will not be executed.

            bookingId = response.then().extract().path("bookingid");
            String firstname = response.then().extract().path("booking.firstname");

//        Assert.assertNotNull(bookingId);
//        Assert.assertEquals(firstname,"Pramod");

            // AssertJ Assertion
            String lastname;
            String checkinDate = response.then().extract().path("booking.bookingdates.checkin");
            String checkoutDate =response.then().extract().path("booking.bookingdates.checkout");
            String totalprice;
            String depositpaid;

            assertThat(bookingId).isNotNull().isNotZero().isPositive();
            assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank();
          //  assertThat(lastname).isNotBlank().isNotEmpty().isEqualTo("Dutta");
            assertThat(checkinDate).isLessThan(checkoutDate);
            checkinDate = response.jsonPath().getString("bookingId");


           // String s = ""; //Empty
           // String s2 = " "; //Blank


//        bookingId = response.jsonPath().getString("bookingid");

        }

                     }

