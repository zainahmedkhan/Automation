package restassuredTests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo1_GET_Request {
	
	@Test
	public void getUserDetails()
	{
		given()
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employee/1")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json");
			//.log().all();
			//.assertThat().body("data.name", equalTo("fuchsia rose"))
	}
}
