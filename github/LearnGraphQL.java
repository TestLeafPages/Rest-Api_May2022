package github;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnGraphQL {
	
	String query = "{\r\n" + 
			"  viewer {\r\n" + 
			"    login\r\n" + 
			"  }\r\n" + 
			"  repository(name: \"Leaftaps\", owner: \"SarathTL\") {\r\n" + 
			"    id\r\n" + 
			"    name\r\n" + 
			"    owner {\r\n" + 
			"      url\r\n" + 
			"      ... on Organization {\r\n" + 
			"        id\r\n" + 
			"        email\r\n" + 
			"      }\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"}";
	
	@Test
	public void getRepoInfo() {
		RestAssured.baseURI = "https://api.github.com/graphql";
		Response response = RestAssured 
				.given()
				.header("Authorization","Bearer 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")
				.contentType(ContentType.JSON)
				.body(getQuery())
				.post();
		response.prettyPrint();	
	}
	
	
	private String getQuery() {
		
		JSONObject obj = new JSONObject();
		obj.put("query", query);
		return obj.toString();
		
	}
	
	
	
	
	
	
	
	
	

}
