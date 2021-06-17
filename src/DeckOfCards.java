import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckOfCards {

    @Test
    public void myTest() {

        RestAssured.baseURI ="https://deckofcardsapi.com";

        //------------ Shuffle the deck-----------

       String responseShuffle =  given().log().all().queryParam("deck_count","2")

        .when().get("api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200)
                .body("remaining",equalTo(104))
        .body("shuffled",equalTo(true))
        .header("server","cloudflare").extract().response().asString();

        System.out.println("------------Below is the response-------------");
        System.out.println(responseShuffle);

        JsonPath jsResponseShuffle = new JsonPath(responseShuffle);

        String deckIDGenerated = jsResponseShuffle.getString("deck_id");

        System.out.println("deckIDGenerated="+deckIDGenerated);

        //------------ Draw a card-----------

        String responseDrawCards = given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckIDGenerated+"/draw/")
                .then().log().all().assertThat().statusCode(200)
                .body("remaining",equalTo(102))
        .body("success",equalTo(true)).extract().response().asString();

        JsonPath jsResposnseDrawCards = new JsonPath(responseDrawCards);

        String deckIDResult =  jsResposnseDrawCards.getString("deck_id");

       // Assert.assertEquals(deckIDResult,deckIDGenerated,"incorrect Deck ID");

        int cardCount = jsResposnseDrawCards.getInt("cards.size()");
        System.out.println("cardCount="+cardCount);

        Assert.assertEquals(cardCount,2,"number of cards drawn is different");
              // actual ,expected, message
    }
}
