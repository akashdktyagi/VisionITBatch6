package tc;

import utils.Config;

import static io.restassured.RestAssured.*;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TC_GetRequests 
{
	@Test
	public void t_01_health_check() {
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("/healthcheck").andReturn();

		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();

		Assert.assertEquals(actual_status_code, 200);
		//Reporter.log("Health Check is Successfull. with body as : " + body);
		System.out.println("Health Check is Successfull. with body as : " + body);

	}

	@Test
	public void t_02_get_request_for_product_with_id() {
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body = resp.asString();

		int actual_id = resp.jsonPath().getInt("id");
		Assert.assertEquals(actual_id, 9132294);

		//Reporter.log("Get Request for Product with Id as "+actual_id+" is Successfull. with body as : " + body);
		System.out.println("Get Request for Product with Id as "+actual_id+" is Successfull. with body as : " + body);

	}

	@Test
	public void t_03_get_request_for_product_with_id() {
		Response resp = given().baseUri("http://restapi.demoqa.com/").
				when().get("utilities/weather/city/Hyderabad").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body = resp.asString();

		String actual_city = resp.jsonPath().getString("City");
		Assert.assertEquals(actual_city, "Hyderabad");

		//Reporter.log("Get Request for Product with Id as "+actual_id+" is Successfull. with body as : " + body);
		System.out.println("Get Request for Product with Id as Hyderabad is Successfull. with body as : " + body);

	}

	@Test
	public void t_04_get_name_for_product_with_id()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body = resp.asString();
		String actual_name = resp.jsonPath().getString("name");
		Assert.assertEquals(actual_name, "Yamaha - P32D Pianica - Brown/White");

		System.out.println("get request for pdoduct with name as"+actual_name+"is successfully with body as"+body);
	}

	@Test
	public void t_05_get_id_name_type_price()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		//name
		String body = resp.asString();
		String actual_name = resp.jsonPath().getString("name");
		Assert.assertEquals(actual_name, "Yamaha - P32D Pianica - Brown/White");

		System.out.println("get request for pdoduct with name as"+actual_name+"is successfully with body as"+body);


		//id
		String body1 = resp.asString();

		int actual_id = resp.jsonPath().getInt("id");
		Assert.assertEquals(actual_id, 9132294);
		System.out.println("Get Request for Product with Id as "+actual_id+" is Successfull. with body as : " + body1);

		//type
		String body3 = resp.asString();
		String actual_type = resp.jsonPath().getString("type");
		Assert.assertEquals(actual_type, "HardGood");

		System.out.println("get request for pdoduct with name as"+actual_type+"is successfully with body as"+body3);
	}

	@Test
	public void t_06_get_price()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products/9132294").andReturn();
		float actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200, 59.99);

		ResponseBody body4 = resp.getBody();
		JsonPath jsonPathEvaluator = resp.jsonPath();
		System.out.println("get request for product with price"+jsonPathEvaluator);


		System.out.println("get request for product with price asis successfully with body as"+body4);
	}



	@Test
	public void t_07_get_price()
	{
		Response resp = given().baseUri(Config.BASE_URL).when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body5 = resp.asString();

		String actual_id = resp.jsonPath().getString("id");
		Assert.assertEquals(actual_id, "9132294");

		System.out.println("get request for product with id as"+actual_id+"is successfully with body as"+body5);



	}

	@Test
	public void t_08_get_containt()
	{
		Response resp = given().baseUri(Config.BASE_URL).when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body5 = resp.asString();
		String actual_id = resp.jsonPath().getString("id");
		Assert.assertEquals(actual_id, "9132294");
		System.out.println("get request for product with id as"+actual_id+"is successfully with body as"+body5);

	}

    @Test
	public void t_09_get_request_for_product_with_id() {
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("products/9132294").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body = resp.asString();

		String actual_city = resp.jsonPath().getString("x.categories[1].id");
		Assert.assertEquals(actual_city, null);

		System.out.println("Get Request for Product with Id  is Successfull. with body as : " + body);
	}

	@Test
	public void t_10_get_request_for_allproduct_sortby_highest_price_descending() {
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("/products?$sort[price]=-1").andReturn();


		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();

		Assert.assertEquals(actual_status_code, 200);
		System.out.println(("Get Request for Product with price sorted in descending order is Successfull. with body as : " + body));


	}

	@Test
	public void t_11_get_request_for_all_product_name()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("/products?$select[1]=name").andReturn();
		int actual_status_code = resp.getStatusCode();
		String body11 = resp.asString();

		Assert.assertEquals(actual_status_code, 200);
		System.out.println("get request for all product name"+body11);
	}

	@Test
	public void t_12_get_request_for_all_category_id()
	{
		Response resp = given().baseUri(Config.BASE_URL).
				when().get("/products?category.id=abcat0106004").andReturn();
		int actual_status_code = resp.getStatusCode();
		String body12 = resp.asString();

		Assert.assertEquals(actual_status_code, 200);
		System.out.print("get request for all category id"+body12);
		System.out.println("and result is "+actual_status_code);
	}



	@Test
	public void t_13_get_request_for_only_id()
	{
		Response resp = given().baseUri("http://localhost:3030/").
				when().get("/products?category.name=Coffee%20Pods").andReturn();
		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);
		String body12 = resp.asString();

		System.out.print("get request for all category id"+body12);
		System.out.println("and result is "+actual_status_code);


	}

	
	@Test
	public void t_0_get_request_for_product_with_id() {
		Response resp = given().baseUri("http://restapi.demoqa.com/").
				when().get("utilities/weather/city/Hyderabad").andReturn();

		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);

		String body = resp.asString();

		String actual_city = resp.jsonPath().getString("City");
		Assert.assertEquals(actual_city, "Hyderabad");

		System.out.println("Get Request for Product with Id as Hyderabad is Successfull. with body as : " + body);
		System.out.println("actual"+actual_city);
		System.out.println("actual_status_code"+actual_status_code);

	}
		
	@Test
	public void t_15_get_all_product_with_id() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products/9132294").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
	@Test
	public void t_16_get_all_product() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
	@Test
	public void t_17_Get_all_products_limit_to_1_result() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?$limit=1").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}

	@Test
	public void t_18_skip_to_the_25_001th_result() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?$skip=25000").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
	@Test
	public void t_19_sort_by_higest_price_descending() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?$sort[price]=-1").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
	@Test
	public void t_19_but_only_show_the_name_and_price_in_the_resul() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?$select[]=name&$select[]=price").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_20_Get_products_that_are_either() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?price[$in]=0.99&price[$in]=1.99").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_21_have_in_the_name_and_are_under() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?name[$like]=*star+wars*&price[$lt]=30").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_22_Get_products_less_than_or_equal_to() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?price[$lte]=1").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_23_Get_products_that_have_a_shipping_price_of_more_than() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?shipping[$gt]=10").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_24_Get_products_that_are_in_category_ID() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?category.id=abcat0106004").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_25_Get_products_that_are_in_category_name() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?category.name=Coffee%20Pods").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_26_Get_products_that_are_not_HardGood_or_Software() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?type[$nin][]=HardGood&type[$nin][]=Software").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	@Test
	public void t_27_Get_products_that_have_a_shipping_price_of_more_than_$10() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?shipping[$gt]=10").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
	@Test
	public void t_28_Get_products_of_type_HardGood() {
			Response resp = given().baseUri(Config.BASE_URL).
					when().get("/products?type=HardGood").andReturn();

			int actual_status_code = resp.getStatusCode();
			String body = resp.asString();

			Assert.assertEquals(actual_status_code, 200);
			System.out.println("Health Check is Successfull. with body as : " + body);
			System.out.println("the actual status code is "+actual_status_code);

		}
	
   @Test
	public void t_14_get_request_for_product_with_id()
	{
		Response resp = given().baseUri("http://localhost:3030/").
				when().get("/products").andReturn();
		int actual_status_code = resp.getStatusCode();
		Assert.assertEquals(actual_status_code, 200);
		String body12 = resp.asString();
		
		String actual_code= resp.jsonPath().getString("name");
		Assert.assertEquals(actual_code, null);

		System.out.print("get request for all category id"+body12);
		System.out.println("and result is "+actual_status_code);
		System.out.println("result"+actual_code);
    }

	@Test
	public void t_15_get_request_for_Get_products_that_are_in_category_ID_abcat0106004_TV_Mounts() 
	{
		Response resp = given().baseUri(Config.BASE_URL).
		when().get("/products?category.id=abcat0106004").andReturn();


		int actual_status_code = resp.getStatusCode();
		String body = resp.asString();

		Assert.assertEquals(actual_status_code, 200);
		System.out.println(("get_request_for Get products that are in category ID 'abcat0106004' (TV Mounts) is Successfull. with body as : " + body));
		System.out.println("status result is"+actual_status_code);
	}
	
	
	
	
	





	
	
	







}



