package api.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	
	public static Logger logger;
	
	@Test(priority=1,dataProvider="AllData",dataProviderClass=DataProviders.class)
	public void testCreateUser( String UserId,String UserName,String fname,String lname,String email,String pwd,String phone)
	{
		
		user userPayload = new user();

		userPayload.setId(Integer.parseInt(UserId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		logger = LogManager.getLogger("RestAssuredAutomationFramework_DDtest");

		Response response = api.payload.userEndPoints.createUser(userPayload);
		

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//log
		logger.info("DD Create User executed.");
	} 
	
	
	@Test(priority=2,dataProvider="UserNameData",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName)
	{

		Response response = api.payload.userEndPoints.DeleteUser(userName);

		System.out.println("Delete User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		
		//log
				logger.info("DD Delete User executed.");


	}

}
