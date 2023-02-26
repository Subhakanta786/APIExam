package apitest;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;

public class FileDownload {
	
	@Test
	void fileDownload() throws IOException{
		
		Response res=
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/students");
		
		byte[] bytes=res.getBody().asByteArray();
		File file=new File("C:\\Users\\U1140293\\Desktop\\SDET Automation\\RESTAPITEST\\src\\test\\java\\FileDownload.json");
		Files.write(file.toPath(), bytes);
		
		
	}

}
