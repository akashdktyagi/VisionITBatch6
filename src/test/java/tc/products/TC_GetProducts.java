package tc.products;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.Config;

public class TC_GetProducts {


	@Test
	public void t_01_get_request_for_all_product()
	{
		RequestSpecification resp_spec = given().baseUri(Config.BASE_URL);
		Response resp = resp_spec.when().get("products");
		ValidatableResponse resp_valid = resp.then();
		resp_valid.assertThat().statusCode(200);
		//resp_valid.assertThat().body(arguments, responseAwareMatcher)
		int actual_status_code = resp.getStatusCode();
		

		Assert.assertEquals(actual_status_code, 200);
		//Reporter.log("Get Request for All Product  is Successfull. with body as : " + body);
		Reporter.log("Get Request for All Product is Successfull. With status code as : " + actual_status_code);


	}


}
