import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static util.Payload.sampleCreateUserPayload;

public class SampleCreateUserExDataProvider {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job)
    {
        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-type","Application/json")
                .body(sampleCreateUserPayload(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Data/myData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount =sheet.getPhysicalNumberOfRows();
        Object[][] data= new Object[rowCount-1][2];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            data[i][0] = row.getCell(0).toString().trim();

            data[i][1] = row.getCell(1).toString().trim();

        }


           return  data;
    }

}
