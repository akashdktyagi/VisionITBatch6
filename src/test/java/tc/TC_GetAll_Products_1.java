package tc;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;


import utils.Config;
 
public class TC_GetAll_Products_1 
{
	RequestSpecification _REQ_SPCE;
	Response RESP;

   @Test
   public void t_01_Get_All_products1_with_id()
   {
	   RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
	   RESP = _REQ_SPCE.when().get("/products?$limit=1");
	   RESP.then().statusCode(200);
	   
	   int actual_status_code= RESP.getStatusCode();
	   String body= RESP.asString();
	   
	   Assert.assertEquals(actual_status_code,200);
	   Reporter.log("products?$limit=1 is successful.with body as:" +body );
	   
   }
	
}
