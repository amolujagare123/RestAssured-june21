import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserChat;

public class CreateUserChatWithPAyLoad {

    @Test
    public  void myTest()
    {
       /* RestAssured.baseURI="http://chat.cookingwithamol.in";

        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")

                .body(createUserChat())


        .when().post("/index.php/site_admin/restapi/user")


                .then().log().all().assertThat().statusCode(400);*/

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("admin123");

        RequestSpecification reqSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("http://chat.cookingwithamol.in")
                .addHeader("Content-Type", "application/json")
                .setAuth(auth).build();

        RequestSpecification request = given().log().all().spec(reqSpecBuilder).body(createUserChat());

        Response hitResource = request.when().post("/index.php/site_admin/restapi/user");

        ResponseSpecification expResponse = new ResponseSpecBuilder().expectStatusCode(400).build();

        hitResource.then().log().all().spec(expResponse);

    }




}
