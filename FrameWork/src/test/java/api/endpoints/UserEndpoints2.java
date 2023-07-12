package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Response.*;
//user endpoints.java
// created for perform create, read, update, delete request user apis

public class UserEndpoints2 {
	
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle .getBundle("routes");
		return routes;
	} 
	
	

  public static   Response createUser(User payload)
{
	  
	 String post_url= getURL().getString("post_url");
	 
	  Response response=given()
	    .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
	     .body(payload)
	.when()
	       .post(post_url);
	
	return response;
}

  public static Response  readUser(String UserName)
  {
	  
	 // String get_url= getURL().getString("get_url");
	  
	  
	  String get_url= "https://petstore.swagger.io/v2/user/{username}";
	  Response response=given()
  	    .pathParam("username", "Ganesh")
  	.when()
  	       .get(get_url);
  	return response;
  	
  }
  
  public static Response  updateUser(String UserName ,User payload)
  {
	  
	  String update_url= getURL().getString("update_url");
	  Response response=given()
		.contentType(ContentType.JSON)	
		.accept(ContentType.JSON)
  	    .pathParam("username", UserName)
  	    .body(payload)
  	.when()
  	       .put(update_url);
  	return response;
  	
}
  public static Response  deleteUser(String UserName)
  {
	  
	  String delete_url= getURL().getString("delete_url");
	  Response response=given()
  	       .pathParam("username", UserName)
  	.when()
  	       .delete(delete_url);
  	return response;
  	
  }
}