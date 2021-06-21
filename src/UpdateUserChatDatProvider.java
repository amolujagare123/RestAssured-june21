import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Payload;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UpdateUserChatDatProvider {

    @Test(dataProvider = "getData")
    public void updateUser(String userid,String name,String surname,String nickName)
    {
        // corrected- Now working

        RestAssured.baseURI = "http://chat.cookingwithamol.in/";

       // String userid="13"; // john
        given().log().all().header("Content-Type","application/json")
                .auth().preemptive().basic("admin","admin123")
                .body(Payload.updateUser(name,surname,nickName))
                .when().put("/index.php/site_admin/restapi/user/"+userid)
                .then().log().all().assertThat().statusCode(200);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("Data/myData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet2");

        int rowCount =sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data= new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<colCount;j++)
            data[i][j] = row.getCell(j).toString().trim();


        }


        return  data;
    }
}
