package ex_15092024_CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle {
    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.relaxedHTTPSValidation();
        r.baseUri("https://api.zippopotam.us");
        testnonbdd_1();
        testnonbdd_2();
    }

    private static void testnonbdd_2() {
        r.basePath("/IN/600045");
        r.when().get();
        r.then().log().all().statusCode(404);
    }
    private static void testnonbdd_1() {
        r.basePath("/IN/600034");
        r.when().get();
        r.then().log().all().statusCode(200);
    }
}

