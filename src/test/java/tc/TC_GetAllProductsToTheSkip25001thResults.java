package tc;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.Config;
@Test
public class TC_GetAllProductsToTheSkip25001thResults {

	public void t_01_get_request_for_all_products_to_the_skip_25001th_result()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("/products?$skip=25000").andReturn();
				
				int actual_status_code = resp.getStatusCode();
				String body = resp.asString();
				
				Assert.assertEquals(actual_status_code, 200);
				Reporter.log("Get Request for all Products to the skip 25001th result is Successfull. with body as : " + body);
				System.out.println("Response Body is: " + body.toString());
		
	}
}
