Feature: End to End Test for Currency Exchange Rates

Description: The purpose of these tests to cover End to End Tests for Currency Exchange Rate API which gives
exchange rate w.r.t Euro

Latest Foreign Exchange Rate URL : https://api.ratesapi.io/api/latest

Scenario: User Tests the currency Rate in Indian Rupees (INR)

	Given The API is available 
	When Search for Latest Foreign Exchange rates
	Then Get Success status in the response
	Then Get Exchange Rate in the response
	When Search with incorrect/incomplete API
	Then Error message displayed in response
	When Search Exchange rates for Specific Date
	Then Get Success status in the response
	Then Get Exchange Rate of the Specific Date in response
	When Search Exchange rates for Future Date
	Then Get Success status in the response
	Then Get Latest Exchange Rate in response
	
