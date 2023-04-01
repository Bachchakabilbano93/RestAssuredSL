package com.RestAssuredAPI;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.RestAssured.constants.ReqresEndpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseReqres {
	
	protected static Logger logReqres = LogManager.getLogger(BaseReqres.class.getName());
	
	protected RequestSpecification reqResDir = new RequestSpecBuilder().setBaseUri(ReqresEndpoints.baseUrl).setAccept(ContentType.JSON).build().log().all();
	
	protected RequestSpecification reqResAdd = new RequestSpecBuilder().setBaseUri(ReqresEndpoints.baseUrl).setAccept(ContentType.JSON).setContentType(ContentType.JSON).build().log().all();

}
