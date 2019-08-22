package api;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CommonApiMethods {
	
	public static void setBaseUrl(String url) {
		RestAssured.baseURI = url;
	}
	
	public static Response GET(String url, HashMap<String, String> headers) {
		Response response = RestAssured.given().headers(headers).get(url).andReturn();
		return response;
	}

	public static Response POST(String url, HashMap<String, String> headers, String body) {
		Response response = RestAssured.given().headers(headers).body(body).post(url).andReturn();
		return response;
	}
}
