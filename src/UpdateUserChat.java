import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import util.Payload;

import static io.restassured.RestAssured.given;

import static util.Payload.*;

public class UpdateUserChat {

    @Test
    public void updateUser()
    {

        String userid="13";
        // corrected- Now working

      /*  RestAssured.baseURI = "http://chat.cookingwithamol.in/";

        String userid="13"; // john
        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")

                .body(Payload.updateUser("aaa","bbb","ccc"))

                .when().put("/index.php/site_admin/restapi/user/"+userid)

                .then().log().all().assertThat().statusCode(200);*/


        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification requestSpecBuiler = new RequestSpecBuilder()
                .setBaseUri("http://chat.cookingwithamol.in/")
                .addHeader("Content-Type", "application/json")
                .setAuth(auth).build();

        RequestSpecification request = given().log().all().spec(requestSpecBuiler)
                .body(Payload.updateUser("a1", "b1", "c1"));

        Response hitRequest = request.when().put("/index.php/site_admin/restapi/user/" + userid);

        ResponseSpecification responseSpecBuilder
                = new ResponseSpecBuilder().expectStatusCode(200).build();

        hitRequest.then().log().all().spec(responseSpecBuilder);


    }
}
