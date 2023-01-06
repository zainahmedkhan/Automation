package restassuredTests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/* 
	1- test status code
	2- log response
	3- verifying single content in respons body
	4- verifiying multiple content in response body
	5- setting parameters and headers
*/
public class Demo5_BasicValidations_JSON {
	
	@Test(priority = 1)
	public void testStatusCode()
	{		
		when()
			.get("https://jsonplaceholder.typicode.com/posts/1")	
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 2)
	public void testLogResponse()
	{
		Response response = 
		when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.body("userId", equalTo(1))
		.extract().response();
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"),true);
	}
	
	
	@Test(priority = 3)
	public void testSingleContent()
	{
		when()
			.get("https://dummy.restapiexample.com/api/v1/employee/1")
		.then()
			.statusCode(200)
			.body("data.employee_name", equalTo("Tiger Nixon"));
	}
	
	@Test(priority = 4)
	public void testMultipleContent()
	{
		{
			when()
				.get("https://dummy.restapiexample.com/api/v1/employee/1")
			.then()
				.statusCode(200)
				.body("data.employee_name",hasItems("Pakistan", "Germany", "Australia"));
		}
	}
	
	@Test(priority = 5)
	public void testParamsAndHeader()
	{
		given()
			.params("x", "1")
			.headers("y","2")
		.when()	
			.get("https://www.teamviewer.com/en-afrusd/overview")
		.then()
		.log().all();
	}
	
	
	

}
