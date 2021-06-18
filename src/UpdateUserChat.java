import io.restassured.RestAssured;
import org.testng.annotations.Test;
import util.Payload;

import static io.restassured.RestAssured.given;

import static util.Payload.*;

public class UpdateUserChat {

    @Test
    public void updateUser()
    {
        RestAssured.baseURI = "http://chat.cookingwithamol.in/";

        String userid="13"; // john
        given().log().all().header("Content-Type","application/json")
                .body(Payload.updateUser("aaa","bbb","ccc"))
                .when().put("/index.php/site_admin/api/users/"+userid)
                .then().log().all();
    }
}
