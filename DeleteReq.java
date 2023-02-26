package apitest;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteReq {
	
@Test

	
public void deleteRecord() {
	
		
		RestAssured.baseURI="http://localhost:3000";
		RestAssured.basePath="/students/2";
		
		Response response=
		given()
		.when()
			.delete()
		.then()
			.log().all().extract().response();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);

}
}
