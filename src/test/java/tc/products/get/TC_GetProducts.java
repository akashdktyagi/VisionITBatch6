package tc.products.get;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.Config;
import static org.hamcrest.Matchers.*;
/*
 * Hamcrest Matcher Methods
 * equalTo, containsString, hasItem. hasSize etc
 * full list:
 * http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
 */

import java.util.List;

public class TC_GetProducts {


	@Test
	public void t_01_get_request_for_all_product()
	{
		RequestSpecification resp_spec = given().baseUri(Config.BASE_URL);//Comment new change from jira 40 branch
		
		Response resp = resp_spec.when().get("products");
		
		ValidatableResponse resp_valid = resp.then();
		
		resp_valid.assertThat().statusCode(200);
		resp_valid.assertThat().body(containsString("Duracell - AAA Batteries"));
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();

		Reporter.log("Get Request for All Product  is Successfull. with body as : " + body,true);
		Reporter.log("Get Request for All Product is Successfull. With status code as : " + actual_status_code,true);

		List<String> list = resp.jsonPath().getList("data.price");
		Reporter.log(list.toString(),true);
		
		String name = resp.jsonPath().get("data[0].name");
		Reporter.log(name,true);

	}


}
