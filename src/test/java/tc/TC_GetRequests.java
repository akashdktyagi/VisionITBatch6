package tc;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.Config;

import static io.restassured.RestAssured.*;
public class TC_GetRequests {

	@Test
	public void t_01_health_check() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/healthcheck").andReturn();
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Health Check is Successfull. with body as : " + body);
		System.out.println("Response Body is: " + body.toString());
	
		
	}
	
	@Test
	public void t_02_get_request_for_product_with_id() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("products/9132294").andReturn();
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Get Request for Product with Id is Successfull. with body as : " + body);
		Reporter.log("Get Request for Product with status code as : " +actual_status_code);
	
		
	}
	
		
	@Test
	public void t_03_get_request_for_allproduct_sortby_highest_price_descending() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$sort[price]=-1").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Get Request for Product with price sorted in descending order is Successfull. with body as : " + body);
			
		
	}
}
