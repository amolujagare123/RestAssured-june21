import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckOfCards {

    public static void main(String[] args) {

        RestAssured.baseURI ="https://deckofcardsapi.com";

        given().log().all().queryParam("deck_count","2")

        .when().get("api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("remaining",equalTo(104))
        .body("shuffled",equalTo(true))
        .header("server","cloudflare");

    }
}
