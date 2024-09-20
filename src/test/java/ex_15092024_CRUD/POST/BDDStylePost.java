package ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDStylePost {
    //URL - https://restful-booker.herokuapp.com/auth
    //BODY -PAYLOAD-JSON
   // { "username" : "{{username}}",
      //       "password" : "{{password}}"
    //}
    //HEADER - CONTENT TYPE - application/json
    public static void main(String[] args) {

        String payload = "{\n" +
                "                        \"username\" : \"admin\",\n" +
                "                        \"password\" : \"Password123\"\n" +
                "                }";
        RestAssured.given().
                baseUri("https://restful-booker.herokuapp.com")
                .basePath("auth")
                .contentType(ContentType.JSON).log().all().body(payload).when().post().
                then().statusCode(200).log().all();

    }

    }


