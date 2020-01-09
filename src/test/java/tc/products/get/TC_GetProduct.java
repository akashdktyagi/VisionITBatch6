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

import java.util.List;

public class TC_GetProduct {


	@Test
	public void TC_01GetMethod()
	{
		RequestSpecification resp_spec = given().baseUri(Config.BASE_URL);
		Response resp = resp_spec.when().get("products");
		ValidatableResponse resp_valid = resp.then();

		//validation
		resp_valid.assertThat().statusCode(200);
		resp_valid.assertThat().body(containsString("Duracell - AAA Batteries (4-Pack"));

		int actual_status_code = resp.getStatusCode();
		String body =resp.asString();

		Reporter.log("Get Request for Specific product is Successfull. With status code as : " + actual_status_code);

		List<String>list=resp.jsonPath().getList("data.name");
		Reporter.log(list.toString(),true);

		String name=resp.jsonPath().getString("data[0].name");	
		Reporter.log(name,true);
 
		//validation
		Assert.assertEquals(actual_status_code, 200); //valiadation is important. without validation assertion error occurs.
		Reporter.log("Get Request for Specific product is Successfull. with body as : " + body);

	}

/*
	public void TC_02GetMethod()
	{
		RequestSpecification resp_spec = given().baseUri(Config.BASE_URL);
		Response resp = resp_spec.when().get("products/43900");
		ValidatableResponse resp_valid = resp.then();


		resp_valid.assertThat().statusCode(200);
		resp_valid.assertThat().body();
		int actual_status_code = resp.getStatusCode();
		String body =resp.asString();

		Reporter.log("Get Request for Specific product is Successfull. With status code as : " + actual_status_code);

		List<String>list=resp.jsonPath().getList("data.type");
		Reporter.log(list.toString(),true);

		String name=resp.jsonPath().getString("data[0].type");	
		Reporter.log(name,true);

		Assert.assertEquals(actual_status_code, 200); //valiadation is important. without validation assertion error occurs.
		Reporter.log("Get Request for Specific product is Successfull. with body as : " + body);


	}

*/
}
