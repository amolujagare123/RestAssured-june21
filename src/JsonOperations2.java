import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static util.DummyOutput.dummyResponse;

public class JsonOperations2 {

    @Test
    public void myTest()
    {
        String response = dummyResponse();

        JsonPath js = new JsonPath(response);

        int courseCount = js.getInt("courses.size()");

        System.out.println("courseCount="+courseCount);

        int purchaseAmount = js.getInt("dashboard.purchaseAmount");

        System.out.println("purchaseAmount="+purchaseAmount);

        String firstBook = js.getString("courses[0].title");
        System.out.println("firstBook="+firstBook);

        //courses[0].price

        System.out.println("All books with prices");

        int sumOfAllBooks=0;

        for(int i=0;i<courseCount;i++)
        {

            int price = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");

            int totalBookPrice = price * copies;

            sumOfAllBooks = sumOfAllBooks + totalBookPrice;

        }

        System.out.println("Sum Of All Books="+sumOfAllBooks);


    }
}
