package apitest;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class PutReq {

	
	public static HashMap<String,Object> map = new HashMap<>();
		
		
		@BeforeClass
		public void putData() {

			map.put("name", "Amar");
			map.put("isfair", true);
			

			RestAssured.baseURI = "http://localhost:3000";
			RestAssured.basePath = "/students/2";
		}
		
		
		@Test
		public void putTest() {
			
			given()
				.contentType("application/json")
				.body(map)
			.when()
				.put()
			.then()
				.statusCode(200)
				.log().all();
			
		}
	}