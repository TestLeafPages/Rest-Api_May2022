package mock;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LearnTemp {
	
	//java -jar wiremock-jre8-standalone-2.33.1.jar --global-response-templating
	
	@Test
	public void getTestLeafCourse() {
		RestAssured.baseURI = "http://localhost:8080/testleaf/traning/course";
		Response response = RestAssured 
				.given()
				.queryParam("course_name", "Api Service")
				.queryParam("type", "Online")
				.get();
		response.prettyPrint();	
	}
	

}
