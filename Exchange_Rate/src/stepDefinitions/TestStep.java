package runner;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestStep {

	String latestValue = null;
	@Given("^The API is available$")
	public void LatestAPI() {

		RestAssured.baseURI = "https://api.ratesapi.io/api/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("latest");
			Assert.assertEquals(200, response.getStatusCode());

	}

	@When("^Search for Latest Foreign Exchange rates$")
	public void SearchLatestExchangeRate() {

		RestAssured.baseURI = "https://api.ratesapi.io/api/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("latest");
		String jsonString = response.asString();
		Assert.assertEquals(200, response.getStatusCode());
	}
	 @Then("^Get Success status in the response$")
	 public void GetResponseLatestExchangeRate() {
	 RestAssured.baseURI = "https://api.ratesapi.io/api/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("latest");
		Assert.assertEquals(200, response.getStatusCode());
	 }
	 
	 @Then("^Get Exchange Rate in the response$")
	 public void GetLatestExchangeRate() {
	 RestAssured.baseURI = "https://api.ratesapi.io/api/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("latest");
		String jsonString = response.asString();
		 List<Map<String, String>> latestValue = JsonPath.from(jsonString).get("INR");
		Assert.assertTrue(jsonString.contains("INR"));
		 
				 
	 }
	 @When("^Search with incorrect/incomplete API$")
		public void SearchWithIncorrectAPI() {

			RestAssured.baseURI = "https://api.ratesapi.io/ap";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("latest");
			String jsonString = response.asString();
			Assert.assertTrue(jsonString.contains("Error"));
	 }
	 
	 @Then("^Error message displayed in response$")
		public void ErrorMessageInResponse() {

			RestAssured.baseURI = "https://api.ratesapi.io/ap";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("latest");
			String jsonString = response.asString();
			Assert.assertTrue(jsonString.contains("Error"));
	 }
	 
	 @When("^Search Exchange rates for Specific Date$")
		public void SearchExchangeRateForSpecificDate() {

			RestAssured.baseURI = "https://api.ratesapi.io/api/";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("2020-11-11");
			String jsonString = response.asString();
			Assert.assertEquals(200, response.getStatusCode());
		}
		 @Then("^Get Success status in the response for specific date$")
		 public void GetResponseExchangeRateOfSpecificDate() {
		 RestAssured.baseURI = "https://api.ratesapi.io/api/";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("2020-11-11");
			Assert.assertEquals(200, response.getStatusCode());
		 }
		 
		 @Then("^Get Exchange Rate of the Specific Date in response$")
		 public void GetExchangeRateOfSpecificDate() {
		 RestAssured.baseURI = "https://api.ratesapi.io/api/";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("2021-11-11");
			String jsonString = response.asString();
			Assert.assertTrue(jsonString.contains("INR"));
			}
		 
		 @When("^Search Exchange rates for Future Date$")
			public void SearchExchangeRateForFutureDate() {

				RestAssured.baseURI = "https://api.ratesapi.io/api/";
				RequestSpecification request = RestAssured.given();
				Response response = request.get("2021-11-11");
				String jsonString = response.asString();
				Assert.assertEquals(200, response.getStatusCode());
			}
			 @Then("^Get Success status in the response for Future Date$")
			 public void GetResponseExchangeRateOfFutureDate() {
			 RestAssured.baseURI = "https://api.ratesapi.io/api/";
				RequestSpecification request = RestAssured.given();
				Response response = request.get("2021-11-11");
				Assert.assertEquals(200, response.getStatusCode());
			 }
			 
			 @Then("^Get Latest Exchange Rate in response for Future Date$")
			 public void GetExchangeRateOfFutureDate() {
			 RestAssured.baseURI = "https://api.ratesapi.io/api/";
				RequestSpecification request = RestAssured.given();
				Response response = request.get("2021-11-11");
				String jsonString = response.asString();
				 List<Map<String, String>> currentValue = JsonPath.from(jsonString).get("INR");
				 if (latestValue.equals(currentValue)) {
					 Assert.assertEquals(200, response.getStatusCode());
				 }
				}

			
}
