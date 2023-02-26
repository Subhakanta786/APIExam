package apitest;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MockAPI {
	
@Test
void postrequestWithSchemaValidator() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"id\": 3,\r\n"
					+ "    \"name\": \"Iqbal\",\r\n"
					+ "    \"isfair\": true,\r\n"
					+ "    \"address\": {\r\n"
					+ "        \"local\": \"Chennai\",\r\n"
					+ "        \"remote\": \"Ranchi\"\r\n"
					+ "    }\r\n"
					+ "}\r\n"
					+ "")
		.when()
			.post("https://run.mocky.io/v3/9dea329d-be79-4197-ae47-a3ac9556ab93")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StudentSchema.json"))
		.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\U1140293\\Desktop\\SDET Automation\\RESTAPITEST\\src\\test\\java\\apitest\\StudentSchema.json")))
		.statusCode(200)
		.log().all().extract().response();
		
		
		
		
	}
}
