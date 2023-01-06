package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class Demo2_CreateUser {
	
	public static HashMap map = new HashMap();
	
	// to prepare post to data
	@BeforeTest
	public void postData()
	{
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		
		RestAssured.baseURI="https://reqres.in/api";
		RestAssured.basePath="/users";
	}
	
	@Test
	public void testPost()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("name", equalTo("abcd"))
			.and()
			.header("CF-Cache-Status", "DYNAMIC");
	}

}
