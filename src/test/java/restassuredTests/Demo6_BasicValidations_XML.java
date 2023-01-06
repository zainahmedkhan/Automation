package restassuredTests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Demo6_BasicValidations_XML {

	@Test(priority = 1)
	public void testSingleContent()
	{
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
		.body("CUSTOMER.ID",equalTo("10"))
		.log().all();
	}
	
	@Test(priority = 2)
	public void testMultipleContents()
	{
		when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
		.body("CUSTOMER.ID",equalTo("10"))
		.body("CUSTOMER.FIRSTNAME",equalTo("Sue"))
		.body("CUSTOMER.LASTNAME",equalTo("Fuller"))
		.body("CUSTOMER.STREET",equalTo("135 Upland Pl."))
		.body("CUSTOMER.CITY",equalTo("Dallas"))
		.log().all();
	}
	
	@Test(priority = 3)
	public void testAllContentsInOneGo()
	{
		when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
			.body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"));
	}
	
	@Test(priority = 4)
	public void testUsingXPath1()
	{
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
	}
	
	@Test(priority = 5)
	public void testUsingXPath2()
	{
		when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}
	
}


/*

<CUSTOMER xmlns:xlink="http://www.w3.org/1999/xlink">
<ID>10</ID>
<FIRSTNAME>Sue</FIRSTNAME>
<LASTNAME>Fuller</LASTNAME>
<STREET>135 Upland Pl.</STREET>
<CITY>Dallas</CITY>
</CUSTOMER>

*/