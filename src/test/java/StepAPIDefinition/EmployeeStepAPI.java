package StepAPIDefinition;

import org.hamcrest.Matchers;

import BaseAPI.BaseAPIClass;
import ContantLayer.EmployeeEndpoints;
import ServiceLayer.EmployeeService;
import UtilsLayer.UtilsClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class EmployeeStepAPI extends BaseAPIClass {
	private static RequestSpecification httpRequest;
	private static Response response;
	private static String id;
	private static ValidatableResponse validatableResponse;

	@Given("get RequestSpecification object")
	public void get_request_specification_object() {
		httpRequest = BaseAPIClass.setUp();
	}

	@Given("user set request header")
	public void user_set_request_header() {
		httpRequest.headers(UtilsClass.addRequestHeader());

	}

	@Given("user attach request body for {string} Request")
	public void user_attach_request_body_for_request(String requestBodyType) throws Exception {

		if (requestBodyType.equalsIgnoreCase("POST")) {
			httpRequest.body(EmployeeService.getPostRequestBody());
		} else if (requestBodyType.equalsIgnoreCase("PUT")) {
			httpRequest.body(EmployeeService.getPutRequestBody());
		}

	}

	@When("user select HTTP {string} Request")
	public void user_select_http_request(String httpRequestType) {

		if (httpRequestType.equalsIgnoreCase("POST")) {
			response = httpRequest.when().post(EmployeeEndpoints.POSTEndPoint);
		} else if (httpRequestType.equalsIgnoreCase("GET")) {
			response = httpRequest.when().get(EmployeeEndpoints.GETEndPoint + id);
		} else if (httpRequestType.equalsIgnoreCase("PUT")) {
			response = httpRequest.when().put(EmployeeEndpoints.PutEndPoint + id);
		} else if (httpRequestType.equalsIgnoreCase("DELETE")) {
			response = httpRequest.when().delete(EmployeeEndpoints.DLETEEndPoint + id);
		}
	}

	@Then("user capture the employee id")
	public void user_capture_the_employee_id() {
		id = response.getBody().jsonPath().getString("id");

	}

	@Then("user validate status code as {int}")
	public void user_validate_status_code_as(Integer code) {
		validatableResponse = response.then().assertThat().statusCode(code);

	}

	@Then("user validate status line as {string}")
	public void user_validate_status_line_as(String line) {
		validatableResponse.statusLine(Matchers.containsString(line));
	}

	@Then("user validate response time should be below {int} ms")
	public void user_validate_response_time_should_be_below_ms(Integer time) {
		validatableResponse.time(Matchers.lessThan((long) time));
	}

	@Then("user validate {string} , {string} and {string} keys")
	public void user_validate_and_keys(String fnamekey, String addressKey, String emailKey) {

		validatableResponse.body("", Matchers.hasKey(fnamekey)).and().body("", Matchers.hasKey(addressKey)).and()
				.body("", Matchers.hasKey(emailKey));

	}

	@Then("user validate firstname, lastname, address values")
	public void user_validate_firstname_lastname_address_values() {
		String expectedFName = EmployeeService.employee.getFirstname();
		String expectedLName = EmployeeService.employee.getLastname();
		String expectedAddress = EmployeeService.employee.getAddress();

		validatableResponse.body("firstname", Matchers.equalTo(expectedFName)).and()
				.body("lastname", Matchers.equalTo(expectedLName)).and()
				.body("address", Matchers.equalTo(expectedAddress));

	}

	@Then("user generate the response logs")
	public void user_generate_the_response_logs() {
		validatableResponse.log().all();
	}
}
