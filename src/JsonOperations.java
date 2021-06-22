import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static util.DummyOutput.dummyResponse;

public class JsonOperations {

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

        for(int i=0;i<courseCount;i++)
        {
            System.out.print("BookName :"+js.getString("courses["+i+"].title"));
            System.out.println("    Price :"+js.getString("courses["+i+"].price"));
        }


        for(int i=0;i<courseCount;i++)
        {
            if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA")) {
                System.out.println("Price of RPA book :" + js.getString("courses[" + i + "].price"));
                    break;

           }
            }

    }
}
