package com.RestAssuredAPI;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.RestAssured.constants.Jsonpaths;
import com.RestAssured.constants.ReqresEndpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class GetUsers extends BaseReqres {
	
	@Test
	public void testUsers() {
		
		String userpayload = "{\r\n"
				+ "    \"name\": \"John\",\r\n"
				+ "    \"job\": \"Journalist\"\r\n"
				+ "}";
		
/*		RestAssured.baseURI = "https://reqres.in";
		
		RestAssured.given().baseUri(ReqresEndpoints.baseUrl).log().all().accept(ContentType.JSON).when().get(ReqresEndpoints.usersAPI).then().statusCode(200).assertThat().body("data[0].id", equalTo(7)).body("data[1].id", equalTo(8)).body("data[2].id", equalTo(9)).body("data[3].id", equalTo(10)).body("data[4].id", equalTo(11)).body("data[5].id", equalTo(12)).log().all();
		
		Response response = RestAssured.given().baseUri(ReqresEndpoints.baseUrl).log().all().accept(ContentType.JSON).contentType(ContentType.JSON).body(userpayload).when().post(ReqresEndpoints.adduserAPI);
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.asString().contains("John"));
		
		System.out.println(response.jsonPath().get("name"));  */
		
		RestAssured.given().spec(reqResDir).when().get(ReqresEndpoints.usersAPI).then().statusCode(200).assertThat().body("data[0].id", equalTo(7)).body("data[1].id", equalTo(8)).body("data[2].id", equalTo(9)).body("data[3].id", equalTo(10)).body("data[4].id", equalTo(11)).body("data[5].id", equalTo(12)).body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
		Response res = RestAssured.given().spec(reqResAdd).body(userpayload).when().post(ReqresEndpoints.adduserAPI);
		
		int status = res.getStatusCode();
		
		assertThat(status, equalTo(201));
		
		logReqres.debug(res.getStatusCode());
		
		logReqres.debug(res.asString().contains("John"));
		
		logReqres.debug(res.jsonPath().get("name"));
		
	}

}