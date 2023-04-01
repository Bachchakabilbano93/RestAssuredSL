package com.RestAssuredAPI;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.RestAssured.reqrespojos.ResponseData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import io.restassured.path.json.JsonPath;

public class RestGson {
	
	Gson prj = new Gson();
	
	String userList = "{\r\n"
			+ "  \"data\": [\r\n"
			+ "        {\r\n"
			+ "            \"id\": 7,\r\n"
			+ "            \"email\": \"michael.lawson@reqres.in\",\r\n"
			+ "            \"first_name\": \"Michael\",\r\n"
			+ "            \"last_name\": \"Lawson\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 8,\r\n"
			+ "            \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
			+ "            \"first_name\": \"Lindsay\",\r\n"
			+ "            \"last_name\": \"Ferguson\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 9,\r\n"
			+ "            \"email\": \"tobias.funke@reqres.in\",\r\n"
			+ "            \"first_name\": \"Tobias\",\r\n"
			+ "            \"last_name\": \"Funke\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 10,\r\n"
			+ "            \"email\": \"byron.fields@reqres.in\",\r\n"
			+ "            \"first_name\": \"Byron\",\r\n"
			+ "            \"last_name\": \"Fields\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 11,\r\n"
			+ "            \"email\": \"george.edwards@reqres.in\",\r\n"
			+ "            \"first_name\": \"George\",\r\n"
			+ "            \"last_name\": \"Edwards\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"id\": 12,\r\n"
			+ "            \"email\": \"rachel.howell@reqres.in\",\r\n"
			+ "            \"first_name\": \"Rachel\",\r\n"
			+ "            \"last_name\": \"Howell\",\r\n"
			+ "            \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
			+ "        }\r\n"
			+ "    ]\r\n"
			+ "}";
			
//	JsonReader reader = new JsonReader(new StringReader(userList));
		
	@Test
	public void userVal() {
		
//		reader.setLenient(true);
		
		JsonObject dataList = new JsonParser().parse(userList).getAsJsonObject();
		
		JsonArray jsonArray = new JsonArray();
		
		JsonArray user = dataList.getAsJsonArray("data");
		
		System.out.println(dataList);
		
		System.out.println(user);
		
		for (int i = 0; i < user.size(); i++) {
			
			JsonElement jsontest = user.get(i);
			
			System.out.println(jsontest);
			
		}
			
		for (JsonElement element : user) {
				
				jsonArray.add(element);
				
		}
		
		System.out.println(jsonArray);
		
		ResponseData person = prj.fromJson(userList, ResponseData.class);
		
		System.out.println(person.getData().get(0).getId());
		

		
	}
	
}
