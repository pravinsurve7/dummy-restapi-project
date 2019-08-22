package apiTest;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.CommonApiMethods;
import io.restassured.response.Response;
import utils.ConfigProperties;

/**
 * The Class GetEmployeeTest.
 */
public class GetEmployeeTest {

	/** The base url. */
	String baseUrl = ConfigProperties.getKeyValue("API_BASE_URL");
	
	/** The get employees url. */
	String getEmployeesUrl = ConfigProperties.getKeyValue("API_GET_EMPLOYEES_URL");
	
	/** The get employee url. */
	String getEmployeeUrl = ConfigProperties.getKeyValue("API_GET_EMPLOYEE_URL");
	
	/** The headers. */
	HashMap<String, String> headers;
	
	/** The response. */
	Response response;
	
	/** The id. */
	String id;

	/**
	 * Before method.
	 */
	@BeforeMethod
	public void beforeMethod() {
		CommonApiMethods.setBaseUrl(baseUrl);
		// Set headers
		headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
	}

	/**
	 * Gets the employees test.
	 *
	 * @return the employees test
	 */
	@Test(description = "GET all employeees")
	public void getEmployeesTest() {
		// make a get call
		response = CommonApiMethods.GET(getEmployeesUrl, headers);

		Assert.assertEquals(response.statusCode(), 200, "Status not OK !");
		id = response.getBody().jsonPath().getString("[0].id");
		assertNotNull(id);
		assertNotNull(response.getBody().jsonPath().getString("[0].employee_name"));
		assertNotNull(response.getBody().jsonPath().getString("[0].employee_salary"));
		assertNotNull(response.getBody().jsonPath().getString("[0].employee_age"));
		assertNotNull(response.getBody().jsonPath().getString("[0].profile_image"));
	}

	/**
	 * Gets the employee test.
	 *
	 * @return the employee test
	 */
	@Test(description = "GET a particular employeee details", dependsOnMethods = "getEmployeesTest")
	public void getEmployeeTest() {
		String url = getEmployeeUrl.replace("{id}", id);

		// make a get call
		response = CommonApiMethods.GET(url, headers);

		Assert.assertEquals(response.statusCode(), 200, "Status not OK !");
		assertNotNull(response.getBody().jsonPath().getString("id"));
		assertNotNull(response.getBody().jsonPath().getString("employee_name"));
		assertNotNull(response.getBody().jsonPath().getString("employee_salary"));
		assertNotNull(response.getBody().jsonPath().getString("employee_age"));
		assertNotNull(response.getBody().jsonPath().getString("profile_image"));
	}

	/**
	 * No results found test.
	 */
	@Test(description = "No results found")
	public void noResultsFoundTest() {
		String url = getEmployeeUrl.replace("{id}", "1");

		// make a get call
		response = CommonApiMethods.GET(url, headers);

		Assert.assertEquals(response.statusCode(), 200, "Status not OK !");
		assertTrue(response.print().contains("false"));
	}
}
