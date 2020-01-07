package tc;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sun.tools.jxc.gen.config.Config;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Get_All_Products_With_API
{
	 
	
		//RequestSpecification _REQ_SPACE;
		Response RESP;
		
		   @Test
		   public void t_01_Get_product_with_ID()
		   
		   {
			   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
			   
			   Response RESP = _REQ_SPACE.when().get("/products/9132294");
			   RESP.then().statusCode(200);

			   int actual_status_code= RESP.getStatusCode();
			   String body= RESP.asString();

			   Assert.assertEquals(actual_status_code,200);
			   Reporter.log("/products/9132294 is successful.with body as:" +body );
	
		   }
	   
	   @Test
	   public void t_02_Get_All_products_with_id ()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products is successful.with body as:" +body );

	   }
	
	   @Test
	   public void t_03_Get_All_products_with_id ()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$limit=1");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("products?$limit=1 is successful.with body as:" +body );
		
	   } 
	   
	   @Test
	   public void t_04_Get_products_skip_to_the_25_001th()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$skip=25000");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?$skip=25000 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_05_Get_products_sort_by_highest_price_descending()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$sort[price]=-1");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?$sort[price]=-1 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_06_Get_products_sort_by_lowest_price_Ascending()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$sort[price]=1");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?$sort[price]=1 is successful.with body as:" +body );
		   

	   }
	   
	   @Test
	   public void t_07_Get_products_show_the_name_and_price()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?$select[]=name&$select[]=price");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?$select[]=name&$select[]=price is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_08_Get_products_type_HardGood()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?type=HardGood");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?type=HardGood is successful.with body as:" +body );
		   

	   }
	   
	   @Test
	   public void t_09_Get_products_less_than_or_equal_to()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("products?price[$lte]=1");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("products?price[$lte]=1 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_10_Get_products_star_wars()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?name[$like]=*star+wars*&price[$lt]=30");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?name[$like]=*star+wars*&price[$lt]=30 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_11_Get_products_either_$099_or_$199()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?price[$in]=0.99&price[$in]=1.99");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?price[$in]=0.99&price[$in]=1.99 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_12_Get_products_shipping_price_of_more_than_$10()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?shipping[$gt]=10");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?shipping[$gt]=10 is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_13_Get_products_not_HardGood_or_Software()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?type[$nin][]=HardGood&type[$nin][]=Software");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?type[$nin][]=HardGood&type[$nin][]=Software is successful.with body as:" +body );
		
	   }
	   
	   @Test
	   public void t_14_Get_products_not_HardGood_or_Software()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?type[$nin][]=HardGood&type[$nin][]=Software");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?type[$nin][]=HardGood&type[$nin][]=Software is successful.with body as:" +body );

	   }
	   
	   @Test
	   public void t_15_Get_products_category_name_Coffee_Pods()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?category.name=Coffee Pods");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?category.name=Coffee Pods is successful.with body as:" +body );

	   }
	   
	   @Test
	   public void t_16_Get_products_category_ID_abcat0106004()
	   
	   {
		   RequestSpecification _REQ_SPACE = given().baseUri("http://localhost:3030/");
		   
		   Response RESP = _REQ_SPACE.when().get("/products?category.id=abcat0106004");
		   RESP.then().statusCode(200);

		   int actual_status_code= RESP.getStatusCode();
		   String body= RESP.asString();

		   Assert.assertEquals(actual_status_code,200);
		   Reporter.log("/products?category.id=abcat0106004 is successful.with body as:" +body );
		
	   }
	   
}

