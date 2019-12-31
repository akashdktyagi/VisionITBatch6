package tc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Trial 
{
	public static void main(String[] args) 
	{
		
		// I hit "http://localhost:3030/products/9132294
		// API response code will be 200
		// Then i get json response with body with the given product
		
		//******1st way****** (preferred)
		
		//(if not using cucumber)( written in single statement code i.e continuous_without diving)
		String baseUri = "http://localhost:3030";
		given().baseUri(baseUri).
		when().get("/products/9132294").
		then().assertThat().statusCode(200).
		and().body("id", equalTo(9132294));
		
	 	
		//(if using cucumber)(using cucumber you need to divide given, when, then)
		//****2nd Way*****
		RequestSpecification _REQ_SPEC = given().baseUri(baseUri);
		Response _RESP = _REQ_SPEC.when().get("/products/9132294");
	    ValidatableResponse _VALIDATABLE_RESP = _RESP.then();	
	    _VALIDATABLE_RESP.assertThat().body("id", equalTo(9132294));  // need to import static org.hamcrest.Matchers.*;
	    
		// Above Both the methods are same
	}
	

}
