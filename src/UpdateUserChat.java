import io.restassured.RestAssured;
import org.testng.annotations.Test;
import util.Payload;

import static io.restassured.RestAssured.given;

import static util.Payload.*;

public class UpdateUserChat {

    @Test
    public void updateUser()
    {
        // corrected- Now working

        RestAssured.baseURI = "http://chat.cookingwithamol.in/";

        String userid="13"; // john
        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")
                .body(Payload.updateUser("aaa","bbb","ccc"))
                .when().put("/index.php/site_admin/restapi/user/"+userid)
                .then().log().all().assertThat().statusCode(200);
    }
}
