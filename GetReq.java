package apitest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReq {

	@Test
	void GetStudent() {

		RestAssured.baseURI = " http://localhost:3000/students";

		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.GET, "/2");
		System.out.println(response);
		String name = response.jsonPath().get("students[1].name");
		boolean isFair = response.jsonPath().get("students[2].isfair");

		Assert.assertEquals(name, "Ram");
		Assert.assertEquals(isFair, false);

	}
}