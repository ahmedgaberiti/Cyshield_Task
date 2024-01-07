package Tests;

import Base.BaseApiTest;
import POJOClasses.CreateUserApiResponse;
import POJOClasses.Data;
import POJOClasses.GETAPIResponse;
import POJOClasses.UpdateUserResponse;
import Utils.FilePaths;
import com.google.gson.JsonObject;
import io.restassured.parsing.Parser;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTests extends BaseApiTest {

    //Response response;
    String queryParamPageNumber = "2";
    String firstEmail = "michael.lawson@reqres.in";

    JSONObject testdata;


    @Test(priority = 1)
    public void getListOfUsersApi() throws IOException {
        GETAPIResponse getapiResponse = given().log().all().spec(requestSpecification())
                .queryParam("page", queryParamPageNumber)
                .expect().defaultParser(Parser.JSON)
                .when().get()
                .as(GETAPIResponse.class);
        int dataFieldCount = getapiResponse.getData().size();
        List<Data> dataFieldList = getapiResponse.getData();
        for (int i = 0; i < dataFieldCount; i++) {
            System.out.println(dataFieldList.get(i).getEmail());
        }
        Assert.assertEquals(firstEmail, dataFieldList.get(0).getEmail());
    }

    @Test(priority = 2)
    public void createUserApi() throws IOException {
        testdata = (JSONObject) parseJson(FilePaths.UsersTestData).get("NewUser");
        String payload = testdata.toString();
        System.out.println(payload);
        CreateUserApiResponse createUserApiResponse = given().log().all().spec(requestSpecification())
                .body(payload)
                .expect().defaultParser(Parser.JSON)
                .when().post()
                .as(CreateUserApiResponse.class);

        String id = createUserApiResponse.getId();
        Assert.assertFalse(id.isEmpty());
    }

    @Test(priority = 3)
    public void updateUserApi() throws IOException {
        testdata = (JSONObject) parseJson(FilePaths.UsersTestData).get("UpdateUser");
        String payload = testdata.toString();
        System.out.println(payload);
        UpdateUserResponse updateUserResponse = given().log().all().spec(requestSpecification())
                .body(payload)
                .expect().defaultParser(Parser.JSON)
                .when().put("/2")
                .as(UpdateUserResponse.class);

        String updated = updateUserResponse.getUpdatedAt();
        Assert.assertFalse(updated.isEmpty());

    }


}
