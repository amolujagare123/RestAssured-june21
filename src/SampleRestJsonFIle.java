import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SampleRestJsonFIle {

    public static void main(String[] args) throws IOException {



        RestAssured.baseURI ="https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(new String(Files.readAllBytes(Paths.get("D:\\Study\\API\\createUser.json"))))
                 .when().post("api/users")

                .then().log().all().assertThat().statusCode(201);




        // apply body and header assertions -- Homework


    }
}
