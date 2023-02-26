package apitest;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostReq {
	@Test
	
	void CreateStudent() {
		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 3);
		requestParams.put("name", "Ram");
		requestParams.put("isfair", false);
		
		httprequest.header("Content-Type", "application/json");
		httprequest.body(requestParams.toJSONString());

		Response res = httprequest.request(Method.POST, "/students");
		System.out.println(res.getBody().asPrettyString());

		int s = res.getStatusCode();
		Assert.assertEquals(s, 201);

		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 201 Created");

	
	}
	
	
	
}
