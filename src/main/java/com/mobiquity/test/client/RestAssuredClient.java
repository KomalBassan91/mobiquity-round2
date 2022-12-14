package com.mobiquity.test.client;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient extends RestAssured {

    public String baseUrl;

    public RestAssuredClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }



    public Response httpGet(String url) {
        RequestSpecification httpGet = RestAssured.given().log().uri();
        httpGet.baseUri(baseUrl);
        httpGet.header("Content-Type", "application/json");
        return httpGet.get(url);
    }

}
