package tc;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.Config;

public class TC_GetAllProduct {

	@Test
	public void t_01_get_request_for_all_product()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products").andReturn();
				
				int actual_status_code = resp.getStatusCode();
				String body = resp.asString();
				
				Assert.assertEquals(actual_status_code, 200);
				Reporter.log("Get Request for All Product  is Successfull. with body as : " + body);
				Reporter.log("Get Request for All Product is Successfull. with status code as : " + actual_status_code);

				
	}
	
	
}


