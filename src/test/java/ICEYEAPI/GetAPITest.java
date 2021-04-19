package ICEYEAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfig.APIPath;
import apiConfig.QueryParams;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAPITest extends BaseTest {

	QueryParams param = new QueryParams();

	@Test(priority = 1)
	public void getAPITest() {

		Response resp = 
				RestAssured.given()
				.queryParams(param.defaultqueryParams())
				.when().get(APIPath.GET_DATA_FOR_ASTERIODS);


		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		Assert.assertEquals(200, resp.getStatusCode());

		JsonPath js = new JsonPath(resp.getBody().asString());
		Assert.assertTrue(js.getString("signature.source").contains("Close Approach Data API"));
		Assert.assertTrue(js.getString("fields[10]").equals("body"));

		APIVerification.responseTimeValidation(resp);
		test.log(LogStatus.INFO,"Test is ended" );


	}


	@Test(priority = 2)
	public void getAPITest_date() {

		Response resp = 
				RestAssured.given()
				.queryParams(param.queryParamsdate())
				.when().get(APIPath.GET_DATA_FOR_ASTERIODS);


		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		Assert.assertEquals(200, resp.getStatusCode());

		JsonPath js = new JsonPath(resp.getBody().asString());
		Assert.assertTrue(js.getString("signature.source").contains("Close Approach Data API"));
		Assert.assertFalse(js.getString("fields[10]").equals("body"));
		APIVerification.responseTimeValidation(resp);
		test.log(LogStatus.INFO,"Test is ended" );


	}
}
