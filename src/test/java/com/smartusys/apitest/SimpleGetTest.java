package com.smartusys.apitest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {

	@Test
	public void GetWeatherDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the
		// method URL.
		// This will return the Response from the server. Store the response in
		// a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		int responseStatus = response.getStatusCode();
		System.out.println("Response Status Code is =>  " + responseStatus);
		Assert.assertEquals(responseStatus /* actual value */,
				200 /* expected value */, "Correct status code returned");

		String statusLine = response.getStatusLine();
		System.out.println("Response statusLine  is =>  " + statusLine);

		/*
		 * String headerse = response.getHeaders();
		 * System.out.println("Response statusLine  is =>  " + statusLine);
		 */

	}

	@Test
	public void GetWeatherDetailsInvalidCity() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/78789798798");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /* actual value */,
				400 /* expected value */, "Correct status code returned");
	}

	
	@Test
	public void GetWeatherStatusLine()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
		// Get the status line from the Response and store it in a variable called statusLine
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
	}
}
