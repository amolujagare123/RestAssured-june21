import io.restassured.RestAssured;
import pojo.CreateUser;
import pojo.CreateUserResp;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserPayload;


public class SampleCreatUserPojo {

    public static void main(String[] args) {



        RestAssured.baseURI ="https://reqres.in";

        CreateUser ob = new CreateUser();

        ob.setName("Avinash");
        ob.setJob("Test Lead");


        CreateUserResp createUserResp = given().log().all().header("Content-Type", "application/json")
                .body(ob)
                .when().post("api/users")
                .as(CreateUserResp.class);


        System.out.println("Name="+createUserResp.getName());
        System.out.println("Job="+createUserResp.getJob());
        System.out.println("id="+createUserResp.getId());
        System.out.println("CreatedAt="+createUserResp.getCreatedAt());


    }

}
