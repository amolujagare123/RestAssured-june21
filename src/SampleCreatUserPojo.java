import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.CreateUser;
import pojo.CreateUserResp;

import static io.restassured.RestAssured.given;
import static util.Payload.createUserPayload;


public class SampleCreatUserPojo {

    public static void main(String[] args) {



       // RestAssured.baseURI ="https://reqres.in";

        CreateUser ob = new CreateUser();

        ob.setName("Avinash");
        ob.setJob("Test Lead");


       /* String createUserResp = given().log().all()
                .header("Content-Type", "application/json")
                .body(ob)
                .when().post("api/users")
                .then().assertThat().statusCode(201).extract().asString();*/

        // spec builder

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                /*.setBody(ob)*/
                .build(); // given

        RequestSpecification res = given().spec(req).body(ob);
           // ------------------- Given ---------------

        ResponseSpecification resp = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        Response response = res.when().post("api/users"); // when


        String resp1 = response.then().log().all().spec(resp).extract().asString();

        //System.out.println(resp1);

        // then

       /* Response response =res.when().post("/resourse").
                then().spec(resspec).extract().response();*/




     /*   System.out.println("Name="+createUserResp.getName());
        System.out.println("Job="+createUserResp.getJob());
        System.out.println("id="+createUserResp.getId());
        System.out.println("CreatedAt="+createUserResp.getCreatedAt());
*/

    }

}
