package serializatonDeserialization;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

public class CreateStudentNoSerialization {
	
	public HashMap map = new HashMap();
	
	
	// serialization
	@Test(priority=1)
	public void createEmployee()
	{
		map.put("name", "zain");
		map.put("job", "qa");
						
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.assertThat()
			.log().all();
		
	}
	
	
	//deserialization
	@Test(priority=2)
	public void getEmployee()
	{
		
		Employee emp = get("https://reqres.in/api/users").as(Employee.class);
		System.out.println(emp.employeeRecord());
		
		
	}

}
