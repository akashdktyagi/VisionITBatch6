package tc;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Config;

public class Get_Products
{
	RequestSpecification _REQ_SPCE;
	Response RESP;

	@Test
	public void TC_0_health_check() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/healthcheck").andReturn();
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200);
		Reporter.log("Health Check is Successfull. with body as : " + body); //print body
	}
	@Test
	public void TC_01_get_request_for_product_with_id() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("products/9132294").andReturn(); //hit product
		
		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();
		
		Assert.assertEquals(actual_status_code, 200); //checks code(validation)
		Reporter.log("Get Request for Product with Id is Successfull. with body as : " + body);
	}


	@Test
	public void TC_02_Get_all_products()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products is successful.with body as:" +body );

	}


	@Test
	public void TC_03_Get_all_products_limit_to_1_result()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?$limit=1");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("Get all products, limit to 1 result is successful.with body as:" +body );

	}

	@Test
	public void TC_04_Get_all_products_25_001th_result()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?$skip=25000");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?$skip=25000 is successful.with body as:" +body );

	}

	@Test
	public void TC_05_Get_all_products_sort_by_highest_price_descending()
	{

		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?$sort[price]=-1");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?$sort[price]=-1 is successful.with body as:" +body );

	}

	@Test
	public void TC_06_Get_all_products_sort_by_lowest_price_ascending()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?$sort[price]=1");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?$sort[price]=1 is successful.with body as:" +body );

	}

	@Test
	public void TC_07_Get_all_products_only_show_name_and_price_in_result()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?$select[]=name&$select[]=price");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?$select[]=name&$select[]=price is successful.with body as:" +body );

	}

	@Test
	public void TC_08_Get_products_of_type_HardGood()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?type=HardGood");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?type=HardGood is successful.with body as:" +body );

	}

	@Test
	public void TC_09_Get_products_less_than_or_equal_to_$1()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("products?price[$lte]=1");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("products?price[$lte]=1 is successful.with body as:" +body );

	}

	@Test
	public void TC_010_Get_products_having_starwars_in_the_name_and_are_under_$30()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?name[$like]=*star+wars*&price[$lt]=30");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?name[$like]=*star+wars*&price[$lt]=30 is successful.with body as:" +body );

	}

	@Test
	public void TC_011_Get_products_that_are_either_Specific_range()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?price[$in]=0.99&price[$in]=1.99");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?price[$in]=0.99&price[$in]=1.99 is successful.with body as:" +body );

	}

	@Test
	public void TC_012_Get_products_that_have_a_shipping_price_of_more_than_$10()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?shipping[$gt]=10");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?shipping[$gt]=10 is successful.with body as:" +body );

	}

	@Test
	public void TC_013_Get_products_that_are_not_HardGood_or_Software()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?type[$nin][]=HardGood&type[$nin][]=Software");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?type[$nin][]=HardGood&type[$nin][]=Software is successful.with body as:" +body );

	}

	@Test
	public void TC_014_Get_products_that_are_in_category_name_Coffee_Pods()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?category.name=Coffee Pods");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?category.name=Coffee Pods is successful.with body as:" +body );

	}


	@Test
	public void TC_015Get_product_that_are_in_category_ID_abcat0106004_TV_Mounts()
	{
		RequestSpecification _REQ_SPCE = given().baseUri(Config.BASE_URL);
		RESP = _REQ_SPCE.when().get("/products?category.id=abcat0106004");
		RESP.then().statusCode(200);

		int actual_status_code= RESP.getStatusCode();
		String body= RESP.asString();

		Assert.assertEquals(actual_status_code,200);
		Reporter.log("/products?category.id=abcat0106004 is successful.with body as:" +body );

	}

}
