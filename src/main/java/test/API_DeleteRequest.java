package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class API_DeleteRequest {

    @Test
    public void f()
    {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 1);

        Response response = response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).delete(url);

        JsonPath actBody = response.jsonPath();
        actBody.prettyPrint();

        response.then().assertThat().statusCode(200);

    }
}

