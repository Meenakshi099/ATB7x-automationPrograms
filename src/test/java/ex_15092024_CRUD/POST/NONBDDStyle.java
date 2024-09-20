package ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class NONBDDStyle {
    public static void main(String[] args) {
        String payload = "{\n" +
                "                        \"username\" : \"admin\",\n" +
                "                        \"password\" : \"Password123\"\n" +
                "                }";
        //to organize them
        //bdd - not able to organize
        //nonbdd - chaining and breaking the continue but we can continue from anywhere!
        //given - request specification
        RequestSpecification r = RestAssured.given();
               r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("auth");
                r.contentType(ContentType.JSON).log().all();
               r.body(payload);
// when - response
        Response  response = r.when().post();

        //validation - then

        ValidatableResponse vr = response.then().statusCode(200).log().all();

    }
}
