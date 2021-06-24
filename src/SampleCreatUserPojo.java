import io.restassured.RestAssured;
import pojo.CreateUser;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserPayload;


public class SampleCreatUserPojo {

    public static void main(String[] args) {



        RestAssured.baseURI ="https://reqres.in";

        CreateUser ob = new CreateUser();

        ob.setName("Tejashree");
        ob.setJob("Trainer");


        given().log().all().header("Content-Type","application/json")
                .body(ob)
        .when().post("api/users")
                .then().log().all().assertThat().statusCode(201);


        // apply body and header assertions -- Homework


    }

}
