package Base;

import Utils.FilePaths;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Parameters;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BaseApiTest {

    public static RequestSpecification req;

   @BeforeTest
   @Parameters("API")
    public static RequestSpecification requestSpecification() throws IOException {

        req = new RequestSpecBuilder().setBaseUri(FilePaths.BaseApiURl).build();
        return req;

    }

    public String getJsonPath(Response response, String key) {
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return js.get(key).toString();
    }

    public static JSONObject parseJson (String jsonPathFile)  {
        JSONParser jsonParser=new JSONParser();
        FileReader reader=null;
      try{
          reader=new FileReader(jsonPathFile);

      }catch (FileNotFoundException exception){
          System.out.println("No File is found");

      }
      JSONObject object =null;
      try{
          object=(JSONObject) jsonParser.parse(reader);

      }catch (Exception e) {
          System.out.println("Failed to parse file");

      }
      return object;



    }


    }




