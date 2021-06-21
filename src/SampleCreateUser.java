import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static util.Payload.sampleCreateUserPayload;

public class SampleCreateUser {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job)
    {
        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-type","Application/json")
                .body(sampleCreateUserPayload(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data= {

                {"John","Test Lead"}, // name , job
                {"Avinash","Project Manager"},
                {"Amol","Instructor"},
                {"Raj","Developer"}

        };
           return  data;
    }

}
