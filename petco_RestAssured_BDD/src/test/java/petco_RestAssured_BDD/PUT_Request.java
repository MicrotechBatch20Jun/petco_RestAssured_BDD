package petco_RestAssured_BDD;

import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PUT_Request {

public static HashMap data = new HashMap();
	
	@BeforeClass
	public void postdata() {
		data.put("id", 600);
		data.put("username", "jwatson");
		data.put("firstName", "John");
		data.put("lastName", "Watson");
		data.put("email", "jwatson@gmail.com");
		data.put("password", "jwatson");
		data.put("phone", "9175004455");
		data.put("userStatus", 0);
		
		RestAssured.baseURI= "https://petstore.swagger.io/v2";
		RestAssured.basePath = "/user/jdoe";
	}
	@Test
	public void testPost() {
		
		given()
			.header("Content-Type", "application/json")
			.body(data)
			
		.when()
			.put()
			
		.then()
			.assertThat()
				.statusCode(200)
				.and()
				.header("Content-Type", "application/json")
				.and()
				.header("Transfer-Encoding", "chunked")
				.and()
				.body("code", equalTo(200))
				.and()
				.body("type", equalTo("unknown"))
				.and()
				.body("message", equalTo("600"));
		
		
	}
}
