package tc.products.get;

import org.testng.annotations.Test;

public class TC_PostProducts {

	@Test
	public void t_01_create_new_product() {
		//Create new Product and 
		//Check new product is created in the system by firing another get request with that new ID
	}
	
	@Test
	public void t_02_validate_error_message_price_not_integer() {
		//enter price as String, check the error message
	}
	
	@Test
	public void t_03_validate_price_is_negative() {
		//Send price as negative-this actually is a defect. 
		//This test case will always fail because API accepts negative number as price
	}
	
	@Test
	public void t_04_validate_duplicate_product_is_allowed() {
		//Fire post request twice and every time a new product is created
	}

	
	@Test
	public void t_05_validate_mandatory_fields_in_request_body() {
		//Validate if name,upc, price,description,model are not send
		//Then API response throws 400 status code and the error message
	}
	
	@Test
	public void t_06_validate_mandatory_fields_in_request_body() {
		//Validate if name,upc, price,description,model are not send
		//Then API response throws 400 status code and the error message
	}
	
}
