package tc.products.post;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import utils.Cmn;
import utils.Config;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
public class TC_PostProducts {

	@Test
	public void t_01_create_new_product() {
		//Create new Product and 
		//Check new product is created in the system by firing another get request with that new ID
		/*
		String body ="{\n" + 
				"	\"name\": \"mynewAwsomeProduct\",\n" + 
				"	\"type\": \"Hard Good\",\n" + 
				"	\"upc\": \"12345676\",\n" + 
				"	\"price\": 1000,\n" + 
				"	\"description\": \"This is a placeholder request for creating a new product.\",\n" + 
				"	\"model\": \"NP12345\"\n" + 
				"}";
				
				*/
		
		//Body
		JSONObject body_json = new JSONObject();
		String unique_product_name = Cmn.GetRandomString(5);  
		body_json.put("name", unique_product_name);
		body_json.put("type", "Hard Good");
		body_json.put("upc", "12345676");
		body_json.put("price", "100");
		body_json.put("description", "Random Description from Automation Script");
		body_json.put("model", "NP12345");

		//Headers
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Content-Type", "application/json");

		
		RequestSpecification req_spec = given().baseUri(Config.BASE_URL);
		Response resp = req_spec.headers(headers).body(body_json).when().post("/products/");
		ValidatableResponse valid_resp = resp.then();
		
		//Checkpoint 1
		valid_resp.assertThat().statusCode(201);
		
		//Check point 2
		valid_resp.assertThat().body(containsString(unique_product_name),containsString("Hard Good"));
		
		//Check Point 3
		//Get ID
		String id = resp.jsonPath().get("id");
		//invoke a Get Request
		req_spec.get("/products/" + id).then().
		assertThat().
		statusCode(200).
		and().
		body(containsString(unique_product_name));
		
	}
	
	@Test
	public void t_02_validate_error_message_price_not_integer() {
		//enter price as String, check the error message
	}
	
	@Test //Ruplai
	public void t_03_validate_price_is_negative() {
		//Send price as negative-this actually is a defect. 
		//This test case will always fail because API accepts negative number as price
	}
	
	@Test //madhr
	public void t_04_validate_duplicate_product_is_allowed() {
		//Fire post request twice and every time a new product is created
	}

	@Test
	public void t_05_validate_mandatory_fields_in_request_body() {
		//Validate if name,upc, price,description,model are not send
		//Then API response throws 400 status code and the error message
	}
	

}
