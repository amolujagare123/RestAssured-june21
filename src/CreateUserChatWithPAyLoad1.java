import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserChat;

public class CreateUserChatWithPAyLoad1 {

    @Test
    public  void myTest()
    {
        RestAssured.baseURI="http://chat.cookingwithamol.in";
        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")
                .body(createUserChat("john","john123","john@gmail.com",
                        "john","chacko","xyz"))
        .when().post("/index.php/site_admin/restapi/user")
        .then().log().all().assertThat().statusCode(200);

    }




}
