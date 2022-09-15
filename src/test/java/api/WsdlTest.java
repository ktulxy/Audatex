package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static javax.print.attribute.standard.MediaSizeName.C;

public class WsdlTest {

    @Test
    public void testWsdl(){



JSONObject flag = new JSONObject();
flag.put("sCountryISOCode","UA");
given()
        .contentType("text/xml")
        .body("UA")
        .post("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL")
        .then().log().all();


    }
    @Test
    public void Test2(){

       JSONObject bodyRest = new JSONObject();
        bodyRest.put("loginId","ingo.b2b");
        bodyRest.put("password","ingo.b2b");
        RestAssured
                .given()
                .contentType("text/xml")
                .body(bodyRest.toString())
                .post("https://www-a.audatex.net/b2b/services/TaskService_v1?WSDL")
                .then().log().all();
    }
}

    /*JSONObject bodyRest = new JSONObject();
        bodyRest.put("loginId","ingo.b2b");
                bodyRest.put("password","ingo.b2b");
                RestAssured
                .given()
                .contentType("text/xml")
                .body(bodyRest.toString())
                .post("https://www-a.audatex.net/b2b/services/TaskService_v1?WSDL")
                .then().log().all();
*/