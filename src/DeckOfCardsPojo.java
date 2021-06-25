import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Cards;
import pojo.DrawCardsRes;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckOfCardsPojo {

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

        DrawCardsRes responseDrawCards = given().log().all().queryParam("count", "2")
                .when().get("/api/deck/" + deckIDGenerated + "/draw/")
                .as(DrawCardsRes.class);

        boolean sucess = responseDrawCards.isSuccess();

        System.out.println("success value = "+sucess);

      /*  Cards card = responseDrawCards.getCards().get(1);

             String value =   card.getValue()
              String suit =   card.getSuit()*/

        String value =  responseDrawCards.getCards().get(1).getValue();
        String suit = responseDrawCards.getCards().get(1).getSuit();

        System.out.println("value="+value);
        System.out.println("suit="+suit);

        System.out.println("Deck_id="+responseDrawCards.getDeck_id());

        String pngUrl = responseDrawCards.getCards().get(0).getImages().getPng();
        String svgUrl = responseDrawCards.getCards().get(0).getImages().getSvg();

        System.out.println("pngUrl="+pngUrl);
        System.out.println("svgUrl="+svgUrl);

    }
}
