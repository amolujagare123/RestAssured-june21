import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CowinAppRequest {


    @Test
    public void checkStates()
    {
        RestAssured.baseURI = "https://cdn-api.co-vin.in/";

        //https://cdn-api.co-vin.in/api/v2/admin/location/states

       String statesResponse =  given().auth().oauth2("amol")
               .when().get("/api/v2/admin/location/states")
                .then().assertThat().statusCode(403).extract().response().asString();
        System.out.println(statesResponse);

    }
}
