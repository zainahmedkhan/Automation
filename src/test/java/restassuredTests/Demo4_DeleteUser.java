package restassuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DeleteUser {
	
	int emp_id = 8;
	
	@Test
	public void DeleteUser()
	{
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/"+emp_id;
		
		Response response = 
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
		.extract().response();
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("We will fix it as soon as possible"),true);
			
	}
	

}
