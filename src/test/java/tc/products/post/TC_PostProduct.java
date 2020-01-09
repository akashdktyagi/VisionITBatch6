package tc.products.post;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Config;

public class TC_PostProduct 
{
	@Test
	public void TC_01_POST_Method()
	{
		// Passing Url 
		RequestSpecification request = given().baseUri("http://localhost:3030"); 
		
		// Passing Body
		JSONObject requestParams = new JSONObject(); // Body
		requestParams.put( "name","Pornima"); 
		requestParams.put("type", "Soft Good");
		requestParams.put(  "upc", "12345676");
		requestParams.put( "price",205.05);
		requestParams.put("description","This is a placeholder request for creating a new product.");
		requestParams.put("model","NP12345");

		//Passing Contains
		request.when().body(requestParams.toJSONString()).
		header("Content-Type","application/json");

		//Creating product
		Response response= request.when().post("/products");

		//printing reponse body
		System.out.println(response.body().asString());

		//validation
		int actual_status_code= response.getStatusCode();
		Assert.assertEquals(actual_status_code, 201);

		//fetching id from response
		int id=response.jsonPath().get("id");
		System.out.println(id);




		//String body= response.asString();

		// Assert.assertEquals(actual_status_code,201);
		// Reporter.log("product successful.with body as:" +body );


		/*int statusCode = response.getStatusCode(); //
	 	String body = response.asString();
	 	Assert.assertEquals(statusCode, 200);*/

		//System.out.println("Response body: " + response.body().asString());
		//Reporter.log("Product creation is Successfull. with body as : " + statusCode); //print body

		//String successCode = response.jsonPath().get("products/9999687");
		//Assert.assertEquals(successCode, 200);


		/*int statusCode = response.getStatusCode();
	  	System.out.println("The status code recieved: " + statusCode);

 	 	System.out.println("Response body: " + response.body().asString());*/

	}

}
