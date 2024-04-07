package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class API_PutRequest {
    @Test
    public void get01(){
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        JSONObject reqBody = new JSONObject();
        reqBody.put("title","sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        reqBody.put("body","quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto");
        reqBody.put("userId", "1");

        JSONObject expBody = new JSONObject();
        expBody.put("title","TestArabam");
        expBody.put("body","ArabamComPost");
        expBody.put("userId", "1907");

        Response response = given().contentType(ContentType.JSON).when().body(expBody.toString()).put(url);

        JsonPath actBody = response.jsonPath();

        actBody.prettyPrint();

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);

        Assert.assertEquals(expBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));
    }
}
