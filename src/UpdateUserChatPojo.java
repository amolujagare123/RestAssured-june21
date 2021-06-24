import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.UpdateChatUser;
import util.Payload;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UpdateUserChatPojo {

    @Test
    public void updateUser()
    {
        // corrected- Now working

        RestAssured.baseURI = "http://chat.cookingwithamol.in/";

        UpdateChatUser ob =new UpdateChatUser();
        ob.setName("john");
        ob.setSurname("xyz");
        ob.setChat_nickname("myNickName");

        List<Integer>  dept = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }
        };


        List<Integer>  deptRead = new ArrayList<Integer>() {{
            add(2);
        }
        };

        List<Integer>  deptGrp = new ArrayList<Integer>() {{

            add(1);
        }
        };

        List<Integer>  usrGrp = new ArrayList<Integer>() {{
            add(1);
        }
        };

        ob.setDepartments(dept);
        ob.setDepartment_groups(deptGrp);
        ob.setDepartments_read(deptRead);
        ob.setUser_groups(usrGrp);



        String userid="13"; // john
        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")
                .body(ob)
                .when().put("/index.php/site_admin/restapi/user/"+userid)
                .then().log().all().assertThat().statusCode(200);
    }
}
