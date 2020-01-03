package tc;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.Config;

import static io.restassured.RestAssured.*;
public class TC_GetRequests {

	@Test
	public void t_01_health_check() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/healthcheck").andReturn();
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Health Check is Successfull. with body as : " + body);
		System.out.println("Response Body is: " + body.toString());
	
		
	}
	
	@Test
	public void t_02_get_request_for_product_with_id() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("products/9132294").andReturn();
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Get Request for Product with Id is Successfull. with body as : " + body);
		Reporter.log("Get Request for Product with status code as : " +actual_status_code);
	
		
	}
	
		
	@Test
	public void t_03_get_request_for_allproduct_sortby_highest_price_descending() {
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$sort[price]=-1").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Get Request for Product with price sorted in descending order is Successfull. with body as : " + body);
			
		
	}
	@Test
	public void t_04_get_request_for_Get_all_products_limit_to_1_result() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$limit=1").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for_Get_all_products_limit_to_1_result is Successfull. with body as : " + body);
	}
	@Test
	public void t_05_get_request_for_Get_all_products_skip_to_the_25001th_result() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$skip=25000").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for_Get_all_products_skip_to_the_25001th_result is Successfull. with body as : " + body);
	}
	@Test
	public void t_06_get_request_for_Get_all_products_sort_by_lowest_price_ascending() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$sort[price]=-1").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get all products, sort by lowest price (ascending) is Successfull. with body as : " + body);
	}
	@Test
	public void t_07_get_request_for_Get_all_products_but_only_show_the_name_and_price_in_the_result() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?$select[]=name&$select[]=price").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get all products, but only show the name and price in the result is Successfull. with body as : " + body);
	}
	@Test
	public void t_08_get_request_for_Get_products_of_type_HardGood() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?type=HardGood").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products of type HardGood is Successfull. with body as : " + body);
	}
	@Test
	public void t_09_get_request_for_Get_products_less_than_or_equal_to_$1() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?price[$lte]=1").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products less than or equal to $1.00 is Successfull. with body as : " + body);
	}
	@Test
	public void t_10_get_request_for_Get_products_that_have_star_wars_in_the_name_and_are_under_$30() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?name[$like]=*star+wars*&price[$lt]=30").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that have 'star wars' in the name and are under $30 is Successfull. with body as : " + body);
	}
	@Test
	public void t_11_get_request_for_Get_products_that_are_either_in_Specified_range() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?price[$in]=0.99&price[$in]=1.99").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that are either $0.99 or $1.99 is Successfull. with body as : " + body);
	}
	@Test
	public void t_12_get_request_for_Get_products_that_have_a_shipping_price_of_more_than_$10() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?shipping[$gt]=10").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that have a shipping price of more than $10 is Successfull. with body as : " + body);
	}
	@Test
	public void t_13_get_request_for_Get_products_that_are_not_HardGood_or_Software() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?type[$nin][]=HardGood&type[$nin][]=Software").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that are not HardGood or Software is Successfull. with body as : " + body);
	}
	@Test
	public void t_14_get_request_for_Get_products_that_are_in_category_name_Coffee_Pods() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?category.name=Coffee%20Pods").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that are in category name 'Coffee Pods' is Successfull. with body as : " + body);
	}
	@Test
	public void t_15_get_request_for_Get_products_that_are_in_category_ID_abcat0106004_TV_Mounts() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?category.id=abcat0106004").andReturn();
	
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("get_request_for Get products that are in category ID 'abcat0106004' (TV Mounts) is Successfull. with body as : " + body);
	}
	
}
