package tc;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sun.tools.jxc.gen.config.Config;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Get_Products_Limit 
{
	 
	
		//RequestSpecification _REQ_SPACE;
		Response RESP;

	   @Test
	   public void t_01_Get_All_products1_with_id ()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$limit=1");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("products?$limit=1 is successful.with body as:" +body );

	   }
	


}

