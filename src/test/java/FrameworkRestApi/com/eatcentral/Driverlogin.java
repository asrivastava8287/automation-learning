package FrameworkRestApi.com.eatcentral;


import java.util.Hashtable;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkRestApi.com.setup.Apisetup;
import FrameworkRestApi.com.utility.DProviderClass;

import io.restassured.response.Response;


public class Driverlogin extends Apisetup {

	String apitoken;
	String expectedorderstatus;
	
	@Test(dataProviderClass = DProviderClass.class,dataProvider="dp",priority = 0)
	public void checkdriverloginwithvalidcredentials(Hashtable<String, String> data) {
		
		JSONObject json = new JSONObject();
		json.put("email", data.get("email"));
		json.put("password", data.get("password"));
		
		Response response = setspecification().body(json.toString()).post("login");
		//response.prettyPrint();
		System.out.println(response.statusCode());
		
		String message = response.jsonPath().get("message");
		
		
		String drivername = response.jsonPath().get("payload.data.name");
		
		apitoken = response.jsonPath().get("payload.data.api_token");
		
		
		Assert.assertEquals(message,data.get("message"));
		Assert.assertEquals(drivername,data.get("drivername"));
		Assert.assertEquals(apitoken, data.get("apitoken"));
	}
	
	/*@Test(priority = 1)
	public void drivermanageorders() {
		
		JSONObject json = new JSONObject();
		json.put("api_token", apitoken );
		
		Response response = setspecification().body(json.toString()).post("orders");
		int lengthofresponsearray = response.jsonPath().get("payload.data.size()");

		System.out.println("before loop starts");
		
		for(int i = 0; i<lengthofresponsearray; i++) {
			System.out.println("loop start" + i);
			int myorderid = response.path("payload.data["+i+"].id");
			System.out.println("loopppp................" + i);
			
			System.out.println(myorderid);
			if(myorderid == 268 ) {
				expectedorderstatus = response.path("payload.data["+i+"].order_status_name");
			}
			break;
		}
		
		System.out.println(expectedorderstatus);
		Assert.assertEquals("completed", expectedorderstatus);
		
		//response.prettyPrint();
		
		
	}
	    */
	
}
