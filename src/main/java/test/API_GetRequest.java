package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class API_GetRequest {
    @Test
    public void get01(){
        String url = "https://jsonplaceholder.typicode.com/posts/55";
        JSONObject expbody = new JSONObject();
        expbody.put("userId",6);
        expbody.put("title","sit vel voluptatem et non libero");

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actbody = response.jsonPath();
        Assert.assertEquals(expbody.get("userId"), actbody.get("userId"));
        Assert.assertEquals(expbody.get("title"), actbody.get("title"));
    }
}
