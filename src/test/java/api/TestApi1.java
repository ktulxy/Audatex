package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TestApi1 {

    @Test
    public void apiGetTask(){
        when().get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").
                then().assertThat().statusCode(200);
    }

    @Test
    public void get(){
        Response resp = RestAssured.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
        int code = resp.getStatusCode();
        String head = String.valueOf(resp.getHeaders());
        System.out.println(code);
       // System.out.println(head);
        Assert.assertEquals(code,200);
    }

    @Test
    public void postTest1(){
        JSONObject requestBody = new JSONObject();
                requestBody.put("apiKey", "11ea2b6ab6e3592fd15bcb420f0631f1");
                requestBody.put("category","aws");
                requestBody.put("method","getGoodsByName");
        JSONObject requestBodyArr = new JSONObject();
                requestBody.put("params",requestBodyArr);
                requestBodyArr.put("goodsName","Цетрин");
                requestBodyArr.put("regionCode","KA");

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("http://95.67.20.110:8237/aws/api/v1/json")
                .then().assertThat().statusCode(200)
               // .body("requestBody.params.goodsName", equals("Цетрин"))   хз не работает
                .log().all();
    }

    }



