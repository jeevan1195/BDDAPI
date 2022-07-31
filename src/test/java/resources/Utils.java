package resources;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    RequestSpecification request;
    String response;
    JsonPath jsonPath;

    public RequestSpecification requestSpecification() throws IOException {
         request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();
         return request;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/global.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }


    public String getJsonPathValues(Response response , String key){
       String resp =  response.asString();
       jsonPath = new JsonPath(resp);
       return jsonPath.getString(key);

    }
}
