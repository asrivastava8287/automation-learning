package FrameworkRestApi.com.setup;

import static io.restassured.RestAssured.*;


import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeSuite;

import FrameworkRestApi.com.utility.Configproperty;
import FrameworkRestApi.com.utility.ExcelReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Apisetup {
	
	protected static Configproperty config;
	
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/ExcelReader/EatCentralTestData.xlsx");

	
	@BeforeSuite
	public void apiengine() {
		
		config = ConfigFactory.create(Configproperty.class);
		
		 RestAssured.baseURI = config.baseuri();
		 RestAssured.basePath = config.basepath();
	}

	public RequestSpecification setspecification() {
		
		RequestSpecification spec = given().contentType(ContentType.JSON);
		return spec;
	}
	
}
