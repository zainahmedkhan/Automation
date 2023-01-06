package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class Demo3_UpdateUser {
	
	public static HashMap map = new HashMap();
	String empName =  RestUtils.getName();
	String empSalary =  RestUtils.getEmpSalary();	
	int empId = 22;	
	@BeforeTest()
	public void putData()
	{
		map.put("employee_name", empName);
		map.put("employee_salary", empSalary);
		
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//RestAssured.basePath = "/update/"+empId;
			
	}
	
	@Test
	public void testPut()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put("http://dummy.restapiexample.com/api/v1/update/"+empId)
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
