import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserPayload;


public class SampleCreatUserRequest {

    public static void main(String[] args) {



        RestAssured.baseURI ="https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(createUserPayload())
        .when().post("api/users")
                .then().log().all().assertThat().statusCode(201);


        // apply body and header assertions -- Homework


    }

}
