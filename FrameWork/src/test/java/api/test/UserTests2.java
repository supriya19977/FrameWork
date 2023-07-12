package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Locale;
import java.util.ResourceBundle;

import io.restassured.response.Response.*; 
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class UserTests2 {

	Faker faker;
	User userPayload;

	public Logger logger;
	@BeforeClass
	public void setupData() {
		faker= new Faker();	
		userPayload=new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		//logs
		logger=LogManager.getLogger(this.getClass());

	}

	//create user 

	@Test(priority=1)
	public void testPostUser() {

		logger.info("********************** creating user *************");
		Response response=UserEndpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info( "*************** user is created **************");
		System.out.println("user is created");
	}
	//get userdata

	@Test(priority=2)

	public void testGetUserByName() {

		logger.info("********************** get user *************");
		Response response=UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************** get user *************");
	}
	//update data using payload
	@Test
	public void testUpdateUserByName() {

//		ResourceBundle bundle = ResourceBundle.getBundle("routes", Locale.US);
		logger.info("********************** update user *************");
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndpoints2.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		//	   response.statusCode();
		//	   response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********************** update user *************");
		//checking data after update

		Response responseAfterupdate=UserEndpoints2.readUser(this.userPayload.getUsername());
		//	   response.then().log().all();
		//	   response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);	   

	}
	//@Test
	//public void testDeleteUserByName() {
	//	Response response=UserEndpoints.deleteUser(this.userPayload.getUsername());
	//	Assert.assertEquals(response.getStatusCode(), 200);
	//}
}
