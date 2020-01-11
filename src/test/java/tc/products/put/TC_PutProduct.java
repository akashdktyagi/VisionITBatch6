package tc.products.put;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_PutProduct
{
	@Test
	public void TC_01_PUT_Method()
	{
		String s= "Pornima1";
		
		// Passing Url 
		RequestSpecification request = given().baseUri("http://localhost:3030"); 
		
		// Passing Body
		JSONObject requestParams = new JSONObject(); // Body
		requestParams.put("name","Pornima"); 
		requestParams.put("type", "Soft Good");
		requestParams.put("upc", "12345676");
		requestParams.put("price",300.05);
		requestParams.put("description","This is a placeholder request for creating a new product.");
		requestParams.put("model","NP12345");

		//Passing Contains
		request.when().body(requestParams.toJSONString()).
		header("Content-Type","application/json");
		
		Response response= request.when().post("/products");

		Response response1= request.when().put("/Update/" +s);

		//printing reponse body
		System.out.println(response.body().asString());

		//validation
		int actual_status_code= response.getStatusCode();
		Assert.assertEquals(actual_status_code, 201);

		//fetching id from response
		String s1=response.jsonPath().get(s);
		System.out.println(s);
		Assert.assertEquals(actual_status_code, 200);
	
	
	}
}
