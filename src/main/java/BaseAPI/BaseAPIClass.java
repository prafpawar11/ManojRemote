package BaseAPI;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseAPIClass {

	
	public static RequestSpecification setUp()
	{
		RestAssured.baseURI="http://localhost:9191";
		
		return RestAssured.given().log().all();
	}
	
	
	
	
}
